import java.util.*;

class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> ans = new ArrayList<>();

        int start = 0;

        while (start < words.length) {

            int end = start;
            int wordLength = 0;

            // Find how many words can fit in this line
            while (end < words.length) {

                int newLength = wordLength + words[end].length();

                if (end > start) {
                    newLength += (end - start);
                }

                if (newLength > maxWidth) {
                    break;
                }

                wordLength += words[end].length();
                end++;
            }

            int numberOfWords = end - start;

            StringBuilder line = new StringBuilder();

            // Last line
            if (end == words.length) {

                for (int i = start; i < end; i++) {

                    if (i > start) {
                        line.append(" ");
                    }

                    line.append(words[i]);
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }

            }

            // Line containing only one word
            else if (numberOfWords == 1) {

                line.append(words[start]);

                while (line.length() < maxWidth) {
                    line.append(" ");
                }

            }

            // Fully justified line
            else {

                int gaps = numberOfWords - 1;

                int totalSpaces = maxWidth - wordLength;

                int spaces = totalSpaces / gaps;

                int extra = totalSpaces % gaps;

                for (int i = start; i < end; i++) {

                    line.append(words[i]);

                    if (i < end - 1) {

                        int currentSpaces = spaces;

                        if (i - start < extra) {
                            currentSpaces++;
                        }

                        for (int j = 0; j < currentSpaces; j++) {
                            line.append(" ");
                        }
                    }
                }
            }

            ans.add(line.toString());

            start = end;
        }

        return ans;
    }
}
class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        int[] count = new int[128];

        // Count characters required in t
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i)]++;
        }

        int left = 0;
        int required = t.length();

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            // Character is needed
            if (count[c] > 0) {
                required--;
            }

            count[c]--;

            // Current window contains all characters of t
            while (required == 0) {

                // Check if this is the smallest window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                // Remove the character at left
                count[s.charAt(left)]++;

                // Window is no longer valid
                if (count[s.charAt(left)] > 0) {
                    required++;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}

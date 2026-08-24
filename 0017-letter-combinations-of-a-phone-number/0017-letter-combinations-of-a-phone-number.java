import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        String[] phone = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(digits, 0, new StringBuilder(), result, phone);

        return result;
    }

    private void backtrack(String digits, int index,
                           StringBuilder current,
                           List<String> result,
                           String[] phone) {

        // All digits processed
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters corresponding to current digit
        String letters = phone[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {

            // Choose
            current.append(c);

            // Explore
            backtrack(digits, index + 1, current, result, phone);

            // Undo choice
            current.deleteCharAt(current.length() - 1);
        }
    }
}
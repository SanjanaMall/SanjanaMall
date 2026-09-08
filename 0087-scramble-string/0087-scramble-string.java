class Solution {

    String s1;
    String s2;
    byte[][][] memo;

    public boolean isScramble(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        this.s1 = s1;
        this.s2 = s2;

        int n = s1.length();

        // memo[i][j][len]
        // 0 = not calculated
        // 1 = true
        // 2 = false
        memo = new byte[n][n][n + 1];

        return solve(0, 0, n);
    }

    private boolean solve(int i, int j, int len) {

        // Already calculated
        if (memo[i][j][len] != 0) {
            return memo[i][j][len] == 1;
        }

        // If the substrings are already equal
        if (s1.substring(i, i + len).equals(s2.substring(j, j + len))) {
            memo[i][j][len] = 1;
            return true;
        }

        // Check if both substrings contain the same characters
        int[] freq = new int[26];

        for (int k = 0; k < len; k++) {
            freq[s1.charAt(i + k) - 'a']++;
            freq[s2.charAt(j + k) - 'a']--;
        }

        for (int x : freq) {
            if (x != 0) {
                memo[i][j][len] = 2;
                return false;
            }
        }

        // Try every possible split
        for (int split = 1; split < len; split++) {

            // Case 1: No swap
            if (solve(i, j, split) &&
                solve(i + split, j + split, len - split)) {

                memo[i][j][len] = 1;
                return true;
            }

            // Case 2: Swap
            if (solve(i, j + len - split, split) &&
                solve(i + split, j, len - split)) {

                memo[i][j][len] = 1;
                return true;
            }
        }

        memo[i][j][len] = 2;
        return false;
    }
}

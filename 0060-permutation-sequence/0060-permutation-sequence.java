import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();

        // Store numbers 1 to n
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        // Factorials
        int[] fact = new int[n + 1];
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        // Convert k to 0-based indexing
        k--;

        StringBuilder result = new StringBuilder();

        for (int i = n; i >= 1; i--) {
            // Size of each block
            int blockSize = fact[i - 1];

            // Find which block k belongs to
            int index = k / blockSize;

            // Select that number
            result.append(nums.get(index));
            nums.remove(index);

            // Remaining position inside the block
            k %= blockSize;
        }

        return result.toString();
    }
}
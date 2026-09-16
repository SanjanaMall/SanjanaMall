class Solution {
    public int removeDuplicates(int[] nums) {

        int k = 0;

        for (int num : nums) {

            // First two elements can always be kept
            // or keep num if it is different from nums[k - 2]
            if (k < 2 || num != nums[k - 2]) {
                nums[k] = num;
                k++;
            }
        }

        return k;
    }
}
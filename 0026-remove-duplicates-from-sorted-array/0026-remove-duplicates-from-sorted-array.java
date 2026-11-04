
class Solution {
    public int removeDuplicates(int[] nums) {

        int k = 1;  // Position where the next unique element will be placed

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}

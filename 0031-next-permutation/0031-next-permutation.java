class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // Find the first element from the right
        // that is smaller than the element after it
        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // If such an element exists
        if (i >= 0) {
            int j = n - 1;

            // Find the element just larger than nums[i]
            while (nums[j] <= nums[i]) {
                j--;
            }

            // Swap
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // Reverse the part after i
        int left = i + 1;
        int right = n - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}
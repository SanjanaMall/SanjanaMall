class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];

        int[] deque = new int[n];

        int front = 0;
        int rear = -1;

        int resultIndex = 0;

        for (int i = 0; i < n; i++) {

            if (front <= rear && deque[front] <= i - k) {
                front++;
            }


            while (front <= rear && nums[deque[rear]] <= nums[i]) {
                rear--;
            }

            rear++;
            deque[rear] = i;

            if (i >= k - 1) {
                result[resultIndex] = nums[deque[front]];
                resultIndex++;
            }
        }

        return result;
    }
}


class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        int maxArea = 0;

        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for(int i = 0; i <= n; i++){

            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > currentHeight){

                int height = heights[stack.pop()];

                int width;

                if (stack.isEmpty()){
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
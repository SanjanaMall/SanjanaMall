class Solution {

    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {

            // Convert current row into histogram heights
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, largestRectangle(heights));
        }

        return maxArea;
    }

    private int largestRectangle(int[] heights) {

        int n = heights.length;
        int maxArea = 0;

        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int i = 0; i <= n; i++) {

            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() &&
                   heights[stack.peek()] > currentHeight) {

                int h = heights[stack.pop()];

                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(maxArea, h * width);
            }

            // Don't push the artificial index n
            if (i < n) {
                stack.push(i);
            }
        }

        return maxArea;
    }
}
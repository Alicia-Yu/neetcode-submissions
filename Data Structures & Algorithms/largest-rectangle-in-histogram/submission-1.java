class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <=n; i ++) {
            while(!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])) {
                int height = heights[stack.pop()];
                int width = 0;
                if (stack.isEmpty()) {
                    width = i; 
                } else {
                    width = i - stack.peek() -1; 
                }
                max = Math.max(max, height * width); 
            }
            stack.push(i); 
        }
        return max; 
    }
}

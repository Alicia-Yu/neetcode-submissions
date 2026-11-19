class Solution {
    int [][] directions = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int r = 0; r < row; r ++) {
            for (int c = 0; c < col; c ++) {
                if (grid[r][c] == 1) {
                    max = Math.max(max, bfs(grid, r, c));
                }
            }
        }
        return max;
    }

    private int bfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0){
            return 0;
        }

        grid[r][c] = 0;
        int res = 1;
        for (int[] dir : directions) {
            res += bfs(grid, r + dir[0], c + dir[1]);
        }
        return res; 
        
    }
}

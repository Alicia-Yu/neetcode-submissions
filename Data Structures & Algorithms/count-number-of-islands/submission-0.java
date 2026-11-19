class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int islands = 0;

        for (int r = 0; r < row; r ++) {
            for (int c = 0; c < col; c ++) {
                if (grid[r][c] == '1') {
                    bfs(grid, r, c);
                    islands ++;
                }
            }
        }
        return islands; 

    }

    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>(); 
        grid[r][c] = '0';
        q.add(new int[]{r, c});
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int rows = node[0];
            int cols = node[1];
            for (int[] dir : directions) {
                int nr = rows + dir[0];
                int nc = cols + dir[1];
                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1') {
                    q.add(new int[] {nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }
}

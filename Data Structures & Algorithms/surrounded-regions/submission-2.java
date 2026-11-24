class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;
        for (int r = 0; r < ROWS; r ++) {
            if(board[r][0] == 'O') {
                dfs(board, r, 0, ROWS, COLS);
            }
            if(board[r][COLS - 1] == 'O') {
                dfs(board, r, COLS - 1, ROWS, COLS); 
            }
        }
        for (int c = 0; c < COLS; c ++) {
            if(board[0][c] == 'O') {
                dfs(board, 0, c, ROWS, COLS);
            }
            if(board[ROWS - 1][c] == 'O') {
                dfs(board, ROWS - 1, c, ROWS, COLS); 
            }
        }

        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O'; 
                }
            }
        }
    }

    private void dfs (char[][] board, int r, int c, int ROWS, int COLS) {
        if (board[r][c] != 'O' || (r < 0 || r >= ROWS || c < 0 || c >= COLS )) {
            return; 
        }
        board[r][c] = 'T';
        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS) {
                dfs(board, nr, nc, ROWS, COLS); 
            }
        }              
    }
}

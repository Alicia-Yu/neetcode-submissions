class Solution {
    public boolean exist(char[][] board, String word) {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (backtrack(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack (char[][] board, String word, int r, int c, int i) {
        if (i == word.length()) {
            return true; 
        }
        if (r >= board.length || c >= board[0].length || r < 0 || c < 0) {
            return false;
        }
        if (board[r][c] != word.charAt(i)) {
            return false;
        }
        char temp = board[r][c];
        board[r][c] = '#';
        boolean found = backtrack(board, word, r + 1, c, i + 1)
                        || backtrack(board, word, r - 1, c, i + 1)
                        || backtrack(board, word, r, c + 1, i + 1)
                        || backtrack(board, word, r, c - 1, i + 1);
        board[r][c] = temp;
        return found; 
        
    }

}

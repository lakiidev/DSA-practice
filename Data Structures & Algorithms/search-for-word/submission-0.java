class Solution {
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (dfs(board, word, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, int row, int col, int index) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
            || board[row][col] != word.charAt(index)) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }
        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = dfs(board, word, row+1, col, index + 1) || dfs(board, word, row-1, col, index + 1)
            || dfs(board, word, row, col+1, index + 1) || dfs(board, word, row, col-1, index + 1);
        
        board[row][col] = temp;
        return found;
    }
}

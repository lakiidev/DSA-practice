class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int c=0;c<n;c++)
        {
            if(board[0][c]=='O') dfs(board,0,c);
            if(board[m-1][c]=='O') dfs(board,m-1,c);
        }
        for(int r=0;r<m;r++)
        {
            if(board[r][0]=='O') dfs(board,r,0);
            if(board[r][n-1]=='O') dfs(board,r,n-1);
        }


        //reverting back
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                else if (board[r][c] == 'T') board[r][c] = 'O';
            }
        }
    }

    private void dfs(char [][] board,int r,int c)
    {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length ||
            board[r][c] != 'O') return;

        board[r][c] = 'T';
        for (int[] dir : directions) {
            dfs(board, r + dir[0], c + dir[1]);
        }
    }
}

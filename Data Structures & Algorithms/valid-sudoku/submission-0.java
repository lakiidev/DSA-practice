class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
        for(int i=0;i<9;i++)
        {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++)
            {
                char value = board[r][c];
                if(value=='.') continue;
                int boxIndex = (r / 3) * 3 + (c / 3);

                 if (!rows[r].add(value)) return false;
                 if (!cols[c].add(value)) return false;
                 if (!boxes[boxIndex].add(value)) return false;
            }
        }
        return true;
    }
}

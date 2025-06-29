/*
*
*You are given a 9 x 9 Sudoku board. A Sudoku board is valid if the following rules are followed:

Each row must contain the digits 1-9 without duplicates.
Each column must contain the digits 1-9 without duplicates.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without duplicates.
Return true if the Sudoku board is valid, otherwise return false

Note: A board does not need to be full or be solvable to be valid.
* Constraints:
* board.length == 9
* board[i].length == 9
* board[i][j] is a digit 1-9 or '.'.
* */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean isValid = true;
        for(int i = 0; i < 9; i++)
        {
            for(int  j = 0; j < 9; j++)
            {
                if(board[i][j] != '.')
                {
                    char ch = board[i][j];
                    //check for row
                    for(int k = 0; k < 9; k++)
                    {
                        if(ch == board[k][j] && i!=k)
                        {
                            isValid = false;
                            break;
                        }
                    }
                    // check for column
                    for(int k = 0; k < 9; k++)
                    {
                        if(ch == board[i][k] && j!=k)
                        {
                            isValid = false;
                            break;
                        }
                    }
                    // check for small 3 x 3 square
                    int block_i = (i/3)*3;
                    int block_j = (j/3)*3;
                    for(int k = 0; k < 3; k++)
                    {
                        for(int l = 0; l < 3; l++) {
                            if (board[block_i + k][block_j + l] == ch && i != block_i + k && j != block_j + l) {
                                isValid = false;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return isValid;
    }
}

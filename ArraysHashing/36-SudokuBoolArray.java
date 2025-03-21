// question link: https://leetcode.com/problems/valid-sudoku/

package ArraysHashing;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        boolean[][] seenRow = new boolean[9][9];
        boolean[][] seenCol = new boolean[9][9];
        boolean[][] seenBox = new boolean[9][9];

        for (int row = 0; row < 9; row++) {

            for (int column = 0; column < 9; column++) {

                if (board[row][column] == '.') {
                    continue;
                }

                int box = ((row / 3) * 3) + column / 3;
                int digit = board[row][column] - '1';

                if (seenRow[digit][row] == true) {
                    return false;
                } else {
                    seenRow[digit][row] = true;
                }

                if (seenCol[digit][column] == true) {
                    return false;
                } else {
                    seenCol[digit][column] = true;
                }

                if (seenBox[digit][box] == true) {
                    return false;
                } else {
                    seenBox[digit][box] = true;
                }

            }

        }

        return true;

    }
}
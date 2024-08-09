// 840. Magic Squares In Grid
// https://leetcode.com/problems/magic-squares-in-grid/description/
// A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.

// Given a row x col grid of integers, how many 3 x 3 contiguous magic square subgrids are there?

// Note: while a magic square can only contain numbers from 1 to 9, grid may contain numbers up to 15.

// Example 1:

// Input: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]]
// Output: 1
// Explanation: 
// The following subgrid is a 3 x 3 magic square:

// while this one is not:

// In total, there is only one magic square inside the given grid.
// Example 2:

// Input: grid = [[8]]
// Output: 0

// Constraints:

// row == grid.length
// col == grid[i].length
// 1 <= row, col <= 10
// 0 <= grid[i][j] <= 15

// Solution : 

class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int r = 0; r <= rows - 3; r++) {
            for (int c = 0; c <= cols - 3; c++) {
                if (isMagicSquare(grid, r, c)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMagicSquare(int[][] grid, int r, int c) {
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[r + i][c + j];
                if (num < 1 || num > 9 || seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }
        int sum1 = grid[r][c] + grid[r][c + 1] + grid[r][c + 2];
        int sum2 = grid[r + 1][c] + grid[r + 1][c + 1] + grid[r + 1][c + 2];
        int sum3 = grid[r + 2][c] + grid[r + 2][c + 1] + grid[r + 2][c + 2];

        if (sum1 != 15 || sum2 != 15 || sum3 != 15)
            return false;

        int colSum1 = grid[r][c] + grid[r + 1][c] + grid[r + 2][c];
        int colSum2 = grid[r][c + 1] + grid[r + 1][c + 1] + grid[r + 2][c + 1];
        int colSum3 = grid[r][c + 2] + grid[r + 1][c + 2] + grid[r + 2][c + 2];

        if (colSum1 != 15 || colSum2 != 15 || colSum3 != 15)
            return false;

        int diag1 = grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2];
        int diag2 = grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c];

        return diag1 == 15 && diag2 == 15;
    }
}
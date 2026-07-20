// ═══════════════════════════════════════════════════════
// Problem: 1386. Shift 2D Grid
// Difficulty: Easy
// Topics: Array, Matrix, Simulation
// Runtime: 5 ms (Beats 83.4%)
// Memory: 47.4 MB (Beats 26.2%)
// Submitted: Jul 20, 2026
// Link: https://leetcode.com/problems/shift-2d-grid/
// ═══════════════════════════════════════════════════════

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] rotatedGrid = new int[row][col];
        List<List<Integer>> rotatedList = new ArrayList<>();

        int rotation = k % (row * col);
        rotation = rotation > 0 ? rotation : row * col + rotation;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                int currCol = (j + rotation) % col;
                int currRow = (i + (j + rotation) / col) % row;

                rotatedGrid[currRow][currCol] = grid[i][j];
            }
        }

        for (int i = 0; i < row; i++) {
            List<Integer> rowList = new ArrayList<>();

            for (int j = 0; j < col; j++) {
                rowList.add(rotatedGrid[i][j]);
            }

            rotatedList.add(rowList);
        }

        return rotatedList;
    }
}

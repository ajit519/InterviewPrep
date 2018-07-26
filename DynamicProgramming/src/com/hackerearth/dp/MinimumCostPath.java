package com.hackerearth.dp;

public class MinimumCostPath {

    public static void main(String[] args) {
        String filePath = "C:\\LearningLabs\\DS\\DynamicProgramming\\minimumcostpath.txt";
        int[][] grid = IOUtils.getInput(filePath, ",");
        System.out.println(findMinimumCostPath(grid));
    }

    private static int findMinimumCostPath(int[][] grid) {

        int row = grid.length;

        int column = grid[0].length;

        System.out.println("Row " + row + " Column " + column);

        // Add cost to move from left to right for first row.
        for (int i = 1; i < column; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        // Add cost for first column
        for (int i = 1; i < row; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[row-1][column-1];
    }
}

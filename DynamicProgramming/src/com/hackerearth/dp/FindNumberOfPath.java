package com.hackerearth.dp;

public class FindNumberOfPath {

    public static void main(String[] args) {
        int[][] grid = new int[5][7];
        System.out.println(findNumberOfWays(grid));
    }

    private static int findNumberOfWays(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;

        for (int i = 1; i < column; i++) {
            grid[0][i] = 1;
        }

        for (int i = 1; i < row; i++) {
            grid[i][0] = 1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }
        return grid[row-1][column-1];
    }

}

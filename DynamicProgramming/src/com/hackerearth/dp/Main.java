package com.hackerearth.dp;

public class Main {

    public static void main(String[] args) {
        String filePath = "C:\\LearningLabs\\DS\\DynamicProgramming\\input.txt";
        String delimiter = " ";
        int[][] grid = IOUtils.getInput(filePath, delimiter);
        for (int i =0; i< grid.length; i++){
            for (int j = 0; j< grid[0].length; j++){
                System.out.print(grid[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }
    }
}

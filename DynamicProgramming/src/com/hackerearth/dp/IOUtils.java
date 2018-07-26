package com.hackerearth.dp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IOUtils {

    public static int[][] getInput(String filePath, String delimiter) {

        int[][] grid = createGrid(filePath, delimiter);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            boolean isRowAndColumnSet = false;
            String line;
            String[] rowAndColumn;
            int rowIndex = 0;
            while ((line = br.readLine()) != null) {
                if (!isRowAndColumnSet) {
                    isRowAndColumnSet = true;
                } else {
                    rowAndColumn = line.split(delimiter);
                    for (int i = 0; i < rowAndColumn.length; i++) {
                        grid[rowIndex][i] = Integer.parseInt(rowAndColumn[i]);
                    }
                    rowIndex++;
                }
            }
        } catch (IOException e) {
           System.err.println("Exception while creating grid " + e );
        }
        return grid;
    }

    private static int[][] createGrid(String filePath, String delimiter) {

        int[][] grid;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] rowAndColumn = line.split(delimiter);
                grid = new int[Integer.parseInt(rowAndColumn[0])][Integer.parseInt(rowAndColumn[1])];
                return grid;
            }
        } catch (IOException e) {
            System.err.println("Exception while fetching row and column " + e);
        }
        return null;
    }
}

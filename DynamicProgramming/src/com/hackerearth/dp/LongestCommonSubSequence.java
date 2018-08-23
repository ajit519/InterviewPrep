package com.hackerearth.dp;

public class LongestCommonSubSequence {

    public static void main(String[] args) {
        //String s1 = "adbefkjh";
        //String s2 = "abfghk";

        String s1 = "abdace";
        String s2 = "babce";

        LongestCommonSubSequence subSequence = new LongestCommonSubSequence();
        System.out.println(subSequence.findLongestCommonSubSequence(s1, s2));
    }

    public String findLongestCommonSubSequence(String s1, String s2) {
        int row = s2.length();
        int column = s1.length();
        row = row + 1;
        column = column + 1;
        int[][] grid = new int[row][column];

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (s2.charAt(i - 1) == s1.charAt(j - 1)) {
                    grid[i][j] = grid[i - 1][j - 1] + 1;
                } else {
                    grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }

        MaxDetails maxDetails = getMaxDetails(grid);
        System.out.println(maxDetails);
        StringBuilder sb = new StringBuilder();

        row = maxDetails.getX();
        column = maxDetails.getY();
        while (row > 0 && column > 0) {
            if (grid[row - 1][column] == grid[row][column - 1] && grid[row][column - 1] == grid[row - 1][column - 1]
                    && grid[row - 1][column - 1] != grid[row][column]) {
                sb.append(s2.charAt(row - 1));
                row--;
                column--;
            }else if (grid[row - 1][column] == grid[row][column - 1] && grid[row][column - 1] == grid[row - 1][column - 1]
                    && grid[row - 1][column - 1] == grid[row][column]) {
                row--;
                column--;
            } else if (grid[row - 1][column] == grid[row][column - 1]) {
                boolean columnChanged = false;
                boolean rowChanged = false;
                int tempColumn = column - 2;
                int tempRow = row - 2;
                while (tempColumn > 0) {
                    if (grid[row][column] != grid[row][tempColumn]) {
                        break;
                    }
                    columnChanged = true;
                    tempColumn--;
                }

                while (tempRow > 0) {
                    if (grid[row][column] != grid[row][tempRow]) {
                        break;
                    }
                    rowChanged = true;
                    tempRow--;
                }
                column = column - 1;
                if (columnChanged) {
                    column = tempColumn - 1;
                }
                row = row - 1;
                if (rowChanged) {
                    row = tempRow - 1;
                }
            } else if (grid[row - 1][column] == grid[row][column - 1] &&
                    grid[row][column] != grid[row - 1][column - 1]) {
                sb.append(s2.charAt(row - 1));
                row--;
                column--;
            } else if (grid[row][column] == grid[row][column - 1]) {
                column--;
            } else if (grid[row][column] == grid[row - 1][column]) {
                row--;
            }
        }

        return sb.reverse().toString();

    }


    private MaxDetails getMaxDetails(int[][] grid) {
        MaxDetails maxDetails = new MaxDetails();
        int row = grid.length;
        int column = grid[0].length;

        for (int i = 1; i < column; i++) {
            if (maxDetails.getMax() < grid[row - 1][i]) {
                maxDetails.setMax(grid[row - 1][i]);
                maxDetails.setX(row - 1);
                maxDetails.setY(i);
            }
        }

        return maxDetails;
    }


}

class MaxDetails {
    private int max;
    private int x;
    private int y;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "MaxDetails{" +
                "max=" + max +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}

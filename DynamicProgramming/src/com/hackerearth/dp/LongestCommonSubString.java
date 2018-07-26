package com.hackerearth.dp;

public class LongestCommonSubString {

    public static void main(String[] args) {

        LongestCommonSubString longestCommonSubString = new LongestCommonSubString();
        String s1 = "acdefgk";
        String s2 = "cdefkh";

        String output = longestCommonSubString.findLongestCommonSubString(s1, s2);
        System.out.println(output);
    }

    public String findLongestCommonSubString(String s1, String s2) {
        int length = s1.length();
        int length1 = s2.length();

        int[][] grid = new int[length][length1];

        for (int i = 1; i < length; i++) {
            for (int j = 1; j < length1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    grid[i][j] = grid[i - 1][j - 1] + 1;
                } else {
                    grid[i][j] = 0;
                }
            }
        }

        MaxDetails max = findMax(grid);

        return getString(grid, max, s1);
    }

    private MaxDetails findMax(int[][] grid) {
        MaxDetails max = new MaxDetails();
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if (max.getMax() < grid[i][j]) {
                    max = new MaxDetails(grid[i][j], i, j);
                }
            }
        }
        return max;
    }

    private String getString(int[][] grid, MaxDetails maxDetails, String s) {
        StringBuilder sb = new StringBuilder();
        int x = maxDetails.getX();
        int y = maxDetails.getY();
        while (grid[x][y] != 0) {
            sb.append(s.charAt(x-1));
            x--;
            y--;
        }

        return sb.reverse().toString();
    }

    class MaxDetails {
        private int max;
        private int x;
        private int y;

        public MaxDetails() {
        }

        public MaxDetails(int max, int x, int y) {
            this.max = max;
            this.x = x;
            this.y = y;
        }

        public int getMax() {
            return max;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
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
}

package com.hackerearth.dp;

import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class FindNumberOfPathInBlocking {
    public static void main(String[] args) {

        String path = "C:\\LearningLabs\\DS\\DynamicProgramming\\minimumcostpathwithblocking.txt";
        int[][] grid = IOUtils.getInput(path, " ");
        System.out.println(findPath(grid));

        FindNumberOfPathInBlocking object = new FindNumberOfPathInBlocking();
        object.printPath(grid);
    }

    private static int findPath(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;

        for (int i = 0; i < row; i++) {
            if (grid[i][0] == -1) {
                continue;
            } else {
                grid[i][0] = 1;
            }
        }

        for (int i = 0; i < column; i++) {
            if (grid[0][i] == -1) {
                continue;
            } else {
                grid[0][i] = 1;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (grid[i][j] == -1) {
                    continue;
                } else if (grid[i - 1][j] == -1 && grid[i][j - 1] == -1) {
                    grid[i][j] = -1;
                } else if (grid[i - 1][j] != -1 && grid[i][j - 1] != -1) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                } else if (grid[i - 1][j] != -1 || grid[i][j - 1] != -1) {
                    grid[i][j] = grid[i - 1][j] != -1 ? grid[i - 1][j] : grid[i][j - 1];
                }
            }
        }

        return grid[row - 1][column - 1];
    }

    private void printPath(int[][] grid) {
        LinkedList<Point> paths = new LinkedList<>();

        int row = grid.length;
        int column = grid[0].length;

        paths.add(new Point(row - 1, column - 1));

        while (!paths.isEmpty()) {
            Point point = paths.poll();
            System.out.println(point);
            if (point.getX() == 0 && point.getY() == 0) {
                break;
            }
            addPath(point, grid, paths);
        }
    }

    private void addPath(Point point, int[][] grid, LinkedList<Point> path) {

        if (point.getX() == 0 && grid[point.getX()][point.getY() - 1] != -1) {
            path.add(new Point(point.getX(), point.getY() - 1));
        } else if (point.getY() == 0 && grid[point.getX() - 1][point.getY()] != -1) {
            path.add(new Point(point.getX() - 1, point.getY()));
        } else if (grid[point.getX()][point.getY() - 1] != -1 && grid[point.getX() - 1][point.getY()] != -1) {
            path.add(new Point(point.getX(), point.getY() - 1));
            path.add(new Point(point.getX() - 1, point.getY()));
        } else if (grid[point.getX()][point.getY() - 1] != -1) {
            path.add(new Point(point.getX(), point.getY() -1));
        } else if (grid[point.getX() - 1][point.getY()] != -1) {
            path.add(new Point(point.getX(), point.getY()-1));
        }
    }

    class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "Path{" +
                    "" + x +
                    ", " + y +
                    '}';
        }
    }
}

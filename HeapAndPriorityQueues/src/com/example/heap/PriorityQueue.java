package com.example.heap;

import java.util.Arrays;

public class PriorityQueue {

    public static void main(String[] args) {
        java.util.PriorityQueue<Integer> queue = new java.util.PriorityQueue<>(Arrays.asList(4, 8, 1, 7, 3));
        System.out.println(queue);
    }
}

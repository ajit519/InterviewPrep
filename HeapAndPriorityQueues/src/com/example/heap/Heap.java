package com.example.heap;

import java.util.Arrays;

public class Heap {

    public static void main(String[] args) {
        int[] input = new int[]{0, 10, 4, 34, 90, 12, 30, 43, 54, 89, 76, 20};
        int[] output = buildHeap(input);
        Arrays.stream(output).forEach(System.out::println);
    }

    private static int[] buildHeap(int[] input) {
        int length = input.length;

        for (int i = length / 2; i >= 1; i--) {
            min_heapify(input, i, length);
        }
        return input;
    }

    private static void max_heapify(int[] ar, int index, int length) {
        int left = 2 * index;
        int right = 2 * index + 1;
        int largest = index;

        if (left < length && ar[left] > ar[index]) {
            largest = left;
        }

        if (right < length && ar[right] > ar[largest]) {
            largest = right;
        }

        if (index != largest) {
            swap(ar, index, largest);
            max_heapify(ar, largest, length);
        }
    }

    private static void swap(int[] ar, int index, int largest) {
        int temp = ar[index];
        ar[index] = ar[largest];
        ar[largest] = temp;
    }

    private static void min_heapify(int[] ar, int index, int length) {
        int left = 2 * index;
        int right = 2 * index + 1;
        int smallest = index;

        if (left < length && ar[left] < ar[index]) {
            smallest = left;
        }

        if (right < length && ar[right] < ar[smallest]) {
            smallest = right;
        }

        if (index != smallest) {
            swap(ar, index, smallest);
            min_heapify(ar, smallest, length);
        }
    }
}

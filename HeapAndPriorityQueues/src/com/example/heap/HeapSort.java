package com.example.heap;

public class HeapSort {

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();

        int[] input = new int[]{0, 13, 23, 15, 60, 39, 43};
        heapSort.heapSort(input);

        for(int i = 1; i < input.length ; i++){
            System.out.println(input[i]);
        }
    }

    public void heapSort(int[] input) {
        int length = input.length;
        heapify(input, length);
        for (int i = length - 1; i >= 2; i--) {
            swap(input, 1, i);
            length = length - 1;
            heapify(input, length);
        }

    }

    private void heapify(int[] input, int length) {
        for (int i = length / 2; i >= 1; i--) {
            max_heapify(input, i, length);
        }
    }

    private void max_heapify(int[] ar, int index, int length) {
        int left = 2 * index;
        int right = 2 * index + 1;
        int largest = index;

        if (left < length && ar[left] > ar[largest]) {
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

    private void swap(int[] ar, int index, int x) {
        int temp = ar[index];
        ar[index] = ar[x];
        ar[x] = temp;
    }
}

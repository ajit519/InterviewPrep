package com.example.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindPairForKDifference {

    public static void main(String[] args) {
        int[] arrays = {5, 7, 1, 9, 2, 12, 3};
        int k = 2;

        Set<Integer> num = new HashSet<>();

        Arrays.stream(arrays).forEach(i -> num.add(i));

        Arrays.stream(arrays).forEach(i -> {
            if (num.contains(i + k)) {
                System.out.println(i + ", " + (i + k));
            }
        });

    }
}

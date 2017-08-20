package com.example.thread.livelock;

import java.util.Arrays;

public class ParallelSetAllExample {

    public static void main(String[] args) {
        int[] list = {1, 2, 3};
        Arrays.parallelSetAll(list, x -> list[x] * 100);
        System.out.println(list[0] + list[1]);
    }

}

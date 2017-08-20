package com.example.thread.livelock;

public class Joinn {

    public static void main(String[] args) throws Exception {
        Thread.currentThread().join(3000);
        System.out.println("YA");

    }
}

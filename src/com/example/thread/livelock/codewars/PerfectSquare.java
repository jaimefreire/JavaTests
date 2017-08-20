package com.example.thread.livelock.codewars;

public class PerfectSquare {

    public static void main(String[] args) {

        int d=25;

        double root = Math.sqrt(d);

        int a = root % 1 == 0 ? (int) Math.pow(root + 1, 2) : -1;
        System.out.println(a);
        }
    }


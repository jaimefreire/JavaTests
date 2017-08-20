package com.example.thread.livelock.codewars;

public class Numbers {

    public static void main(String[] args) {

        System.out.println(Numbers.createPhoneNumber(new int[]{1,2,3,4,5,6,7,8,9,0}));
    }


    static String createPhoneNumber(int[] input)
    {
    //Format is (123) 456-7890
    return "("+input[0]+input[1]+input[2]+") "+input[3]+input[4]+input[5]+"-"+input[6]+input[7]+input[8]+input[9];
    }
}

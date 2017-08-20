package com.example.thread.livelock.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReversePolishWrongDataStructure {

    public static void main(String[] args) {

        //String one = "1 2 +";
        String one="5 1 2 + 4 * + 3 -";
        //List<String> list = Arrays.asList(one.split(" "));

        char[] input = one.toCharArray();
        for (int i = 0; i < input.length; i++) {
            int d1, d2;
            char op;
            int res=0;
            //OP
            if (!Character.isDigit(input[i]) && input[i]!=' ') {
                op = input[i];
                d2 = Character.digit(input[i - 4], 10);
                d1 = Character.digit(input[i - 2], 10);
                switch (op) {
                    case '+':
                        res = d1 + d2;
                        break;
                    case '*':
                        res = d1 * d2;
                        break;
                    case '-':
                        res = d1 - d2;
                        break;
                    case '/':
                        res = d1 / d2;
                        break;
                    default:
                        System.err.println("ERROR!");
                }
                input[i-4] = ' ';
                input[i-2] = ' ';
                input[i] = Character.forDigit(res,10);
            }
        }
        System.out.println("Input: " +input[input.length-1]);

    }


}

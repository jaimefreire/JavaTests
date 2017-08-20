package com.example.thread.livelock.codewars;

import org.junit.Assert;

import java.util.*;
import java.util.stream.Stream;

public class ReversePolish {

    public static void main(String[] args) {

        Assert.assertTrue("NOPE", 3.0 == ReversePolish.evaluate("1 2 +"));
        Assert.assertTrue("NOPE", 14.0 == ReversePolish.evaluate("5 1 2 + 4 * + 3 -"));
        Assert.assertTrue("NOPE", 3.0 == ReversePolish.evaluate("1 2 3"));
        Assert.assertTrue("NOPE: " + ReversePolish.evaluate("101 99")
                , 200.0 == ReversePolish.evaluate("101 99 +"));
        Assert.assertTrue("NOPE: "
                , 201.0 == ReversePolish.evaluate("101.3 99.7 +"));

        Assert.assertTrue("NOPE: "
                , Math.abs(99.7 - ReversePolish.evaluate("101.3 99.7"))<0.01);


    }

    public static double evaluate(String input) {

        //Why use a char array if you know there's a space between tokens..
        char[] one = input.toCharArray();

        //Use a queue and read elements, if it's a number push, if it's an op operate with next two elements.
        Deque<Float> stack = new ArrayDeque<>();
        for (int i = 0; i < one.length; i++) {
            if (one[i] == ' ') continue;

            if (Character.isDigit(one[i])) {
                String number = "" + one[i];

                for (int j = i + 1; j < one.length; j++) {
                    if (Character.isDigit(one[j])) {
                        number += "" + one[j];
                    }
                    else{
                        break;
                    }
                }
                //Last
                if (number != "") {
                    stack.push(Float.parseFloat(number));
                    i += number.length()-1;

                }
            } else {

                float op2, op1;

                switch (one[i]) {
                    case '+':
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case '*':
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case '-':
                        op2 = stack.pop();
                        op1 = stack.pop();
                        stack.push(op1 - op2);
                        break;
                    case '/':
                        op2 = stack.pop();
                        op1 = stack.pop();
                        stack.push(op1 / op2);
                        break;
                    case '.':
                        op2 = stack.pop();
                        op1 = Character.digit(one[i + 1],10);
                        stack.push(Float.valueOf("" + (int) op2 + "." + (int) op1));
                        i++;
                        break;

                    default:
                        System.err.println("ERROR!");
                }
            }

        }
        return stack.pop();
    }

}

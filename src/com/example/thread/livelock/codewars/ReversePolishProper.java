package com.example.thread.livelock.codewars;

import org.junit.Assert;

import java.util.*;
import java.util.stream.Stream;

public class ReversePolishProper {

    public static void main(String[] args) {

        Assert.assertTrue("NOPE", 3.0 == ReversePolishProper.evaluate("1 2 +"));
        Assert.assertTrue("NOPE", -4.0 == ReversePolishProper.evaluate("1 5 -"));
        Assert.assertTrue("NOPE", 4.0 == ReversePolishProper.evaluate("5 1 -"));
        Assert.assertTrue("NOPE", 14.0 == ReversePolishProper.evaluate("5 1 2 + 4 * + 3 -"));
        Assert.assertTrue("NOPE", 3.0 == ReversePolishProper.evaluate("1 2 3"));
        Assert.assertTrue("NOPE: " + ReversePolishProper.evaluate("101 99")
                , 200.0 == ReversePolishProper.evaluate("101 99 +"));
        Assert.assertTrue("NOPE: "
                , 201.0 == ReversePolishProper.evaluate("101.3 99.7 +"));

        Assert.assertTrue("NOPE: "
                , Math.abs(99.7 - ReversePolishProper.evaluate("101.3 99.7")) < 0.01);


    }

    public static double evaluate(String input) {

        //Why use a char array if you know there's a space between tokens..
        List<String> one = Arrays.asList(input.split(" "));
        Deque<Double> stack = new ArrayDeque<Double>();

        for (String o : one) {
            double op1, op2;

            switch (o) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "-":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 - op2);
                    break;
                case "/":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 / op2);
                    break;
                default:
                    stack.push(Double.parseDouble(o));
            }
        }
        return stack.pop();
    }

}

package com.example.thread.livelock.codewars;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JadenCase {

    public static void main(String[] args) {

        String s = "my tennis is fenomenal";

        Stream ss = Arrays.stream(s.split(" "));

        System.out.println(Arrays.stream(s.split(" ")).map(m -> m.replace(m.charAt(0), Character.toUpperCase(m.charAt(0)))).collect(Collectors.joining(" ")));
    }
}

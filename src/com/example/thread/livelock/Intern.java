package com.example.thread.livelock;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Intern {

    public static void main(String[] args) {

        String t = "Hala";
        String s = "Hola".intern();

        System.out.println("Hola".equals(s));
        System.out.println("Hola"==s);
        //
        System.out.println("Hala".equals(t));
        System.out.println("Hala"==t);

        System.out.println("sout: " + Double.valueOf("12.64").intValue());

        //Stream
        Stream<Integer> stream = Stream.of(1,2,3,4);
        Stream<Integer> streamz = Stream.of(1,2,3,4);
        System.out.println(stream.map(i -> Integer.toString(i)).collect(Collectors.toList()));
        System.out.println(streamz.flatMap(i -> Stream.of(Integer.toString(i))).collect(Collectors.toList()));



    }
}

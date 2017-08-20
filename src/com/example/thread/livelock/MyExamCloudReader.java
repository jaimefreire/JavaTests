package com.example.thread.livelock;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static java.lang.System.out;

public class MyExamCloudReader {

    public static void main(String[] args) {
        int i = 123;

        try {
            FileInputStream iin = new FileInputStream("te3st.txt");
            ObjectInputStream iiin = new ObjectInputStream(iin);
            System.out.println("iiin: " + iiin.readInt());
//          System.out.println("iin: " + iin.read());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

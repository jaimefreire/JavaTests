package com.example.thread.livelock;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class MyExamCloud {

    public static void main(String[] args) {
        int i = 2432;

        try(
            FileOutputStream out = new FileOutputStream("te3st.txt");
            ObjectOutputStream oout = new ObjectOutputStream(out);
        ){

            //oout.writeObject(i);
            oout.writeInt(i);
            oout.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

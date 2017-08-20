package com.example.thread.livelock.codewars;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class EncryptDecrypt {

    public static void main(String[] args) {

        assertEquals("This kata is very interesting!", EncryptDecrypt.decrypt("hskt svr neetn!Ti aai eyitrsig", 1));

        assertEquals("This is a test!", EncryptDecrypt.decrypt("This is a test!", 0));


        // assertEquals("expected", "actual");
        assertEquals("This is a test!", EncryptDecrypt.encrypt("This is a test!", 0));
        assertEquals("hsi  etTi sats!", EncryptDecrypt.encrypt("This is a test!", 1));
        assertEquals("s eT ashi tist!", EncryptDecrypt.encrypt("This is a test!", 2));
        assertEquals(" Tah itse sits!", EncryptDecrypt.encrypt("This is a test!", 3));
        assertEquals("This is a test!", EncryptDecrypt.encrypt("This is a test!", 4));
        assertEquals("This is a test!", EncryptDecrypt.encrypt("This is a test!", -1));
        assertEquals("hskt svr neetn!Ti aai eyitrsig", EncryptDecrypt.encrypt("This kata is very interesting!", 1));


        assertEquals("This is a test!", EncryptDecrypt.decrypt("This is a test!", 0));
        assertEquals("This is a test!", EncryptDecrypt.decrypt("hsi  etTi sats!", 1));
        assertEquals("This is a test!", EncryptDecrypt.decrypt("s eT ashi tist!", 2));
        assertEquals("This is a test!", EncryptDecrypt.decrypt(" Tah itse sits!", 3));
        assertEquals("This is a test!", EncryptDecrypt.decrypt("This is a test!", 4));
        assertEquals("This is a test!", EncryptDecrypt.decrypt("This is a test!", -1));
        assertEquals("This kata is very interesting!", EncryptDecrypt.decrypt("hskt svr neetn!Ti aai eyitrsig", 1));

    }

    static String encrypt(String text, int n) {

        if (n < 1) return text;
        //
        char[] textArray = text != null ? text.toCharArray() : new char[]{};
        while (n > 0) {
            String extr = "";
            String rest = "";
            //
            for (int i = 0; i < textArray.length; i++) {
                if (i % 2 == 0)
                    extr += textArray[i];
                else
                    rest += textArray[i];
            }
            n--;
            textArray = arrayConcat(rest, extr);
        }
        return new String(textArray);
    }

    static String decrypt(String text, int n) {
        if (n < 1) return text;

        char[] textArray = text.toCharArray();


        int half = text.length() / 2;

        while (n > 0) {

            StringBuilder output = new StringBuilder();
            Iterator<String> first = Arrays.asList(text.substring(0, text.length() / 2).split("")).iterator();
            Iterator<String> last = Arrays.asList(text.substring(text.length() / 2).split("")).iterator();

            while (first.hasNext() || last.hasNext()) {
                if (last.hasNext()) output.append(last.next());
                if (first.hasNext()) output.append(first.next());
            }

            text = output.toString();
            n--;
        }
        return text;
    }

    static char[] arrayConcat(String a, String b) {
        char[] first = a.toCharArray();
        char[] second = b.toCharArray();
        char[] res = new char[first.length + second.length];
        System.arraycopy(first, 0, res, 0, first.length);
        System.arraycopy(second, 0, res, first.length, second.length);
        return res;
    }
}

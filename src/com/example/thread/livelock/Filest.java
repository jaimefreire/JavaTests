package com.example.thread.livelock;

import java.io.IOError;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Filest {

    public static void main(String[] args) {
        try (Stream<Path> files = Files.list(Paths.get(System.getProperty("user.dir")))) {
            files.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error!. " + e.getMessage());
        }
    }
}

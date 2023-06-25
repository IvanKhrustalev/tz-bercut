package org.example;

import java.io.File;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String file = "xus";
        File path = new File("D:/");
        FileSearch fileSearch = new FileSearch(file, path);
    }
}

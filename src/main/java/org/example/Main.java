package org.example;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
            System.out.println("Введите имя файла целиком или частично:\n");
            String file = sc.nextLine();
            File path = new File("C:/");
            FileSearch fileSearch = new FileSearch(file, path);
    }
}

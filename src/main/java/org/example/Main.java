package org.example;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
            System.out.println("Введите имя файла целиком или частично:\n");
            String file = sc.nextLine();
            System.out.println("Введите на каком диске хотите искать в формате *Имя диска*:/");
            String pathName = sc.nextLine();
            File path = new File(pathName);
            FileSearch fileSearch = new FileSearch(file, path);
    }
}

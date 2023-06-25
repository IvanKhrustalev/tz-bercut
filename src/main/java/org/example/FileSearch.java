package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearch implements Runnable {
    private File path;
    private String fileName;
    private List<File> foundedFiles = new ArrayList<>();
    private List<Thread> threadList = new ArrayList<>();
    private File[] files;
    private Thread thread;
    public FileSearch(String fileName, File path) {
        super();
        this.path = path;
        this.fileName = fileName;
        files = path.listFiles();
        thread = new Thread(this);
        thread.start();
    }

    public void searching(File[] files) {
        if (files == null) return;
        for (File f : files) {
            if (f.isFile() && f.getName().toLowerCase().contains(fileName.toLowerCase())) {
                System.out.println(f.getPath());
            }
            if (f.isDirectory()) {
                Thread thread1 = new Thread(new SearchingThread(f.listFiles(), this));
                thread1.start();
                threadList.add(thread1);
            }
        }
    }
    @Override
    public void run() {
        searching(files);
        for (int i = 0; i < threadList.size(); i++) {
            try {
                threadList.get(i).join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (foundedFiles.size() == 0) {
                break;
            } else {
                for (File f: files) {
                    System.out.println(f.getAbsoluteFile());
                }
            }

        }
    }
}

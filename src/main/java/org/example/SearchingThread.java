package org.example;

import java.io.File;

public class SearchingThread implements Runnable{
    private File[] files;
    private FileSearch fileSearch;

    public SearchingThread(File[] files, FileSearch fileSearch) {
        this.files = files;
        this.fileSearch = fileSearch;
    }


    @Override
    public void run() {
        fileSearch.searching(files);
    }
}

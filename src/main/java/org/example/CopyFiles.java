package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CopyFiles {
    public static void copyFilesBySocket(String sourceFile, String destHost, int desPort) throws IOException {
        try(Socket socket = new Socket(destHost, desPort);
            InputStream inputStream = Files.newInputStream(Paths.get(sourceFile));
            OutputStream outputStream = socket.getOutputStream()) {


            byte[] bytes = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(bytes)) > 0) {
                outputStream.write(bytes, 0, bytesRead);
            }
        }
    }
}

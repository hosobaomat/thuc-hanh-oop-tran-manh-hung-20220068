package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String fileName = "Test/test.txt";
        long startTime, endTime;

        byte[] inputBytes;
        try {
            inputBytes = Files.readAllBytes(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        startTime = System.currentTimeMillis();
        StringBuilder outputString = new StringBuilder();
        for (byte b : inputBytes){
            outputString.append((char) b);
        }
        endTime = System.currentTimeMillis();
        System.out.println("time: " + (endTime - startTime));
    }
}

package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String fileName = "Test/test.txt";
        byte[] inputBytes = null;
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        startTime = System.currentTimeMillis();
        String outputStr = "";
        for(byte b : inputBytes){
            outputStr += (char) b;
        }
        endTime = System.currentTimeMillis();

        System.out.println("time: " + (endTime - startTime));
    }
}

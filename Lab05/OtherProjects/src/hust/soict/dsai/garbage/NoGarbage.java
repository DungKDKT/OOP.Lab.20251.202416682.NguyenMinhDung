package hust.soict.dsai.garbage;

import java.nio.file.*;
import java.io.IOException;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
        String filename = "test.exe";
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

        // StringBuilder
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (byte b : inputBytes) {
            sb.append((char) b);
        }
        System.out.println("Builder: " + (System.currentTimeMillis() - startTime));

        // StringBuffer
        startTime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (byte b : inputBytes) {
            sbf.append((char) b);
        }
        System.out.println("Buffer: " + (System.currentTimeMillis() - startTime));
    }
}
package com.pb.chernjak.hw9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileNumbers {

    public static void createNumbersFile(Path file) {
        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            for (int i = 0; i < 10; ++i) {
                StringBuffer str = new StringBuffer();
                for (int j = 0; j < 10; ++j) {
                    int random = (int)(99 * Math.random() + 1);
                    str.append(random).append(" ");
                }
                writer.write(str.toString());
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error with file write: " + e);
        }
    }

    public static void createOddNumbersFile(Path file, Path fileOdd) {
        try (BufferedReader reader = Files.newBufferedReader(file);
             BufferedWriter writer = Files.newBufferedWriter(fileOdd)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Scanner scan = new Scanner(line);
                while (scan.hasNext()) {
                    StringBuffer str = new StringBuffer();
                    for (int i = 0; i < 10; ++i) {
                        int temp = scan.nextInt();
                        if (temp % 2 == 0) {
                            temp = 0;
                        }
                        str.append(temp).append(" ");
                    }
                    writer.write(str.toString());
                    writer.newLine();
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void main(String[] args) throws Exception {
        Path file = Paths.get("files\\hw9\\numbers.txt");
        Path fileOdd = Paths.get("files\\hw9\\odd-numbers.txt");
        createNumbersFile(file);
        createOddNumbersFile(file, fileOdd);
    }
}



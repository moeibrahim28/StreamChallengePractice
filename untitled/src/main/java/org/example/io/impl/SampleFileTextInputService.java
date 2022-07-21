package org.example.io.impl;

import org.example.io.TextInputService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SampleFileTextInputService implements TextInputService {
    private static final String FILE_NAME = "book.txt";

    @Override
    public String getText() throws IOException {
        String bookText = "";


        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        bookText = contentBuilder.toString();
        return bookText;
    }
}

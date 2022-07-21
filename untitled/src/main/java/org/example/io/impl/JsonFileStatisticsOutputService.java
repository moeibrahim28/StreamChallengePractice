package org.example.io.impl;

import org.example.io.StatisticsOutputService;
import org.example.statistics.model.TextStatistics;

import java.io.FileWriter;
import java.io.IOException;

public class JsonFileStatisticsOutputService implements StatisticsOutputService {
    private final static String OUTPUT_FILE_NAME = "statistics.json";
    @Override
    public void save(TextStatistics statistics) {
        // TODO
        try (FileWriter file = new FileWriter(OUTPUT_FILE_NAME)) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(statistics.toString());
            file.flush();

        }
         catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

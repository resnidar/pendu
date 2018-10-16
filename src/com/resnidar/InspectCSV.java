package com.resnidar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class InspectCSV {

    public static String read() throws IOException {
        Random random = new Random();
        int randomNumber = random.nextInt(50);
        Path wordListPath = Paths.get("wordList.csv");
        List<String> lines = Files.readAllLines(wordListPath);
        String word = lines.get(0).split(",")[randomNumber];
        System.out.println("le nombre aleatoire choisi est : " + randomNumber);
        return word;
    }
}

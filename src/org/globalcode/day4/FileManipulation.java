package org.globalcode.day4;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileManipulation {

    static String contents = "";

    public static void main(String[] args) {

        Path path = Paths.get("fp.txt");
        try(BufferedReader reader = Files.newBufferedReader(path); ) {

            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            contents = stringBuilder.toString();
            System.out.println(contents);

            System.out.println(countWordsInString(contents));
            System.out.println(countWordsMoreThan5Characters(contents));
            createHistogram(contents);

        } catch (Exception e){
            e.printStackTrace();
        }




    }

    private static int countWordsInString(String content){
        String[] words = content.split(" ");
        return words.length;
    }

    private static int countWordsMoreThan5Characters(String content){
        String[] words = content.split(" ");
        int count = 0;
        for(String word : words){
            if(word.length() > 5){
                count++;
            }
        }
        return count;
    }

    private static void createHistogram(String contents){
        String[] words = contents.split(" ");
        ArrayList<Integer> counts = new ArrayList<>();
        for(String word : words){
            counts.add(word.length());
        }
        System.out.println(counts);

        HashSet<Integer> distinctSet = new HashSet<>(counts);
        for (int number : distinctSet){
            int occurence = Collections.frequency(counts, number);
            System.out.println(number + ": " + occurence);
        }



    }


}

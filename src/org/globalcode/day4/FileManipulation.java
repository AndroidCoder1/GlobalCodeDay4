package org.globalcode.day4;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileManipulation {

    public static void main(String[] args) {

        FileManipulation fm = new FileManipulation();
        //Specifying Path to file
        Path path = Paths.get("fp.txt");

        String contents = fm.readFromLocalFile(path);

        System.out.println("File Contents::::"+contents);

        System.out.println("Number of Words in File::::"+countWordsInString(contents));
        System.out.println("Number of Words more than 5 characters::::"+countWordsMoreThan5Characters(contents));

        //Printout of items and their frequencies
        createHistogram(contents);
    }

    private String readFromLocalFile(Path path) {
        //Creating try with resource to prevent exceptions
        try(BufferedReader reader = Files.newBufferedReader(path)) {

            //Creating StringBuilder to hold contents of file
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
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
            int occurrence = Collections.frequency(counts, number);
            System.out.println(number + ": " + occurrence);
        }
    }
}

package data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataReader {


    private final static String path = "Data.txt";

    /***
     * Get Optional of an object[][] for Data Provider
     */
    public static Optional<Object[][]> getObjectFromData() {

        // Path & Object to put into optional to return
        File file = new File(path);
        Object[][] object = null;

        // Reading words from file
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;

            int index = 0;
            int lineIndex = 0;

            // List of all words
            List<String> words = new ArrayList<>();

            // while there is lines on the file
            while ((line = br.readLine()) != null) {

                String[] arr = line.split(",");

                for (String word: arr) {
                    words.add(word);
                    index++;
                };
            }

            // initial the object[][]
            object = new Object[index][];

            for (String word: words) {
                object[lineIndex] = new String[]{word};
                lineIndex++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // returning the optional object
        return  Optional.of(object);
    }


}

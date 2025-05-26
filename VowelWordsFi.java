import java.io.*;
import java.util.*;

public class VowelWordsFi {
    public static boolean startsWithVowel(String word) {
        char firstChar = Character.toLowerCase(word.charAt(0));
        return "aeiou".indexOf(firstChar) != -1;
    }
    public static void main(String[] args) {
        // Input and Output file paths
        String inputFilePath = "input.txt";  // Replace with your input file
        String outputFilePath = "output.txt"; // Output file

        // Using a try-with-resources block to handle file operations
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            List<String> wordsStartingWithVowels = new ArrayList<>();
            int vowelCount = 0;

            // Read each line from the input file
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split the line into words based on whitespace

                // Check each word
                for (String word : words) {
                    if (startsWithVowel(word)) {
                        wordsStartingWithVowels.add(word);
                        vowelCount++;
                    }
                }
            }

            // Write results to output file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
                bw.write("Count of words starting with vowels: " + vowelCount + "\n");
                bw.write("Words starting with vowels:\n");

                // Print each word in the list
                for (String word : wordsStartingWithVowels) {
                    bw.write(word + "\n");
                }

                System.out.println("Processing complete. Check the output file: " + outputFilePath);
            }
        } catch (IOException e) {
            System.err.println("Error reading or writing the file: " + e.getMessage());
        }

    }
}



import java.util.Scanner;

public class TypingSpeedTest {
    public static void main(String[] args) {
        String[] sentences = {
                "The quick brown fox jumps over the lazy dog.",
                "Typing speed is measured in words per minute.",
                "Practice makes perfect when it comes to typing.",
                "A journey of a thousand miles begins with a single step.",
                "Coding is fun and improves problem-solving skills."
        };

        // Select a random sentence
        String sentence = sentences[(int) (Math.random() * sentences.length)];
        System.out.println("Type the following sentence as fast as you can:\n");
        System.out.println("\"" + sentence + "\"");
        System.out.println("\nPress Enter when you are ready...");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Wait for the user to press Enter

        // Start time
        long startTime = System.currentTimeMillis();

        System.out.println("\nStart typing now:");
        String userInput = scanner.nextLine(); // Get user input

        // End time
        long endTime = System.currentTimeMillis();

        // Calculate typing speed
        int wordCount = sentence.split(" ").length; // Total words in the sentence
        double timeTaken = (endTime - startTime) / 1000.0; // Convert to seconds
        double wpm = (wordCount / timeTaken) * 60; // Words per minute formula

        System.out.println("\nTyping Speed Test Results:");
        System.out.printf("Time taken: %.2f seconds\n", timeTaken);
        System.out.printf("Your speed: %.2f WPM (Words Per Minute)\n", wpm);

        // Check accuracy
        int correctChars = 0;
        int minLength = Math.min(sentence.length(), userInput.length());
        for (int i = 0; i < minLength; i++) {
            if (sentence.charAt(i) == userInput.charAt(i)) {
                correctChars++;
            }
        }
        double accuracy = ((double) correctChars / sentence.length()) * 100;
        System.out.printf("Accuracy: %.2f%%\n", accuracy);

        scanner.close();
    }
}

package com.oasis.numberGuessingGame;
import java.util.Random;
import javax.swing.JOptionPane;
public class NumberGuessing {
    public static void main(String[] args) {
        int rangeStart = 1;
        int rangeEnd = 100;
        int maxAttempts = 10;
        int score = 0;
        boolean playAgain = true;

        JOptionPane.showMessageDialog(null, "Welcome to the Number Guessing Game!");

        while (playAgain) {
            int targetNumber = generateRandomNumber(rangeStart, rangeEnd);
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts && !guessedCorrectly) {
                String input = JOptionPane.showInputDialog("Enter a number between " + rangeStart + " and " + rangeEnd);
                int guessedNumber = Integer.parseInt(input);
                attempts++;
             

                if (guessedNumber == targetNumber) {
                    guessedCorrectly = true;
                    score += maxAttempts - attempts + 1;
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + attempts + " attempts.");
                } else if (guessedNumber < targetNumber) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                JOptionPane.showMessageDialog(null, "Sorry, you didn't guess the number. The correct number was: " + targetNumber);
            }

            int choice = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
            if (choice != JOptionPane.YES_OPTION) {
                playAgain = false;
            }
        }

        JOptionPane.showMessageDialog(null, "Game over! Your final score is: " + score);
    }

    private static int generateRandomNumber(int start, int end) {
        Random random = new Random();
        return random.nextInt(end - start + 1) + start;
    }
}
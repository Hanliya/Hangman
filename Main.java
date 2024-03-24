import java.util.Scanner;

public class Main {
    private static final String[] WORDS = {"java", "python", "javascript", "ruby", "csharp"};
    private static final int MAX_TRIES = 6;
    private static String secretWord;
    private static StringBuilder guessedWord;
    private static int triesLeft;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        selectSecretWord();

        guessedWord = new StringBuilder("_".repeat(secretWord.length()));
        triesLeft = MAX_TRIES;

        System.out.println("Welcome to Hangman!");
        System.out.println("Guess the word: " + guessedWord);

        while (triesLeft > 0 && guessedWord.indexOf("_") != -1) {
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);
            checkGuess(guess);
            System.out.println("Tries left: " + triesLeft);
            System.out.println("Current progress: " + guessedWord);
        }

        if (guessedWord.indexOf("_") == -1) {
            System.out.println("Congratulations! You guessed the word: " + secretWord);
        } else {
            System.out.println("Sorry, you ran out of tries. The word was: " + secretWord);
        }

        scanner.close();
    }

    private static void selectSecretWord() {
        secretWord = WORDS[(int) (Math.random() * WORDS.length)];
    }

    private static void checkGuess(char guess) {
        boolean found = false;
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == guess) {
                guessedWord.setCharAt(i, guess);
                found = true;
            }
        }
        if (!found) {
            triesLeft--;
            System.out.println("Incorrect guess!");
        }
    }
}

import java.util.Scanner;

public class lab8 {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Calculate maximum guesses needed using log base 2
     */
    public static int calculateMaxGuesses(int n) {
        return (int) Math.ceil(Math.log(n) / Math.log(2));
    }

    /**
     * Validate user input against expected options
     */
    public static String validateResponse(String response, String[] validOptions) {
        response = response.trim().toLowerCase();
        for (String option : validOptions) {
            if (response.equals(option)) {
                return response;
            }
        }
        System.out.print("Invalid input. Please enter one of: ");
        for (int i = 0; i < validOptions.length; i++) {
            System.out.print(validOptions[i]);
            if (i < validOptions.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        return null;
    }

    /**
     * Main game logic
     */
    public static void playGame() {
        System.out.println("==================================================");
        System.out.println("CS325 AI Bot Guessing Game");
        System.out.println("==================================================");

        // Get upper limit
        int upperLimit = 0;
        while (true) {
            try {
                System.out.print("\nEnter the largest number: ");
                upperLimit = Integer.parseInt(scanner.nextLine());
                if (upperLimit < 1) {
                    System.out.println("Please enter a number greater than 0");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer");
            }
        }

        System.out.println("\nPick a number between 1 and " + upperLimit + " but don't tell me!");

        int maxGuesses = calculateMaxGuesses(upperLimit);
        System.out.println("I can guess your number in " + maxGuesses + " guesses");

        // Initialize binary search bounds
        int low = 1;
        int high = upperLimit;
        int guessCount = 0;

        while (low <= high) {
            guessCount++;

            // Binary search: pick middle value
            int guess = (low + high) / 2;

            // Make the guess
            String response = null;
            while (response == null) {
                System.out.print("\nGuess #" + guessCount + ": Is your number " + guess + "? (y,n): ");
                response = validateResponse(scanner.nextLine(), new String[] { "y", "n" });
            }

            if (response.equals("y")) {
                System.out.println("\nI was able to guess your number in " + guessCount +
                        " guess" + (guessCount != 1 ? "es" : "") + "!");
                if (guessCount <= maxGuesses) {
                    System.out.println("That's within my predicted maximum of " + maxGuesses + " guesses!");
                }
                return;
            }

            // Ask if higher or lower
            String direction = null;
            while (direction == null) {
                System.out.print("Is your number higher or lower than " + guess + "? (h,l): ");
                direction = validateResponse(scanner.nextLine(), new String[] { "h", "l" });
            }

            if (direction.equals("h")) {
                // User says their number is higher
                if (guess >= high) {
                    System.out.println("\nERROR: Inconsistent response detected!");
                    System.out.println("You said your number is higher than " + guess +
                            ", but that's impossible given previous responses.");
                    System.out.println("The game cannot continue. Please play again and provide consistent answers.");
                    return;
                }
                low = guess + 1;
            } else { // direction.equals("l")
                // User says their number is lower
                if (guess <= low) {
                    System.out.println("\nERROR: Inconsistent response detected!");
                    System.out.println("You said your number is lower than " + guess +
                            ", but that's impossible given previous responses.");
                    System.out.println("The game cannot continue. Please play again and provide consistent answers.");
                    return;
                }
                high = guess - 1;
            }
        }

        // This should never happen with honest answers
        System.out.println("\nERROR: No valid number exists in the range!");
        System.out.println("There appears to be an inconsistency in your responses.");
        System.out.println("Please play again and provide consistent answers.");
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        while (true) {
            playGame();
            System.out.println("\n==================================================");
            System.out.print("Would you like to play again? (y/n): ");
            String playAgain = scanner.nextLine().trim().toLowerCase();
            if (!playAgain.equals("y")) {
                System.out.println("\nThanks for playing! Goodbye! 👋");
                break;
            }
            System.out.println();
        }
        scanner.close();
    }
}

package viva;
import java.util.Random;
import java.util.Scanner;

public class V1Q6 {

    public static void main(String[] args) {

        final int TOTAL_CHESTS = 10;
        final int TOTAL_EGGS = 3;
        final int TOTAL_CURSED = 2;
        int attempts = 10;

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int[] eggPositions = new int[TOTAL_EGGS];
        int eggsPlaced = 0;

        int[] cursedChests = new int[TOTAL_CURSED];
        int cursedPlaced = 0;


        // RANDOMLY PLACE EGGS 

        while (eggsPlaced < TOTAL_EGGS) {
            int pos = rand.nextInt(TOTAL_CHESTS) + 1;
            if (!contains(eggPositions, eggsPlaced, pos)) {
                eggPositions[eggsPlaced++] = pos;
            }
        }

        // RANDOMLY PLACE CURSED CHESTS

        while (cursedPlaced < TOTAL_CURSED) {
            int pos = rand.nextInt(TOTAL_CHESTS) + 1;
            if (!contains(cursedChests, cursedPlaced, pos)) {
                cursedChests[cursedPlaced++] = pos;
            }
        }

        System.out.println("Welcome to the Dragon Egg Hunt!");
        System.out.println("Find the 3 dragon eggs hidden among 10 chests!");
        System.out.println("Beware of the 2 cursed chests...\n");

        while (attempts > 0 && eggsPlaced > 0) {

            System.out.println("Attempts left: " + attempts);
            System.out.print("Choose a chest (1–10): ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.\n");
                sc.next();
                continue;
            }

            int guess = sc.nextInt();

            if (guess < 1 || guess > 10) {
                System.out.println("Chest number must be between 1 and 10!\n");
                continue;
            }

            // Check cursed chest
            if (contains(cursedChests, cursedPlaced, guess)) {
                System.out.println("The chest is cursed! Beware!");
                attempts -= 2;
            } else {
                attempts -= 1;
            }

            // Egg found?
            int eggIndex = indexOf(eggPositions, eggsPlaced, guess);
            if (eggIndex != -1) {
                System.out.println("You found a dragon egg!\n");
                eggsPlaced = removeAtIndex(eggPositions, eggsPlaced, eggIndex);
                continue;
            }

            // Empty chest logic
            if (eggsPlaced > 0) {
                int nearestEgg = findNearestEgg(guess, eggPositions, eggsPlaced);

                // Warm / Cold
                if (Math.abs(guess - nearestEgg) <= 3) {
                    System.out.println("Warm! You're very close to a dragon egg!");
                } else {
                    System.out.println("Cold! You're far from any dragon egg!");
                }

                // Higher / Lower Hint
                if (guess < nearestEgg) {
                    System.out.println("Hint: Try a higher chest number.");
                } else if (guess > nearestEgg) {
                    System.out.println("Hint: Try a lower chest number.");
                }
            }

            System.out.println("No egg here, keep searching!\n");
        }

        // End results
        if (eggsPlaced == 0) {
            System.out.println("Congratulations! All dragon eggs are safe!");
        } else {
            System.out.println("Game Over! Some dragon eggs remain hidden!");
        }

        sc.close();
    }

    // HELPER FUNCTIONS

    // Check if array contains value (only checks first 'size' elements)
    static boolean contains(int[] arr, int size, int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) return true;
        }
        return false;
    }

    // Get index of value in array or -1
    static int indexOf(int[] arr, int size, int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }

    // Remove element by shifting items left
    static int removeAtIndex(int[] arr, int size, int index) {
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        return size - 1; // new size
    }

    // Find closest egg position
    static int findNearestEgg(int guess, int[] eggs, int size) {
        int nearest = eggs[0];
        for (int i = 1; i < size; i++) {
            if (Math.abs(eggs[i] - guess) < Math.abs(nearest - guess)) {
                nearest = eggs[i];
            }
        }
        return nearest;
    }
}
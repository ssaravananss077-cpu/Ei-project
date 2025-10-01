package Singelton;

import java.util.Scanner;

public class UserInputHandler {
    private final Scanner scanner = new Scanner(System.in);
    private final AppLogger logger = AppLogger.getInstance();

    public int getMenuChoice() {
        logger.info("Displaying menu to user.");
        System.out.println("\n===== MENU =====");
        System.out.println("1. Say Hello");
        System.out.println("2. Perform Calculation");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());
            if (choice < 1 || choice > 3) {
                logger.warn("Invalid choice entered: " + choice);
                return -1;
            }
            return choice;
        } catch (NumberFormatException e) {
            logger.error("Invalid input, not a number.");
            return -1;
        }
    }

    public int getInteger(String message) {
        System.out.print(message);
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            logger.error("Invalid integer entered.");
            throw new IllegalArgumentException("Input must be an integer.");
        }
    }
}

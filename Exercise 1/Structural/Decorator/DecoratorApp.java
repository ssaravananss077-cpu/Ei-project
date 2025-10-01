package Decorator;
import Singelton.*;
import java.util.*;

public class DecoratorApp {
    private final AppLogger logger = AppLogger.getInstance();
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        logger.info("Decorator Pattern Demo Started");
        showMenu();
    }

    private void showMenu() {
        System.out.println("\n===== DECORATOR MENU =====");
        System.out.println("1. Simple Message");
        System.out.println("2. Message with Timestamp");
        System.out.println("3. Message with Border");
        System.out.println("4. Message with Timestamp + Border");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1", "2", "3", "4" -> displayMessage(choice);
            case "5" -> logger.info("Exiting Decorator Demo");
            default -> {
                logger.warn("Invalid choice: " + choice);
                showMenu();
            }
        }
    }

    private void displayMessage(String choice) {
        System.out.print("Enter your message: ");
        String msg = scanner.nextLine().trim();
        Message message = new SimpleMessage(msg);

        switch (choice) {
            case "2" -> message = new TimestampDecorator(message);
            case "3" -> message = new BorderDecorator(message);
            case "4" -> message = new BorderDecorator(new TimestampDecorator(message));
        }

        System.out.println("Output: " + message.getContent());
        logger.info("Message displayed with decorator");
        showMenu();
    }

    public static void main(String[] args) {
        new DecoratorApp().run();
    }
}


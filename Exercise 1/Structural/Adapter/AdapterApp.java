package Adapter;

import Singelton.*;
import java.util.*;

public class AdapterApp {
    private final AppLogger logger = AppLogger.getInstance();
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        logger.info("Adapter Pattern Demo Started");
        showMenu();
    }

    private void showMenu() {
        System.out.println("\n===== ADAPTER MENU =====");
        System.out.println("1. Print Message using Adapter");
        System.out.println("2. Exit");
        System.out.print("Enter choice: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1" -> {
                System.out.print("Enter message: ");
                String msg = scanner.nextLine().trim();
                Print printer = new TextPrinterAdapter(new Textprinter());
                printer.print(msg);
                logger.info("Message printed via Adapter");
                showMenu();
            }
            case "2" -> logger.info("Exiting Adapter Demo");
            default -> {
                logger.warn("Invalid choice: " + choice);
                showMenu();
            }
        }
    }

    public static void main(String[] args) {
        new AdapterApp().run();
    }
}
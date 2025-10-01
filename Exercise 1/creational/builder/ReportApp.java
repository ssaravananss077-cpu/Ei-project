package builder;

import java.util.Scanner;

import Singelton.AppLogger;

public class ReportApp {
    private final AppLogger logger = AppLogger.getInstance();
    private final Scanner scanner = new Scanner(System.in);
    public void run() {
    logger.info("Report Builder App Started");
    showMenu();  // start menu
}

private void showMenu() {
    System.out.println("\n===== REPORT MENU =====");
    System.out.println("1. Create New Report");
    System.out.println("2. Exit");
    System.out.print("Enter choice: ");

    String choice = scanner.nextLine().trim();

    switch (choice) {
        case "1" -> {
            createReport();
            showMenu(); // call menu again after completing action
        }
        case "2" -> exit(); // ends program, no loop needed
        default -> {
            logger.warn("Invalid choice: " + choice);
            showMenu(); // retry menu
        }
    }
}

    private void createReport() {
        try {
            ReportBuilder builder = new ReportBuilder();

            System.out.print("Enter Report Title: ");
            String title = scanner.nextLine().trim();
            builder.setTitle(title);

            System.out.print("Enter Author Name: ");
            String author = scanner.nextLine().trim();
            builder.setAuthor(author);

            boolean addingRows = true;
            while (addingRows) {
                System.out.print("Enter row content (or 'done' to finish): ");
                String row = scanner.nextLine().trim();
                if (row.equalsIgnoreCase("done")) {
                    addingRows = false;
                } else if (!row.isEmpty()) {
                    builder.addRow(row);
                } else {
                    logger.warn("Empty row skipped");
                }
            }

            Report report = builder.build();
            logger.info("Report created successfully:\n" + report);

        } catch (Exception e) {
            logger.error("Error creating report: " + e.getMessage());
        }
    }

    private void exit() {
        logger.info("Exiting Report Builder App");
        
    }

    public static void main(String[] args) {
        new ReportApp().run();
    }
}
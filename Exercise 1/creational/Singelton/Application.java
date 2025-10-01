package Singelton;

public class Application {
     private final AppLogger logger = AppLogger.getInstance();
    private final UserInputHandler inputHandler = new UserInputHandler();
    private boolean running = true; // controlled exit

    public void run() {
        logger.info("Application started");

        while (running) {
            try {
                int choice = inputHandler.getMenuChoice();

                switch (choice) {
                    case 1 -> sayHello();
                    case 2 -> performCalculation();
                    case 3 -> exitApp();
                    default -> logger.warn("User entered invalid choice.");
                }
            } catch (Exception e) {
                logger.error("Unexpected error: " + e.getMessage());
            }
        }
    }

    private void sayHello() {
        logger.info("Executing 'Say Hello'");
        System.out.println("Hello, User! Welcome to the Singleton Logger");
    }

    private void performCalculation() {
        try {
            int a = inputHandler.getInteger("Enter first number: ");
            int b = inputHandler.getInteger("Enter second number: ");
            int sum = a + b;
            logger.info("Performed calculation: " + a + " + " + b + " = " + sum);
            System.out.println("Result = " + sum);
        } catch (IllegalArgumentException e) {
            logger.warn("Calculation aborted due to invalid input.");
        }
    }

    private void exitApp() {
        logger.info("Exiting application.");
        running = false; // clean exit (no hardcoded while(true))
    }

    public static void main(String[] args) {
        new Application().run();
    }
}

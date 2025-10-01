package Command;
import java.util.*;
import Singelton.*;

public class RemoteControlApp {
    private final AppLogger logger = AppLogger.getInstance();
    private final Scanner scanner = new Scanner(System.in);
    private final Light light = new Light();

    public void run() {
        logger.info("Command Pattern Demo Started");
        showMenu();
    }

    private void showMenu() {
        System.out.println("\n===== REMOTE CONTROL MENU =====");
        System.out.println("1. Turn Light ON");
        System.out.println("2. Turn Light OFF");
        System.out.println("3. Exit");
        System.out.print("Enter choice: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1" -> executeCommand(new LightOnCommand(light));
            case "2" -> executeCommand(new LightOffCommand(light));
            case "3" -> logger.info("Exiting Command Pattern");
            default -> {
                logger.warn("Invalid choice: " + choice);
                showMenu();
            }
        }
    }

    private void executeCommand(Command command) {
        command.execute();
        logger.info("Command executed: " + command.getClass().getSimpleName());
        showMenu();
    }

    public static void main(String[] args) {
        new RemoteControlApp().run();
    }
}

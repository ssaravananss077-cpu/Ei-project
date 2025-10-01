package Observer;
import Singelton.*;
import java.util.Scanner;

public class ObserverApp {
    private final AppLogger logger = AppLogger.getInstance();
    private final Scanner scanner = new Scanner(System.in);
    private final NewsPublisher publisher = new NewsPublisher();

    public void run() {
        logger.info("Observer Pattern Demo Started");
        showMenu();
    }

    private void showMenu() {
        System.out.println("\n===== OBSERVER MENU =====");
        System.out.println("1. Subscribe");
        System.out.println("2. Unsubscribe");
        System.out.println("3. Publish News");
        System.out.println("4. Exit");
        System.out.print("Enter choice: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1" -> subscribe();
            case "2" -> unsubscribe();
            case "3" -> publish();
            case "4" -> logger.info("Exiting Observer");
            default -> {
                logger.warn("Invalid choice: " + choice);
                showMenu();
            }
        }
    }

    private void subscribe() {
        System.out.print("Enter subscriber name: ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty()) {
            publisher.subscribe(new NewsSubscriber(name));
            logger.info(name + " subscribed.");
        } else {
            logger.warn("Subscriber name cannot be empty.");
        }
        showMenu();
    }

    private void unsubscribe() {
        System.out.print("Enter subscriber name to remove: ");
        String name = scanner.nextLine().trim();
      
        publisher.unsubscribe(new NewsSubscriber(name));
        logger.info(name + " unsubscribed.");
        showMenu();
    }

    private void publish() {
        System.out.print("Enter news: ");
        String news = scanner.nextLine().trim();
        if (!news.isEmpty()) {
            publisher.publishNews(news);
            logger.info("News published: " + news);
        } else {
            logger.warn("News cannot be empty.");
        }
        showMenu();
    }

    public static void main(String[] args) {
        new ObserverApp().run();
    }
}

package Observer;
import Singelton.*;
public class NewsSubscriber implements Subscriber {
    private final String name;
    private final AppLogger logger = AppLogger.getInstance();

    public NewsSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println("[" + name + "] Received news: " + news);
        logger.info("Subscriber " + name + " received news: " + news);
    }
}
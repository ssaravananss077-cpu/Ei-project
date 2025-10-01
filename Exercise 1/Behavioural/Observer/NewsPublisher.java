package Observer;
import java.util.*;

public class NewsPublisher {
    private final List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber s) {
        if (!subscribers.contains(s)) subscribers.add(s);
    }

    public void unsubscribe(Subscriber s) {
        subscribers.remove(s);
    }

    public void publishNews(String news) {
        for (Subscriber s : subscribers) {
            s.update(news);
        }
    }
}

package Decorator;
import java.time.LocalDateTime;

public class TimestampDecorator extends MessageDecorator {
    public TimestampDecorator(Message message) {
        super(message);
    }

    public String getContent() {
        return "[" + LocalDateTime.now() + "] " + message.getContent();
    }
}


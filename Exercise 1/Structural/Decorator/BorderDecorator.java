package Decorator;

public class BorderDecorator extends MessageDecorator {
    public BorderDecorator(Message message) {
        super(message);
    }

    @Override
    public String getContent() {
        return "***** " + message.getContent() + " *****";
    }
}
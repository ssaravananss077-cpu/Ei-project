package Adapter;

public class TextPrinterAdapter implements Print {
    private final Textprinter printer;

    public TextPrinterAdapter(Textprinter printer) {
        this.printer = printer;
    }

    @Override
    public void print(String message) {
        printer.printText(message); // adapt method
    }
}
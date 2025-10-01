package builder;
import java.util.*;
import java.time.LocalDateTime;
public class ReportBuilder {
    private String title = "Untitled Report";
    private String author = "Anonymous";
    private final List<String> rows = new ArrayList<>();
    private LocalDateTime createdAt = LocalDateTime.now();

    public ReportBuilder setTitle(String title) {
        this.title = Objects.requireNonNull(title, "title cannot be null");
        return this;
    }

    public ReportBuilder setAuthor(String author) {
        this.author = Objects.requireNonNull(author, "author cannot be null");
        return this;
    }

    public ReportBuilder addRow(String row) {
        if (row == null || row.isEmpty()) {
            throw new IllegalArgumentException("Row cannot be empty");
        }
        this.rows.add(row);
        return this;
    }

    public ReportBuilder setCreatedAt(LocalDateTime dt) {
        this.createdAt = Objects.requireNonNull(dt, "createdAt cannot be null");
        return this;
    }

    public Report build() {
        if (rows.isEmpty()) {
            throw new IllegalStateException("Report must have at least one row");
        }
        return new Report(title, author, rows, createdAt);
    }
}
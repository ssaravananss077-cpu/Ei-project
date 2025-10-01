package builder;
import java.time.LocalDateTime;
import java.util.*;
public final class Report {
    private final String title;
    private final String author;
    private final List<String> rows;
    private final LocalDateTime createdAt;

    public Report(String title, String author, List<String> rows, LocalDateTime createdAt) {
        this.title = title;
        this.author = author;
        this.rows = Collections.unmodifiableList(rows);
        this.createdAt = createdAt;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public List<String> getRows() { return rows; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Report: ").append(title).append("\n");
        sb.append("Author: ").append(author).append("\n");
        sb.append("Created At: ").append(createdAt).append("\n");
        sb.append("Rows:\n");
        for (String row : rows) sb.append(" - ").append(row).append("\n");
        return sb.toString();
    }
}


package todoapp.model.todo;

import java.io.Serializable;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Todo implements Serializable{
    private int id;
    private String title;
    private int importance;
    private final String STAR = "★";

    public Todo() {
    }

    public Todo(String title, int importance) {
        this.title=title;
        this.importance=importance;
    }

    public Todo(int id, String title, int importance) {
        this(title,importance);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public String getStar() {
        return IntStream.rangeClosed(1, this.importance)
                    .mapToObj(i -> STAR)
                    .collect(Collectors.joining());
    }

}

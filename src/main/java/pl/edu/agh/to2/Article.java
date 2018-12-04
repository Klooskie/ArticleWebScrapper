package pl.edu.agh.to2;

public class Article {
    String title;
    String date;
    String content;

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public Article(String title, String date, String content) {
        this.title = title;
        this.date = date;
        this.content = content;
    }
}

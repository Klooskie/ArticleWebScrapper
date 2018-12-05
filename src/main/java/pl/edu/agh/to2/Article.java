package pl.edu.agh.to2;

import java.util.Date;

public class Article {
    String title;
    Date date;
    String content;
    String author;


    public Article(String title, Date date, String content, String author) {
        this.title = title;
        this.date = date;
        this.content = content;
        this.author = author;

    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() { return author; }

    @Override
    public String toString(){
        StringBuilder articleText = new StringBuilder();
        articleText.append("Title: ");
        articleText.append(this.title);
        articleText.append("\n");
        articleText.append("Date: ");
        articleText.append(this.date);
        articleText.append("\n");
        articleText.append(this.content);
        articleText.append("\n");
        articleText.append("Author: ");
        articleText.append(this.author);
        articleText.append("\n");

        return articleText.toString();
    }
}

package pl.edu.agh.to2;

import java.util.Date;
import java.util.List;

public class Article {
    String title;
    Date date;
    String content;
    String author;
    String source;
    List<String> tags;
    int length;

    public Article(String title, Date date, String content, String author, String source, List<String> tags, int length) {
        this.title = title;
        this.date = date;
        this.content = content;
        this.author = author;
        this.source = source;
        this.tags = tags;
        this.length = length;
    }


    public String getSource() {
        return source;
    }

    public List<String> getTags() {
        return tags;
    }

    public int getLength() {
        return length;
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
        articleText.append("Tags: ");
        articleText.append(this.tags.toString());
        articleText.append("\n");

        return articleText.toString();
    }
}

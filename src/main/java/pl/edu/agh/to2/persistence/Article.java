package pl.edu.agh.to2.persistence;

import java.util.Date;
import java.util.List;

public class Article {
    String title;
    Date date;
    String content;
    String author;
    String source;
    String url;
    List<String> tags;


    public Article(String title, Date date, String content, String author, String source, String url, List<String> tags) {
        this.title = title;
        this.date = date;
        this.content = content;
        this.author = author;
        this.source = source;
        this.url = url;
        this.tags = tags;
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

    public String getAuthor() {
        return author;
    }

    public String getSource() {
        return source;
    }

    public String getUrl() {
        return url;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        StringBuilder articleText = new StringBuilder();
        articleText.append("Title: ");
        articleText.append(this.title);
        articleText.append("\n");
        articleText.append("Date: ");
        articleText.append(this.date);
        articleText.append("\n");
        articleText.append(this.content);
        articleText.append("\n");
        if (this.author != null) {
            articleText.append("Author: ");
            articleText.append(this.author);
            articleText.append("\n");
        }
        if (this.source != null) {
            articleText.append("Source: ");
            articleText.append(this.source);
            articleText.append("\n");
        }
//        articleText.append("\n");
//        articleText.append("Tags: ");
//        articleText.append(this.tags.toString());
        articleText.append("Url: ");
        articleText.append(this.url);
        articleText.append("\n\n");

        return articleText.toString();
    }
}

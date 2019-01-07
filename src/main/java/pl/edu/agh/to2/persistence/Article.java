package pl.edu.agh.to2.persistence;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;
import java.util.List;

public class Article {
    private SimpleObjectProperty<Date> date;
    private SimpleStringProperty title;
    private SimpleStringProperty content;
    private SimpleStringProperty author;
    private SimpleStringProperty source;
    private SimpleStringProperty url;
    private SimpleObjectProperty<List<String>> tags;


    public Article(String title, Date date, String content, String author, String source, String url, List<String> tags) {
        this.title = new SimpleStringProperty(title);
        this.date = new SimpleObjectProperty<Date>(date);
        this.content = new SimpleStringProperty(content);
        this.author = new SimpleStringProperty(author);
        this.source = new SimpleStringProperty(source);
        this.url = new SimpleStringProperty(url);
        this.tags = new SimpleObjectProperty<List<String>>(tags);
    }

    public String getTitle() {
        return title.get();
    }

    public Date getDate() {
        return date.get();
    }

    public String getContent() {
        return content.get();
    }

    public String getAuthor() {
        return author.get();
    }

    public String getSource() {
        return source.get();
    }

    public String getUrl() {
        return url.get();
    }

    public List<String> getTags() {
        return tags.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public void setDate(Date date) {
        this.date.set(date);
    }

    public void setContent(String content) {
        this.content.set(content);
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public void setSource(String source) {
        this.source.set(source);
    }

    public void setUrl(String url) {
        this.url.set(url);
    }

    public void setTags(List<String> tags) {
        this.tags.set(tags);
    }

    @Override
    public String toString() {
        StringBuilder articleText = new StringBuilder();
        articleText.append("Title: ");
        articleText.append(this.title.get());
        articleText.append("\n");
        articleText.append("Date: ");
        articleText.append(this.date.get());
        articleText.append("\n");
        articleText.append(this.content.get());
        articleText.append("\n");
        if (this.author.get() != null) {
            articleText.append("Author: ");
            articleText.append(this.author.get());
            articleText.append("\n");
        }
        if (this.source.get() != null) {
            articleText.append("Source: ");
            articleText.append(this.source.get());
            articleText.append("\n");
        }
//        articleText.append("\n");
//        articleText.append("Tags: ");
//        articleText.append(this.tags.get().toString());
        articleText.append("Url: ");
        articleText.append(this.url.get());
        articleText.append("\n\n");

        return articleText.toString();
    }
}

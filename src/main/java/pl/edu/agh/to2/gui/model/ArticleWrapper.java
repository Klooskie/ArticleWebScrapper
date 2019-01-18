package pl.edu.agh.to2.gui.model;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import pl.edu.agh.to2.persistence.Article;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleWrapper {
    private SimpleObjectProperty<Date> date;
    private SimpleStringProperty title;
    private SimpleStringProperty content;
    private SimpleStringProperty author;
    private SimpleStringProperty source;
    private SimpleStringProperty url;
    private SimpleStringProperty domainUrl;


    public ArticleWrapper(Article article) {
        this.title = new SimpleStringProperty(article.getTitle());
        this.date = new SimpleObjectProperty<Date>(article.getDate());
        this.content = new SimpleStringProperty(article.getContent());
        this.author = new SimpleStringProperty(article.getAuthor());
        this.source = new SimpleStringProperty(article.getSource());
        this.url = new SimpleStringProperty(article.getUrl());
        this.domainUrl = new SimpleStringProperty(article.getDomain().getUrl());
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

    public String getDomainUrl() {
        return domainUrl.get();
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

    public void setDomainUrl(String domainUrl) {
        this.domainUrl.set(domainUrl);
    }


    public static List<ArticleWrapper> wrapArticles(List<Article> articles) {
        List<ArticleWrapper> articleWrappers = new ArrayList<>();

        for(Article article : articles) {
            articleWrappers.add(new ArticleWrapper(article));
        }

        return articleWrappers;
    }
}
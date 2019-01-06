package pl.edu.agh.to2.persistence;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = Article.TABLE_NAME)
public class Article {
    public static final String TABLE_NAME = "ARTICLES_TABLE";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "SOURCE")
    private String source;

    @Column(name = "URL")
    private String url;

    @ManyToOne
    @JoinColumn(name = "DOMAIN_FK")
    private Domain domain;

//    private List<String> tags;

    public Article(){}

    public Article(String title, Date date, String content, String author, String source, String url, List<String> tags) {
        this.title = title;
        this.date = date;
        this.content = content;
        this.author = author;
        this.source = source;
        this.url = url;
//        this.tags = tags;
    }

    public int getID() { return ID; }

    public void setID(int ID) { this.ID = ID; }

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

//    public List<String> getTags() {
//        return tags;
//    }

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

//    public void setTags(List<String> tags) {
//        this.tags = tags;
//    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
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

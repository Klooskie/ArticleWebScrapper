package pl.edu.agh.to2.persistence;

import javax.persistence.*;
import java.util.Date;

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

    public Article(){}

    public Article(String title, Date date, String content, String author, String source, String url) {
        this.title = title;
        this.date = date;
        this.content = content;
        this.author = author;
        this.source = source;
        this.url = url;
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

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }
}
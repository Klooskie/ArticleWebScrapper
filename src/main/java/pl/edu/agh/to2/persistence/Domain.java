package pl.edu.agh.to2.persistence;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = Domain.TABLE_NAME)
public class Domain {
    public static final String TABLE_NAME = "DOMAIN_TABLE";

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "URL")
    private String url;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "DOMAIN_FK")
    private Set<Article> articles;

    public void addArticle(Article article){
        this.articles.add(article);
        article.setDomain(this);
    }

    public Domain(){}

    public Domain(String url) {
        this.articles = new HashSet<>();
        this.url = url;
    }

    public static String getTableName() { return TABLE_NAME; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public void setUrl(String url) { this.url = url; }

    public String getUrl() {
        return url;
    }

    public Set<Article> getArticles() { return articles; }

    public void setArticles(Set<Article> articles) { this.articles = articles; }
}

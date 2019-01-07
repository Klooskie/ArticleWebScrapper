package pl.edu.agh.to2.persistence;

import java.util.LinkedList;
import java.util.List;

//TODO
public class DataBase {

    List<Article> articles = new LinkedList<>();

    public DataBase() {

    }

    @Override
    public String toString() {
        StringBuilder articles = new StringBuilder();
        for(Article article: this.articles){
            articles.append(article);
            articles.append("\n");
        }

        return articles.toString();
    }


    //TODO
    public boolean save(Article article) {
        if (isUnique(article)) {
            articles.add(article);
            return true;
        }

        return false;
    }

    private boolean isUnique(Article article){
        if(articles.contains(article))
            return false;

        return true;
    }

    public List<Article> getArticles() {
        return articles;
    }
}

package pl.edu.agh.to2;

import java.util.LinkedList;
import java.util.List;

//TODO
public class DataBase {

    List<Article> articles = new LinkedList<>();

    public DataBase() {

    }

    @Override
    public String toString() {
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


    //TODO
    private boolean isUnique(Article article){
        return true;
    }


}

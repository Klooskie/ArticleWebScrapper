package pl.edu.agh.to2.web;

import pl.edu.agh.to2.persistence.Article;

import java.util.List;

public abstract class Scrapper {

    public abstract List<String> getUrls(String html);

    public abstract boolean checkIfArticle(String html);

    public abstract Article readArticle(String html);
}

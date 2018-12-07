package pl.edu.agh.to2;

import java.util.List;

public abstract class Scrapper {

    public abstract List<String> getUrls(String html);

    public abstract boolean checkIfArticle(String html);

    public abstract Article readArticle(String html);
}

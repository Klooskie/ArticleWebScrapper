package pl.edu.agh.to2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.LinkedList;
import java.util.List;

public class PAPScrapper extends Scrapper {

    public PAPScrapper(){

    }

    //kapala
    public List<String> getUrls(String html){
        Document doc = Jsoup.parse(html);
        Elements URLs = doc.select("a");

        List<String> parsedURLs = new LinkedList<>();
        for(Element URL: URLs){
            parsedURLs.add(URL.attr("href"));
        }

        return parsedURLs;
    }


    //konieczny
    public boolean checkIfArticle(String html) {
        Document doc = Jsoup.parse(html);
        Elements articles = doc.select("article");

        if (articles.isEmpty())
            return false;
        else
            return true;

    }


    //wuju
    public Article readArticle(String html) {
        Document doc = Jsoup.parse(html);

        Elements elements = doc.select("h1.title");

        Element insideSpan = elements.first();

        String title = insideSpan.text();

        System.out.println(title);


//        System.out.println(element.toString());

        return null;
    }
}

package pl.edu.agh.to2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PAPScrapper extends Scrapper {

    private final Domain domain = new Domain("https://www.pap.pl");

    public PAPScrapper(){}

    public List<String> getUrls(String html){
        //Regex pattern for relative links
        String pattern = "^\\/[a-zA-Z].*";
        Pattern r = Pattern.compile(pattern);

        // Get DOM of the website
        Document doc = Jsoup.parse(html);
        Elements links = doc.getElementsByTag("a");

        // Extract appropriate urls
        List<String> urls = new LinkedList<>();
        for (Element link : links) {
            String href = link.attr("href");
            Matcher m = r.matcher(href);
            if(m.find()){
                StringBuilder url = new StringBuilder();
                url.append(domain.getUrl());
                url.append(href);
                urls.add(url.toString());
            }
        }

        return urls;
    }

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

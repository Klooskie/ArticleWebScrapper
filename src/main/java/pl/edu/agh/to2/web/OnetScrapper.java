package pl.edu.agh.to2.web;

import pl.edu.agh.to2.persistence.Article;
import pl.edu.agh.to2.persistence.Domain;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OnetScrapper extends Scrapper{
    private final Domain domain = new Domain("https://www.onet.pl");

    public OnetScrapper(){
    }

    public List<String> getUrls(String html) {

        Document doc = Jsoup.parse(html);
        Elements links = doc.getElementsByTag("a");

        String pattern = ".*onet.pl.*";
        Pattern r = Pattern.compile(pattern);

        // Extract appropriate urls
        List<String> urls = new LinkedList<>();
        for (Element link : links) {
            String href = link.attr("href");
            Matcher m = r.matcher(href);
            if (m.find()) {
                if (!urls.contains(href))
                    urls.add(href);
            }
        }

        return urls;
    }

    public boolean checkIfArticle(String html) {
        Document doc = Jsoup.parse(html);

        String title = doc.select("h1[class='mainTitle']").text();
//        String author = doc.select("span[class='name']").text();
        String article_body = doc.select("div[class='detailContent']").text();

        return !(title.isEmpty() || article_body.isEmpty());
    }

    public Article readArticle(String html, String url) {
        Document doc = Jsoup.parse(html);

        String title = doc.select("h1[class='mainTitle']").text();

        // Well, we all like hardcoded dates :)
        String rawDate = "2019-01-05 12:00";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = null;
        try {
            date = formatter.parse(rawDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String author = doc.select("span[class='name']").text();

        String content = doc.select("div[class='detailContent']").text();

        return new Article(title, date, content, author, null, url);
    }

}

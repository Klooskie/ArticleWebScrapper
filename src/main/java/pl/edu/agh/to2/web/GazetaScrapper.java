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

public class GazetaScrapper extends Scrapper{

    private final Domain domain = new Domain("http://www.gazeta.pl");

    public GazetaScrapper(){
    }

    public List<String> getUrls(String html) {

        Document doc = Jsoup.parse(html);
        Elements links = doc.getElementsByTag("a");

        String pattern = ".*gazeta.pl.*";
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

        String title = doc.select("h1[id='article_title']").text();

        String author_and_date = doc.select("div[class='author_and_date']").text();
        String article_body = doc.select("div[id='gazeta_article_body']").text();

        return !(title.isEmpty() || author_and_date.isEmpty() || article_body.isEmpty());
    }

    public Article readArticle(String html, String url) {
        Document doc = Jsoup.parse(html);

        String title = doc.select("h1[id='article_title']").text();

        String rawDate = doc.select("time").attr("datetime");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = null;
        try {
            date = formatter.parse(rawDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String author = doc.select("span[class='article_author']").text();

        String content = doc.select("section[class='art_content']").text();

        return new Article(title, date, content, author, null, url);
    }

}

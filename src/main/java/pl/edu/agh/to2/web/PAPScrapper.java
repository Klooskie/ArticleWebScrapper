package pl.edu.agh.to2.web;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pl.edu.agh.to2.persistence.Article;
import pl.edu.agh.to2.persistence.Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PAPScrapper extends Scrapper {

    private final Domain domain = new Domain("https://www.pap.pl");

    public PAPScrapper() {
    }

    public List<String> getUrls(String html) {

        Document doc = Jsoup.parse(html);
        Elements links = doc.getElementsByTag("a");

        String pattern = "^\\/[a-zA-Z].*";
        Pattern r = Pattern.compile(pattern);

        // Extract appropriate urls
        List<String> urls = new LinkedList<>();
        for (Element link : links) {
            String href = link.attr("href");
            Matcher m = r.matcher(href);
            if (m.find()) {
                StringBuilder url = new StringBuilder();
                url.append(domain.getUrl());
                url.append(href);

                if (!urls.contains(url.toString()))
                    urls.add(url.toString());
            }
        }

        return urls;
    }

    public boolean checkIfArticle(String html) {
        Document doc = Jsoup.parse(html);
        String title = doc.select("h1[class='title']").text();
        String rawDate = doc.select("div[class='moreInfo']").text();
        String text = doc.select("div[property='schema:text']").text();

        if (title.isEmpty() || rawDate.isEmpty() || text.isEmpty())
            return false;

        return true;
    }

    public Article readArticle(String html) {
        Document doc = Jsoup.parse(html);
        String title = doc.select("h1[class='title']").text();

        String rawDate = doc.select("div[class='moreInfo']").text();
        String mainPattern = "([0-9\\-(, ):]*)(aktualizacja: .*)*";
        Pattern p = Pattern.compile(mainPattern);
        Matcher m = p.matcher(rawDate);
        if (m.find()) {
            rawDate = m.group(1);
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd, hh:mm");
        Date date = null;
        try {
            date = formatter.parse(rawDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String text = doc.select("div[property='schema:text']").text();
        mainPattern = "(.*)(autor: ([a-z\\-A-Z ]*))( [a-z]*\\/)*$";
        p = Pattern.compile(mainPattern);
        m = p.matcher(text);

        String author = null;
        String content = null;
        if (m.find()) {
            author = m.group(3);
            content = m.group(1);
        }

        if(content == null){
            content = text;
        }

        Article article = new Article(title, date, content, author);

        return article;
    }
}

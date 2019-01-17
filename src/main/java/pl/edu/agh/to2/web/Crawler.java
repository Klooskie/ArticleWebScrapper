package pl.edu.agh.to2.web;

import pl.edu.agh.to2.persistence.Article;
import pl.edu.agh.to2.persistence.DataBase;
import pl.edu.agh.to2.persistence.Domain;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Crawler {
    private Scrapper scrapper;
    private Domain domain;
    private int maxDepth;

    public Crawler(Domain domain, int maxDepth) {
        this.domain = domain;
        this.maxDepth = maxDepth;
        this.scrapper = makeScrapper(domain);
    }

    public void crawl() {
        crawl(domain.getUrl(), 0);
    }

    private void crawl(String url, int depth) {

        if (depth == maxDepth)
            return;

        String html = downloadHtml(url);

        List<String> urls = scrapper.getUrls(html);

        if (scrapper.checkIfArticle(html)) {
            Article article = scrapper.readArticle(html, url);
            DataBase.save(article, domain);
        }

        for (String newUrl : urls) {
            if(newUrl.equals("https://www.pap.pl/list-of-articles/"))
                continue;
            crawl(newUrl, depth + 1);
        }

    }


    private Scrapper makeScrapper(Domain domain){

        Scrapper scrapper;

        switch (domain.getUrl()) {
            case "https://www.pap.pl":
                scrapper = new PAPScrapper();
                break;

            default:
                return null;
        }

        return scrapper;
    }


    private String downloadHtml(String inputUrl) {

        StringBuffer content = null;

        try {
            URL url = new URL(inputUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");


            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;

            content = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();

            connection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return content.toString();
    }
}

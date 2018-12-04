package pl.edu.agh.to2;

import java.util.List;

public class Crawler {
    Scrapper scrapper;
    DataBase db;
    Domain domain
    int maxDepth;

    public Crawler(Domain domain, DataBase db, int maxDepth) {
        this.scrapper = makeScrapper(domain);

        this.db = db;

        this.domain = domain;

        this.maxDepth = maxDepth;
    }

    public void crawl() {
        crawl(domain.getDomainUrl(), 0);
    }

    private void crawl(String url, int depth) {

        if (depth == maxDepth){
            return;
        }


        //WEB LIBRARY
        String html = getHtml(url);

        List<String> urls = scrapper.getUrls(html);

        if(scrapper.checkIfArticle(html)) {
            Article article = scrapper.readArticle(html);

            db.save(article);
        }

        for(String newUrl: urls) {
            crawl(newUrl, depth + 1);
        }
    }


    private Scrapper makeScrapper(Domain domain){};
}

package pl.edu.agh.to2;

import pl.edu.agh.to2.persistence.DataBase;
import pl.edu.agh.to2.persistence.Domain;
import pl.edu.agh.to2.web.Crawler;



public class Main {

    public static void main(String[] args) {

        Domain domain = new Domain("https://www.pap.pl");
        DataBase.save(domain);

        Crawler crawler =  new Crawler(domain, 2);
        crawler.crawl();

        DataBase.close();
    }
}
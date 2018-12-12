package pl.edu.agh.to2;

import pl.edu.agh.to2.persistence.DataBase;
import pl.edu.agh.to2.persistence.Domain;
import pl.edu.agh.to2.web.Crawler;

public class Main {

    public static void main(String[] args) {

        Domain domain = new Domain("https://www.pap.pl");

        System.out.println(domain.getUrl());

        DataBase db = new DataBase();

        Crawler crawler =  new Crawler(domain, db, 2);

        crawler.crawl();

        System.out.println(db);
    }
}
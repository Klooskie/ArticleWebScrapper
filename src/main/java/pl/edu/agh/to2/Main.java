package pl.edu.agh.to2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
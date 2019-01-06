package pl.edu.agh.to2;

import pl.edu.agh.to2.persistence.Article;
import pl.edu.agh.to2.persistence.DataBase;
import pl.edu.agh.to2.persistence.Domain;
import pl.edu.agh.to2.web.Crawler;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

//        Domain domain = new Domain("https://www.pap.pl");
//
//        System.out.println(domain.getUrl());
//
//        DataBase db = new DataBase();
//
//        Crawler crawler =  new Crawler(domain, db, 2);
//
//        crawler.crawl();
//
//        System.out.println(db);

        String title = "Zaszokował lekarzy, lekarze zszokowani!!";
        String rawDate = "2019-01-06, 12:00";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd, hh:mm");
        Date date = null;
        try {
            date = formatter.parse(rawDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String content = "SZOK SZOK SZOK!";
        String author = "Zbigniew Szok";
        String source = "www.okurwa.pl";
        String url = "a tu to juz nie wiem co dac";
        Article article = new Article(title, date, content, author, source, url, null);


        String title2 = "srfhjnsfyjns!!";
        String rawDate2 = "2019-01-06, 12:00";
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd, hh:mm");
        Date date2 = null;
        try {
            date = formatter.parse(rawDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String content2 = "Ssdgbs!";
        String author2 = "Zsdfgok";
        String source2 = "www.osdfgpl";
        String url2 = "a tu to adh dac";
        Article article2 = new Article(title2, date2, content2, author2, source2, url2, null);

        Domain domain = new Domain("www.pap.pl");
        Domain domain2 = new Domain("www.logo.cum");



        DataBase.save(domain);
        DataBase.save(domain2);
        DataBase.save(article, domain);
        DataBase.save(article2, domain2);
        DataBase.close();

    }
}
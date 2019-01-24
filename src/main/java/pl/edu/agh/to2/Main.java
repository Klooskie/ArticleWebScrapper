package pl.edu.agh.to2;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.edu.agh.to2.gui.controller.DomainSelectionController;
import pl.edu.agh.to2.gui.view.DomainSelectionView;
import pl.edu.agh.to2.persistence.Article;
import pl.edu.agh.to2.persistence.DataBase;
import pl.edu.agh.to2.persistence.Domain;
import pl.edu.agh.to2.web.Crawler;
import pl.edu.agh.to2.web.GazetaScrapper;

import java.util.LinkedList;
import java.util.List;


public class Main extends Application {

    public static void main(String[] args) {
        DataBase.save(new Domain("https://www.pap.pl"));
        DataBase.save(new Domain("https://www.gazeta.pl"));

        launch(args);

        DataBase.close();

        System.exit(0);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("WebScrapper");

        DomainSelectionController domainSelectionController = new DomainSelectionController(primaryStage);
        DomainSelectionView domainSelectionView = new DomainSelectionView(domainSelectionController);
        domainSelectionController.setView(domainSelectionView);

        primaryStage.setScene(domainSelectionView.getScene());
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}

//public class Main {
//
//    public static void main(String[] args) {
//        System.out.println("hello");
//        Domain domain = new Domain("http://www.gazeta.pl");
//        Crawler crawler = new Crawler(domain, 3);
//
//        String html = crawler.downloadHtml(domain.getUrl());
//        GazetaScrapper scrapper = new GazetaScrapper();
//        List<String> urls = scrapper.getUrls(html);
//        for(String url: urls){
//            html = crawler.downloadHtml(url);
//            if(scrapper.checkIfArticle(html)){
//                System.out.println(url);
//                Article article = scrapper.readArticle(html,"abc");
//                System.out.println(article.getTitle());
//                System.out.println(article.getDate());
//                System.out.println(article.getAuthor());
//                System.out.println(article.getContent());
//                System.out.println(article.getSource());
//                System.out.println(article.getUrl());
//            }
//        }
//    }
//}
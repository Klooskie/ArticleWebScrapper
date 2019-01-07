package pl.edu.agh.to2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.edu.agh.to2.persistence.DataBase;
import pl.edu.agh.to2.persistence.Domain;
import pl.edu.agh.to2.scene.ArticleSelectionScene;
import pl.edu.agh.to2.scene.DomainSelectionScene;
import pl.edu.agh.to2.web.Crawler;

import java.util.Scanner;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);

//        Domain domain = new Domain("https://www.pap.pl");
//
//        System.out.println(domain.getUrl());
//
//        DataBase db = new DataBase();
//
//        Crawler crawler = new Crawler(domain, db, 2);
//
//        crawler.crawl();
//
//        System.out.println(db);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("WebScrapper");
        DomainSelectionScene domainSelectionScene = new DomainSelectionScene(primaryStage);
        primaryStage.setScene(domainSelectionScene.getScene());
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
package pl.edu.agh.to2.gui.scene;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.edu.agh.to2.gui.wrappers.ArticleWrapper;
import pl.edu.agh.to2.persistence.DataBase;
import pl.edu.agh.to2.persistence.Domain;
import pl.edu.agh.to2.web.Crawler;

import java.util.Date;
import java.util.List;

public class ArticleSelectionScene extends JFXScene {

    private DomainSelectionScene domainSelectionScene;
    private Domain domain;
    private ObservableList<ArticleWrapper> listOfArticles;


    public ArticleSelectionScene(Stage stage, Domain domain, DomainSelectionScene domainSelectionScene) {
        super(stage);
        this.domain = domain;
        this.domainSelectionScene = domainSelectionScene;
        generateListOfArticles();
        generateScene();
    }

    private void generateListOfArticles() {
        listOfArticles = FXCollections.observableArrayList();

        if (domain.getUrl().equals("https://www.pap.pl")) {
            // wrzucenie do listy artykulow z bazy

            System.out.println("Pobieram z bazy");
            List<ArticleWrapper> articleWrappers = ArticleWrapper.wrapArticles(DataBase.getArticles(domain));

            listOfArticles.addAll(articleWrappers);

            //odswiezenie w nowym watku TODO
//            refreshListOfArticles();
        }

        if (domain.getUrl().equals("PAP2"))
            System.out.println("pap2");

        if (domain.getUrl().equals("PAP3"))
            System.out.println("pap3");
    }

    private void refreshListOfArticles() {
        new Thread(() -> {
                System.out.println("Refreshing");
                System.out.println(domain.getUrl());

                //TODO
                DataBase.save(domain);
                System.out.println("Pobieram z neta");
                Crawler crawler =  new Crawler(domain, 2);
                crawler.crawl();

                listOfArticles.clear();

                System.out.println("Pobietam z bazy");
                List<ArticleWrapper> articleWrappers = ArticleWrapper.wrapArticles(DataBase.getArticles(domain));

                listOfArticles.addAll(articleWrappers);

                System.out.println("Refreshing is over");
        }).start();
    }

    void generateScene() {

        Label sceneTitle = new Label("Lista artukulow z portalu " + domain);

        TableView table = new TableView();

        table.setRowFactory(event -> {
            TableRow<ArticleWrapper> row = new TableRow<>();
            row.setOnMouseClicked(e -> {
                if (e.getClickCount() == 2 && !row.isEmpty()) {
                    ArticleWrapper article = row.getItem();
                    System.out.println("Doubleclick na: " + article.getDate());
                    ArticleScene articleScene = new ArticleScene(stage, domainSelectionScene, this, article);
                    stage.setScene(articleScene.getScene());
                }
            });
            return row;
        });

        TableColumn titleColumn = new TableColumn("Tytul");
        titleColumn.setCellValueFactory(
                new PropertyValueFactory<ArticleWrapper, String>("title")
        );

        TableColumn dateColumn = new TableColumn("Data");
        dateColumn.setCellValueFactory(
                new PropertyValueFactory<ArticleWrapper, Date>("date")
        );

        table.setItems(listOfArticles);
        table.getColumns().addAll(titleColumn, dateColumn);

        Button backButton = new Button("Wroc do wyboru domeny");
        backButton.setOnAction(e -> stage.setScene(domainSelectionScene.getScene()));

        Button refreshButton = new Button("Odswiez liste artykulow");
        refreshButton.setOnAction(e -> {
            refreshButton.setText("Odswiezanie...");
            refreshListOfArticles();
        });

        VBox articleSelectionLayout = new VBox();
        articleSelectionLayout.setAlignment(Pos.CENTER);
        articleSelectionLayout.setSpacing(15);
        articleSelectionLayout.getChildren().addAll(sceneTitle, backButton, refreshButton, table);

        scene = new Scene(articleSelectionLayout, 1280, 720);
    }
}

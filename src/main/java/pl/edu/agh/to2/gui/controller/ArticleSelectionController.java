package pl.edu.agh.to2.gui.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableRow;
import javafx.stage.Stage;
import pl.edu.agh.to2.gui.model.ArticleWrapper;
import pl.edu.agh.to2.gui.view.ArticleDisplayView;
import pl.edu.agh.to2.persistence.DataBase;
import pl.edu.agh.to2.persistence.Domain;
import pl.edu.agh.to2.web.Crawler;

import java.util.List;

public class ArticleSelectionController extends Controller {

    private DomainSelectionController domainSelectionController;
    private Domain domain;
    private ObservableList<ArticleWrapper> listOfArticles;

    public ArticleSelectionController(Stage stage, DomainSelectionController domainSelectionController, Domain domain) {
        super(stage);
        this.domainSelectionController = domainSelectionController;
        this.domain = domain;
        initializeListOfArticles();
    }

    private void initializeListOfArticles() {

        listOfArticles = FXCollections.observableArrayList();

        if (domain.getUrl().equals("https://www.pap.pl"))
            System.out.println("Pobieram z bazy artykuly z portalu PAP");
        if (domain.getUrl().equals("Gazeta"))
            System.out.println("Pobieram z bazy artykuly z portalu GAZETKA");
        if (domain.getUrl().equals("Onet"))
            System.out.println("Pobieram z bazy artykuly z portalu ONECIK");

        List<ArticleWrapper> articleWrappers = ArticleWrapper.wrapArticles(DataBase.getArticles(domain));
        listOfArticles.addAll(articleWrappers);
    }

    private void refreshListOfArticles(Button refreshButton) {
        new Thread(() -> {
            System.out.println("Odswiezanie");
            System.out.println(domain.getUrl());

            //
            DataBase.save(domain);

            System.out.println("Pobieram z neta i zapisuje do bazy");
            Crawler crawler = new Crawler(domain, 2);
            crawler.crawl();

            listOfArticles.clear();

            System.out.println("Pobieram z bazy i aktualizuje wyswietlana liste");
            List<ArticleWrapper> articleWrappers = ArticleWrapper.wrapArticles(DataBase.getArticles(domain));

            listOfArticles.addAll(articleWrappers);

            // kod do wykonania na watku gui
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    refreshButton.setText("Odświeżono, kliknij aby ponowić");
                    refreshButton.setDisable(false);
                }
            });

            System.out.println("Odswiezanie zakonczone");
        }).start();
    }

    public TableRow<ArticleWrapper> handleRowFactoryGeneration() {
        TableRow<ArticleWrapper> row = new TableRow<>();
        row.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2 && !row.isEmpty()) {
                ArticleWrapper article = row.getItem();
                System.out.println("Wykryto double-click na: " + article.getTitle());

                ArticleDisplayController articleDisplayController = new ArticleDisplayController(stage, domainSelectionController, this, article);
                ArticleDisplayView articleDisplayView = new ArticleDisplayView(articleDisplayController);
                stage.setScene(articleDisplayView.getScene());
            }
        });
        return row;
    }

    public void handleBackToDomainSelectionButtonAction() {
        stage.setScene(domainSelectionController.getView().getScene());
    }

    public void handleRefreshButtonAction(Button refreshButton) {
        refreshButton.setDisable(true);
        refreshButton.setText("Odświeżanie...");
        refreshListOfArticles(refreshButton);
    }

    public Domain getDomain() {
        return domain;
    }

    public ObservableList<ArticleWrapper> getListOfArticles() {
        return listOfArticles;
    }
}

package pl.edu.agh.to2.gui.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableRow;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.edu.agh.to2.gui.model.ArticleWrapper;
import pl.edu.agh.to2.gui.view.ArticleDisplayView;
import pl.edu.agh.to2.gui.view.ArticleSearchView;
import pl.edu.agh.to2.persistence.DataBase;
import pl.edu.agh.to2.persistence.Domain;

import java.util.List;

public class ArticleSearchController extends Controller {

    private DomainSelectionController domainSelectionController;
    private String searchedPhrase;
    private ObservableList<ArticleWrapper> listOfArticles;


    public ArticleSearchController(Stage stage, DomainSelectionController domainSelectionController, String searchedPhrase) {
        super(stage);
        this.domainSelectionController = domainSelectionController;
        this.searchedPhrase = searchedPhrase;
        initializeListOfArticles();
    }


    private void initializeListOfArticles() {

        listOfArticles = FXCollections.observableArrayList();

        //TODO
//        List<ArticleWrapper> articleWrappers = ArticleWrapper.wrapArticles(DataBase.getArticles(new Domain("https://www.pap.pl")));
        List<ArticleWrapper> articleWrappers = ArticleWrapper.wrapArticles(DataBase.searchForArticles(searchedPhrase));
        listOfArticles.addAll(articleWrappers);
    }


    public void handleBackToDomainSelectionButtonAction() {
        stage.setScene(domainSelectionController.getView().getScene());
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


    public void handleEnterKeyReleaseInSearchBar(TextField searchBar) {
        String searchedPhrase = searchBar.getText();
        System.out.println("search request for \"" + searchedPhrase + "\"");

        ArticleSearchController articleSearchController = new ArticleSearchController(stage, domainSelectionController, searchedPhrase);
        ArticleSearchView articleSearchView = new ArticleSearchView(articleSearchController);
        articleSearchController.setView(articleSearchView);
        stage.setScene(articleSearchView.getScene());
    }


    public String getSearchedPhrase() {
        return searchedPhrase;
    }


    public ObservableList<ArticleWrapper> getListOfArticles() {
        return listOfArticles;
    }

}

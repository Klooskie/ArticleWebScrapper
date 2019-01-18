package pl.edu.agh.to2.gui.controller;

import javafx.stage.Stage;
import pl.edu.agh.to2.gui.model.ArticleWrapper;

public class ArticleDisplayController extends Controller {

    private DomainSelectionController domainSelectionController;
    private Controller articleListController;
    private ArticleWrapper article;

    public ArticleDisplayController(Stage stage, DomainSelectionController domainSelectionController, Controller articleListController, ArticleWrapper article) {
        super(stage);
        this.domainSelectionController = domainSelectionController;
        this.articleListController = articleListController;
        this.article = article;
    }

    public void handleBackToDomainSelectionButtonAction() {
        stage.setScene(domainSelectionController.getView().getScene());
    }

    public void handleBackToArticleListButtonAction() {
        stage.setScene(articleListController.getView().getScene());
    }

    public ArticleWrapper getArticle() {
        return article;
    }
}

package pl.edu.agh.to2.gui.controller;

import javafx.stage.Stage;
import pl.edu.agh.to2.gui.model.ArticleWrapper;

public class ArticleDisplayController extends Controller {

    private DomainSelectionController domainSelectionController;
    private ArticleSelectionController articleSelectionController;
    private ArticleWrapper article;

    public ArticleDisplayController(Stage stage, DomainSelectionController domainSelectionController, ArticleSelectionController articleSelectionController, ArticleWrapper article) {
        super(stage);
        this.domainSelectionController = domainSelectionController;
        this.articleSelectionController = articleSelectionController;
        this.article = article;
    }

    public void handleBackToDomainSelectionButtonAction() {
        stage.setScene(domainSelectionController.getView().getScene());
    }

    public void handleBackButtonAction() {
        stage.setScene(articleSelectionController.getView().getScene());
    }

    public ArticleWrapper getArticle() {
        return article;
    }
}

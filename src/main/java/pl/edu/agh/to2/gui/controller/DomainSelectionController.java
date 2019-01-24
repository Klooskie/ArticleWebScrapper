package pl.edu.agh.to2.gui.controller;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.edu.agh.to2.gui.view.ArticleSearchView;
import pl.edu.agh.to2.gui.view.ArticleSelectionView;
import pl.edu.agh.to2.persistence.Domain;


public class DomainSelectionController extends Controller {

    private ArticleSelectionController papArticleSelectionController;
    private ArticleSelectionController gazetaArticleSelectionController;
    private ArticleSelectionController onetArticleSelectionController;

    public DomainSelectionController(Stage stage) {
        super(stage);
        this.papArticleSelectionController = null;
        this.gazetaArticleSelectionController = null;
        this.onetArticleSelectionController = null;
    }

    public void handlePapButtonAction() {
        if (papArticleSelectionController == null) {
            Domain papDomain = new Domain("https://www.pap.pl");
            papArticleSelectionController = new ArticleSelectionController(stage, this, papDomain);
            ArticleSelectionView articleSelectionView = new ArticleSelectionView(papArticleSelectionController);
            papArticleSelectionController.setView(articleSelectionView);
        }
        stage.setScene(papArticleSelectionController.getView().getScene());
    }

    public void handleGazetaButtonAction() {
        if (gazetaArticleSelectionController == null) {
            Domain gazetaDomain = new Domain("http://www.gazeta.pl");
            gazetaArticleSelectionController = new ArticleSelectionController(stage, this, gazetaDomain);
            ArticleSelectionView articleSelectionView = new ArticleSelectionView(gazetaArticleSelectionController);
            gazetaArticleSelectionController.setView(articleSelectionView);
        }
        stage.setScene(gazetaArticleSelectionController.getView().getScene());
    }

    public void handleOnetButtonAction() {
        if (onetArticleSelectionController == null) {
            Domain onetDomain = new Domain("Onet");
            onetArticleSelectionController = new ArticleSelectionController(stage, this, onetDomain);
            ArticleSelectionView articleSelectionView = new ArticleSelectionView(onetArticleSelectionController);
            onetArticleSelectionController.setView(articleSelectionView);
        }
        stage.setScene(onetArticleSelectionController.getView().getScene());
    }

    public void handleEnterKeyReleaseInSearchBar(TextField searchBar) {
        String searchedPhrase = searchBar.getText();
        System.out.println("search request for \"" + searchedPhrase + "\"");

        ArticleSearchController articleSearchController = new ArticleSearchController(stage, this, searchedPhrase);
        ArticleSearchView articleSearchView = new ArticleSearchView(articleSearchController);
        articleSearchController.setView(articleSearchView);
        stage.setScene(articleSearchView.getScene());
    }
}

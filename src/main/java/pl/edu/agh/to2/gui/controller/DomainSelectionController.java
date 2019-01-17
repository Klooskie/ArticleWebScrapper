package pl.edu.agh.to2.gui.controller;

import javafx.stage.Stage;
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
        if(papArticleSelectionController == null) {
            Domain papDomain = new Domain("https://www.pap.pl");
            papArticleSelectionController = new ArticleSelectionController(stage, this, papDomain);
            ArticleSelectionView articleSelectionView = new ArticleSelectionView(papArticleSelectionController);
            papArticleSelectionController.setView(articleSelectionView);
        }
        stage.setScene(papArticleSelectionController.getView().getScene());
    }

    public void handleGazetaButtonAction() {
        if(gazetaArticleSelectionController == null) {
            Domain gazetaDomain = new Domain("Gazeta");
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
}

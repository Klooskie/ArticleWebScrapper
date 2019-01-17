package pl.edu.agh.to2.gui.scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.edu.agh.to2.gui.wrappers.ArticleWrapper;

public class ArticleScene extends JFXScene {

    private DomainSelectionScene domainSelectionScene;
    private ArticleSelectionScene articleSelectionScene;
    private ArticleWrapper article;

    public ArticleScene(Stage stage, DomainSelectionScene domainSelectionScene, ArticleSelectionScene articleSelectionScene, ArticleWrapper article) {
        super(stage);
        this.domainSelectionScene = domainSelectionScene;
        this.articleSelectionScene = articleSelectionScene;
        this.article = article;
        generateScene();
    }

    void generateScene() {
        Button backToDomainSelectionButton = new Button("Wróć do wyboru domeny");
        backToDomainSelectionButton.setOnAction(e -> stage.setScene(domainSelectionScene.getScene()));

        Button backButton = new Button("Wróć do wyboru artykułu");
        backButton.setOnAction(e -> stage.setScene(articleSelectionScene.getScene()));

        Label articleTitle = new Label(article.getTitle());
        articleTitle.setWrapText(true);

        Label articleDate = new Label(article.getDate().toString());

        Label articleAuthor;
        if (article.getAuthor() != null)
            articleAuthor = new Label(article.getAuthor());
        else
            articleAuthor = new Label("brak podanego autora");

        Label articleContent = new Label(article.getContent());
        articleContent.setWrapText(true);
        articleContent.setPrefWidth(1200);

        HBox buttonsLayout = new HBox();
        buttonsLayout.setAlignment(Pos.CENTER);
        buttonsLayout.setSpacing(15);
        buttonsLayout.getChildren().addAll(
                backToDomainSelectionButton,
                backButton
        );

        VBox articleLayout = new VBox();
        articleLayout.setAlignment(Pos.CENTER);
        articleLayout.setSpacing(20);
        articleLayout.getChildren().addAll(
                buttonsLayout,
                articleTitle,
                articleDate,
                articleAuthor,
                articleContent
        );
        VBox.setMargin(buttonsLayout, new Insets(30, 0, 0, 0));

        ScrollPane scrollableArticleLayout = new ScrollPane();
        scrollableArticleLayout.setContent(articleLayout);
        scrollableArticleLayout.setFitToWidth(true);

        scene = new Scene(scrollableArticleLayout, 1280, 720);
    }


}

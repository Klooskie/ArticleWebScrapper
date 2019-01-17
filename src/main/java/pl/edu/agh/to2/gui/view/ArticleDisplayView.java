package pl.edu.agh.to2.gui.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.edu.agh.to2.gui.controller.ArticleDisplayController;
import pl.edu.agh.to2.gui.controller.Controller;
import pl.edu.agh.to2.gui.model.ArticleWrapper;

public class ArticleDisplayView extends JFXView {

    public ArticleDisplayView(Controller controller) {
        super(controller);
    }

    @Override
    void generateScene() {
        Button backToDomainSelectionButton = new Button("Wróć do wyboru domeny");
        backToDomainSelectionButton.setOnAction(e ->
                ((ArticleDisplayController) controller).handleBackToDomainSelectionButtonAction()
        );

        Button backButton = new Button("Wróć do wyboru artykułu");
        backButton.setOnAction(e ->
                ((ArticleDisplayController) controller).handleBackButtonAction()
        );

        Label articleTitle = new Label(((ArticleDisplayController) controller).getArticle().getTitle());
        articleTitle.setWrapText(true);

        Label articleDate = new Label(((ArticleDisplayController) controller).getArticle().getDate().toString());

        Label articleAuthor;
        if (((ArticleDisplayController) controller).getArticle().getAuthor() != null)
            articleAuthor = new Label(((ArticleDisplayController) controller).getArticle().getAuthor());
        else
            articleAuthor = new Label("brak podanego autora");

        Label articleContent = new Label(((ArticleDisplayController) controller).getArticle().getContent());
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

package pl.edu.agh.to2.gui.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import pl.edu.agh.to2.gui.controller.ArticleSearchController;
import pl.edu.agh.to2.gui.controller.Controller;
import pl.edu.agh.to2.gui.model.ArticleWrapper;
import pl.edu.agh.to2.persistence.Domain;

import java.util.Date;

public class ArticleSearchView extends JFXView {

    public ArticleSearchView(Controller controller) {
        super(controller);
    }

    @Override
    void generateScene() {

        Label sceneTitle = new Label("Lista artukułów znalezionych dla frazy: \"" +
                ((ArticleSearchController) controller).getSearchedPhrase() + "\"");

        Button backButton = new Button("Wróć do wyboru domeny");
        backButton.setOnAction(e ->
                ((ArticleSearchController) controller).handleBackToDomainSelectionButtonAction()
        );

        TableView table = new TableView();

        table.setRowFactory(x -> {
            return ((ArticleSearchController) controller).handleRowFactoryGeneration();
        });

        TableColumn titleColumn = new TableColumn("Tytuł");
        titleColumn.prefWidthProperty().bind(table.widthProperty().multiply(0.65));
        titleColumn.setCellValueFactory(
                new PropertyValueFactory<ArticleWrapper, String>("title")
        );

        TableColumn dateColumn = new TableColumn("Data");
        dateColumn.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
        dateColumn.setCellValueFactory(
                new PropertyValueFactory<ArticleWrapper, Date>("date")
        );

        TableColumn domainColumn = new TableColumn("Domena");
        domainColumn.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
        domainColumn.setCellValueFactory(
                new PropertyValueFactory<ArticleWrapper, String>("domainUrl")
        );



        table.setItems(((ArticleSearchController) controller).getListOfArticles());
        table.getColumns().addAll(titleColumn, dateColumn, domainColumn);

        Label searchLabel = new Label("Szukaj artykułów:");

        TextField searchBar = new TextField();
        searchBar.setMaxWidth(300);
        searchBar.setOnKeyReleased(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                ((ArticleSearchController) controller).handleEnterKeyReleaseInSearchBar(searchBar);
            }
        });


        VBox articleSelectionLayout = new VBox();
        articleSelectionLayout.setAlignment(Pos.CENTER);
        articleSelectionLayout.setSpacing(15);
        articleSelectionLayout.getChildren().addAll(sceneTitle, backButton, table, searchLabel, searchBar);

        scene = new Scene(articleSelectionLayout, 1280, 720);
    }
}

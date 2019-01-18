package pl.edu.agh.to2.gui.view;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.edu.agh.to2.gui.controller.ArticleSelectionController;
import pl.edu.agh.to2.gui.controller.Controller;
import pl.edu.agh.to2.gui.controller.DomainSelectionController;
import pl.edu.agh.to2.gui.model.ArticleWrapper;
import pl.edu.agh.to2.persistence.DataBase;
import pl.edu.agh.to2.persistence.Domain;
import pl.edu.agh.to2.web.Crawler;

import java.util.Date;
import java.util.List;

public class ArticleSelectionView extends JFXView {

    public ArticleSelectionView(Controller controller) {
        super(controller);
        generateScene();
    }

    @Override
    void generateScene() {

        Label sceneTitle = new Label("Lista artukułów z portalu " +
                ((ArticleSelectionController) controller).getDomain().getUrl());

        TableView table = new TableView();

        table.setRowFactory(x -> {
            return ((ArticleSelectionController) controller).handleRowFactoryGeneration();
        });

        TableColumn titleColumn = new TableColumn("Tytuł");
        titleColumn.prefWidthProperty().bind(table.widthProperty().multiply(0.7));
        titleColumn.setCellValueFactory(
                new PropertyValueFactory<ArticleWrapper, String>("title")
        );

        TableColumn dateColumn = new TableColumn("Data");
        dateColumn.prefWidthProperty().bind(table.widthProperty().multiply(0.3));
        dateColumn.setCellValueFactory(
                new PropertyValueFactory<ArticleWrapper, Date>("date")
        );

        table.setItems(((ArticleSelectionController) controller).getListOfArticles());
        table.getColumns().addAll(titleColumn, dateColumn);

        Button backButton = new Button("Wróć do wyboru domeny");
        backButton.setOnAction(e ->
                ((ArticleSelectionController) controller).handleBackToDomainSelectionButtonAction()
        );

        Button refreshButton = new Button("Odśwież listę artykułów");
        refreshButton.setOnAction(e ->
                ((ArticleSelectionController) controller).handleRefreshButtonAction(refreshButton)
        );

        VBox articleSelectionLayout = new VBox();
        articleSelectionLayout.setAlignment(Pos.CENTER);
        articleSelectionLayout.setSpacing(15);
        articleSelectionLayout.getChildren().addAll(sceneTitle, backButton, refreshButton, table);

        scene = new Scene(articleSelectionLayout, 1280, 720);
    }
}

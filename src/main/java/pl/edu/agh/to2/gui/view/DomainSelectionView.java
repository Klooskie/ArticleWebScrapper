package pl.edu.agh.to2.gui.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import pl.edu.agh.to2.gui.controller.Controller;
import pl.edu.agh.to2.gui.controller.DomainSelectionController;


public class DomainSelectionView extends JFXView {

    public DomainSelectionView(Controller controller) {
        super(controller);
    }

    @Override
    void generateScene() {

        Label sceneTitle = new Label("WebScrapper");
        sceneTitle.setFont(new Font("Arial", 30));
        sceneTitle.setTextFill(Color.web("#0076a3"));

        Label chooseLabel = new Label("Wybierz portal:");

        Button papButton = new Button("PAP");
        papButton.setOnAction(e -> {
            ((DomainSelectionController) controller).handlePapButtonAction();
        });

        Button gazetaButton = new Button("Gazeta.pl");
        gazetaButton.setOnAction(e -> {
            ((DomainSelectionController) controller).handleGazetaButtonAction();
        });

        Button onetButton = new Button("Onet");
        onetButton.setOnAction(e -> {
            ((DomainSelectionController) controller).handleOnetButtonAction();
        });

        Label searchLabel = new Label("Szukaj artykułów:");

        TextField searchBar = new TextField();
        searchBar.setMaxWidth(300);
        searchBar.setOnKeyReleased(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER){
                ((DomainSelectionController) controller).handleEnterKeyReleaseInSearchBar(searchBar);
            }
        });

        VBox domainSelectionLayout = new VBox();
        domainSelectionLayout.setAlignment(Pos.CENTER);
        domainSelectionLayout.setSpacing(20);
        domainSelectionLayout.getChildren().addAll(sceneTitle, chooseLabel, papButton, gazetaButton, onetButton, searchLabel, searchBar);

        scene = new Scene(domainSelectionLayout, 1280, 720);
    }

}

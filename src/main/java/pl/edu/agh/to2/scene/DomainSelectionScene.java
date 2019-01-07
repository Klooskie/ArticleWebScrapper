package pl.edu.agh.to2.scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DomainSelectionScene extends JFXScene {

    public DomainSelectionScene(Stage stage) {
        super(stage);
        generateScene();
    }

    void generateScene() {

        Label sceneTitle = new Label("Wybierz portal:");

        Button papButton = new Button("PAP");
        papButton.setOnAction(e -> {
            ArticleSelectionScene articleSelectionScene = new ArticleSelectionScene(stage, "https://www.pap.pl", this);
            stage.setScene(articleSelectionScene.getScene());
        });

        Button pap2Button = new Button("PAP2");
        pap2Button.setOnAction(e -> {
            ArticleSelectionScene articleSelectionScene = new ArticleSelectionScene(stage, "PAP2", this);
            stage.setScene(articleSelectionScene.getScene());
        });

        Button pap3Button = new Button("PAP3");
        pap3Button.setOnAction(e -> {
            ArticleSelectionScene articleSelectionScene = new ArticleSelectionScene(stage, "PAP3", this);
            stage.setScene(articleSelectionScene.getScene());
        });

        VBox domainSelectionLayout = new VBox();
        domainSelectionLayout.setAlignment(Pos.CENTER);
        domainSelectionLayout.setSpacing(10);
        domainSelectionLayout.getChildren().addAll(sceneTitle, papButton, pap2Button, pap3Button);

        scene = new Scene(domainSelectionLayout, 1280, 720);
    }

}

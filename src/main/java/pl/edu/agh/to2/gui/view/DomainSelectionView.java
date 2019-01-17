package pl.edu.agh.to2.gui.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import pl.edu.agh.to2.gui.controller.Controller;
import pl.edu.agh.to2.gui.controller.DomainSelectionController;

public class DomainSelectionView extends JFXView {

    public DomainSelectionView(Controller controller) {
        super(controller);
    }

    @Override
    void generateScene() {

        Label sceneTitle = new Label("Wybierz portal:");

        Button papButton = new Button("PAP");
        papButton.setOnAction(e -> {
            ((DomainSelectionController) controller).handlePapButtonAction();
        });

        Button pap2Button = new Button("Gazeta.pl");
        pap2Button.setOnAction(e -> {
            ((DomainSelectionController) controller).handleGazetaButtonAction();
        });

        Button pap3Button = new Button("Onet");
        pap3Button.setOnAction(e -> {
            ((DomainSelectionController) controller).handleOnetButtonAction();
        });

        VBox domainSelectionLayout = new VBox();
        domainSelectionLayout.setAlignment(Pos.CENTER);
        domainSelectionLayout.setSpacing(10);
        domainSelectionLayout.getChildren().addAll(sceneTitle, papButton, pap2Button, pap3Button);

        scene = new Scene(domainSelectionLayout, 1280, 720);
    }

}

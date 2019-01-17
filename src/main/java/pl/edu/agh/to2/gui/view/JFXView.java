package pl.edu.agh.to2.gui.view;

import javafx.scene.Scene;
import pl.edu.agh.to2.gui.controller.Controller;

public abstract class JFXView {

    Controller controller;
    Scene scene;

    public JFXView(Controller controller) {
        this.controller = controller;
        generateScene();
    }

    abstract void generateScene();

    public Scene getScene() {
        return scene;
    }
}

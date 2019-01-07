package pl.edu.agh.to2.scene;

import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class JFXScene {

    Scene scene;
    Stage stage;

    public JFXScene(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    abstract void generateScene();
}

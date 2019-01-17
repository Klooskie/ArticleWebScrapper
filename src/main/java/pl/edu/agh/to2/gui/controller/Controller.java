package pl.edu.agh.to2.gui.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.edu.agh.to2.gui.view.JFXView;

public abstract class Controller {

    Stage stage;
    JFXView view;

    public Controller(Stage stage) {
        this.stage = stage;
    }

    public void setView(JFXView view) {
        this.view = view;
    }

    public JFXView getView() {
        return view;
    }
}

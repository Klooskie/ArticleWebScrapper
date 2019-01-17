package pl.edu.agh.to2;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.edu.agh.to2.gui.scene.DomainSelectionScene;
import pl.edu.agh.to2.persistence.DataBase;
import pl.edu.agh.to2.persistence.Domain;


public class Main extends Application {

    public static void main(String[] args) {
        DataBase.save(new Domain("https://www.pap.pl"));
        //TODO reszta domen

        launch(args);

        DataBase.close();

        System.exit(0);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("WebScrapper");
        DomainSelectionScene domainSelectionScene = new DomainSelectionScene(primaryStage);
        primaryStage.setScene(domainSelectionScene.getScene());
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
package fi.metropolia.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fi/metropolia/view/currency_view.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("Currency Converter");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

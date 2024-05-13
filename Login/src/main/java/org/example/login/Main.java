package org.example.login;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
class MacStyleWindowUtil {

    public static void createMacStyleWindow (Stage primaryStage) {
        // Remove default window decoration
        primaryStage.initStyle(StageStyle.UNDECORATED);

    }
}
    public class Main extends Application {

        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            String Css = this.getClass().getResource("login.css").toExternalForm();
            scene.getStylesheets().add(Css);

            MacStyleWindowUtil.createMacStyleWindow(stage);
            stage.setTitle("Hello!");
            //stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            launch();
        }
    }

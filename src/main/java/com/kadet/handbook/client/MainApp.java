package com.kadet.handbook.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Date: 22.12.13
 * Time: 2:38
 *
 * @author Кадет
 */
public class MainApp extends Application {

    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start (Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Parent root
                = (Parent) loader.load(
                                    getClass().getResourceAsStream(DataStrings.FRAME_XML_PATH)
        );
        stage.setTitle(Messages.APPLICATION_TITLE);
        stage.setScene(
                new Scene(root));
        stage.show();
    }
}

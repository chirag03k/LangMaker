package com.langconstructor.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import com.langconstructor.langcomponents.Language;

import java.io.IOException;

public class LangApplication extends Application {

    Stage mainStage;
    public static boolean running;
    public static Language openedLanguage;

    public static final int APP_WIDTH = 1500;
    public static final int APP_HEIGHT = 930;


    public static void main(String... args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        mainStage = primaryStage;
        mainStage.getIcons().add(new Image("/Images/icon.png"));
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/HomeScreen.fxml"));

        Scene scene = new Scene(root, 1000, 550);
        mainStage.setTitle("Welcome to LangMaker!");
        mainStage.setScene(scene);
        mainStage.show();
        running=true;
    }


}

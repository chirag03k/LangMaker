package com.chiragkawediya.langmaker.gui;

import com.chiragkawediya.langmaker.main.LangApplication;
import com.chiragkawediya.langmaker.langcomponents.Language;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeScreenController {


    @FXML
    private void initialize() {

    }

    @FXML
    private void toLanguageEditor(ActionEvent event) throws IOException {
        LangApplication.openedLanguage = new Language();
        LangApplication.openedLanguage.initializeNew();

        System.out.println("The exception will be thrown right before editor.fxml");
        Parent editorParent = FXMLLoader.load(getClass().getResource("/fxml/Editor.fxml"));
        Scene editorScene = new Scene(editorParent, LangApplication.APP_WIDTH, LangApplication.APP_HEIGHT);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        Stage editorStage = new Stage();
        editorStage.setScene(editorScene);
        editorStage.setTitle("LangMaker Language Editor");
        editorStage.getIcons().add(new Image("/Images/icon.png"));

        stage.close();
        editorStage.show();

        EditorController.currentStage = editorStage;
    }

}

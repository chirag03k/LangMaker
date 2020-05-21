package com.langconstructor.guicontrollers;

import com.langconstructor.main.LangApplication;
import com.langconstructor.langcomponents.Language;
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

package com.langconstructor.guicontrollers;

import com.langconstructor.langTree.Word;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditorController {

    static Stage currentStage;

    @FXML
    private VBox wordListBox;

    @FXML
    private void initialize() {

    }

    public void showWordOnList(Word w) {
        String word = w.string;

        Button wordButton = new Button(word);

        wordListBox.getChildren().add(wordButton);

        currentStage.show();
    }

    // Alphabet

    private void addPhoneme() {

    }

}

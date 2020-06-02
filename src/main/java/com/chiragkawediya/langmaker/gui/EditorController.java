package com.chiragkawediya.langmaker.gui;

import com.chiragkawediya.langmaker.langTree.Word;
import com.chiragkawediya.langmaker.main.LangApplication;
import com.chiragkawediya.langmaker.langcomponents.Language;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditorController {


    private Language language;

    @FXML
    private PhonologyTabController phonologyTabController;

    // Tabs
    @FXML
    private TabPane mainSelectionTab;
    @FXML
    private Tab phonologyTabSelection;
    @FXML
    private Tab grammarTab;
    @FXML
    private Tab lexiconTab;

    @FXML
    private void initialize() {
        language = LangApplication.openedLanguage;
    }

    static Stage currentStage;

    // ----------------------------------------------------------------------------------------------------- Lexicon tab

    @FXML
    private VBox wordListBox;


    public void showWordOnList(Word w) {
        String word = w.string;
        Button wordButton = new Button(word);
        wordListBox.getChildren().add(wordButton);
        currentStage.show();
    }
}

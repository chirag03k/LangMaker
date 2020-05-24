package com.langconstructor.gui;

import com.langconstructor.langTree.Word;
import com.langconstructor.langcomponents.Language;
import com.langconstructor.langcomponents.alphabet.*;
import com.langconstructor.main.LangApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

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

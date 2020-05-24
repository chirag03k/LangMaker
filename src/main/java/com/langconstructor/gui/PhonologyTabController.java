package com.langconstructor.gui;

import com.langconstructor.langcomponents.Language;
import com.langconstructor.langcomponents.alphabet.*;
import com.langconstructor.main.LangApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class PhonologyTabController {

    Language language;

    private List<Phone> currentPronunciation = new ArrayList<>();

    public void initialize() {
        language = LangApplication.openedLanguage;
        displayAlphabet();
    }

    @FXML
    private ListView<Phoneme> phonemeList;
    @FXML
    private Button removePhonemeButton;
    @FXML
    private Label pronunciationLabel;
    @FXML
    private TextField newPhonemeSymbol;
    @FXML
    private TextField newPhonemeType;
    @FXML
    private TableView<Consonants> consonantsTable;
    @FXML
    private TableView<Vowels> vowelsTable;

    @FXML
    private void displayAlphabet() {
        Alphabet ab = language.alphabet;
        ObservableList<Phoneme> alphabetList = FXCollections.observableArrayList(ab.getPhonemeList());
        phonemeList.setItems(alphabetList);
    }

    @FXML
    private void addPhoneme() {
        String symbol = newPhonemeSymbol.getText();
        String type = newPhonemeType.getText();
        if (type == null) {
            type = "";
        }

        language.alphabet.addPhoneme((ArrayList)((ArrayList)currentPronunciation).clone(), symbol, type);

        currentPronunciation = new ArrayList<>();

        displayAlphabet();
    }

    // The following two methods are used to add sounds to the pronunciationLabel

    @FXML
    private void showConsonant() {
        Phone c = consonantsTable.getSelectionModel().getSelectedItem();
        String curPron = pronunciationLabel.getText();
        pronunciationLabel.setText(curPron + c.getSymbol());
        currentPronunciation.add(c);
    }

    @FXML
    private void showVowel() {
        Phone v = vowelsTable.getSelectionModel().getSelectedItem();
        String curPron = pronunciationLabel.getText();
        pronunciationLabel.setText(curPron+v.getSymbol());
        currentPronunciation.add(v);
    }

    private void populateTableViews() {
        // TODO: POPULATE TABLEVIEWS
    }

}

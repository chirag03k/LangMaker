package com.langconstructor.gui;

import com.langconstructor.gui.util.ConsonantRow;
import com.langconstructor.langcomponents.Language;
import com.langconstructor.langcomponents.alphabet.*;
import com.langconstructor.main.LangApplication;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.*;

public class PhonologyTabController {

    Language language;

    private List<Phone> currentPronunciation = new ArrayList<>();

    public void initialize() {
        language = LangApplication.openedLanguage;
        populateTableViews();
        displayAlphabet();
    }

    @FXML
    private ListView<Phoneme> phonemeList;
    @FXML
    private Button removePhonemeButton;
    @FXML
    private TextField pronunciationLabel;
    @FXML
    private TextField newPhonemeSymbol;
    @FXML
    private TextField newPhonemeType;
    @FXML
    private TableView consonantsTable;
    @FXML
    private TableView<Phone> vowelsTable;

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

        language.alphabet.addPhoneme((ArrayList<Phone>)((ArrayList)currentPronunciation).clone(), symbol, type);

        currentPronunciation = new ArrayList<>();

        newPhonemeSymbol.setText("");
        newPhonemeType.setText("");
        pronunciationLabel.setText("");
        displayAlphabet();
    }

    // The following two methods are used to add sounds to the pronunciationLabel

    @FXML
    private void showConsonant() {
        ObservableList<TablePosition> selectedCells = consonantsTable.getSelectionModel().getSelectedCells();
        TablePosition selectedCell = selectedCells.get(0);
        TableColumn column = selectedCell.getTableColumn();
        int rowIndex = selectedCell.getRow();
        Phone c = (Phone) column.getCellObservableValue(rowIndex).getValue();
        String curPron = pronunciationLabel.getText();
        pronunciationLabel.setText(curPron + c.getSymbol());
        currentPronunciation.add(c);
    }

    @FXML
    private void showVowel() {
        ObservableList<TablePosition> selectedCells = vowelsTable.getSelectionModel().getSelectedCells();
        TablePosition selectedCell = selectedCells.get(0);
        TableColumn column = selectedCell.getTableColumn();
        int rowIndex = selectedCell.getRow();
        Phone v = (Phone) column.getCellObservableValue(rowIndex).getValue();
        String curPron = pronunciationLabel.getText();
        pronunciationLabel.setText(curPron+v.getSymbol());
        currentPronunciation.add(v);
    }

    @FXML
    private void removePhoneme() {
        Phoneme p = phonemeList.getSelectionModel().getSelectedItem();

        language.alphabet.removePhoneme(p);
        displayAlphabet();
    }

    private void populateTableViews() {

        consonantsTable.getSelectionModel().setCellSelectionEnabled(true);
        vowelsTable.getSelectionModel().setCellSelectionEnabled(true);

        // CONSONANTS TABLE

        TableColumn mannerCol = new TableColumn("Manner");
        mannerCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, String>("manner")
        );

        TableColumn bilabialCol = new TableColumn("Bilabial");
        TableColumn bilabialUnvoicedCol = new TableColumn("Unvoiced");
        TableColumn bilabialVoicedCol = new TableColumn("Voiced");
        bilabialCol.getColumns().addAll(bilabialUnvoicedCol, bilabialVoicedCol);
        bilabialUnvoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("bilabialUnvoiced")
        );
        bilabialVoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("bilabialVoiced")
        );

        TableColumn labiodentalCol = new TableColumn("labiodental");
        TableColumn labiodentalUnvoicedCol = new TableColumn("Unvoiced");
        TableColumn labiodentalVoicedCol = new TableColumn("Voiced");
        labiodentalCol.getColumns().addAll(labiodentalUnvoicedCol, labiodentalVoicedCol);
        labiodentalUnvoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("labiodentalUnvoiced")
        );
        labiodentalVoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("labiodentalVoiced")
        );

        TableColumn linguolabialCol = new TableColumn("linguolabial");
        TableColumn linguolabialUnvoicedCol = new TableColumn("Unvoiced");
        TableColumn linguolabialVoicedCol = new TableColumn("Voiced");
        linguolabialCol.getColumns().addAll(linguolabialUnvoicedCol, linguolabialVoicedCol);
        linguolabialUnvoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("linguolabialUnvoiced")
        );
        linguolabialVoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("linguolabialVoiced")
        );

        TableColumn dentalCol = new TableColumn("dental");
        TableColumn dentalUnvoicedCol = new TableColumn("Unvoiced");
        TableColumn dentalVoicedCol = new TableColumn("Voiced");
        dentalCol.getColumns().addAll(dentalUnvoicedCol, dentalVoicedCol);
        dentalUnvoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("dentalUnvoiced")
        );
        dentalVoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("dentalVoiced")
        );

        TableColumn alveolarCol = new TableColumn("alveolar");
        TableColumn alveolarUnvoicedCol = new TableColumn("Unvoiced");
        TableColumn alveolarVoicedCol = new TableColumn("Voiced");
        alveolarCol.getColumns().addAll(alveolarUnvoicedCol, alveolarVoicedCol);
        alveolarUnvoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("alveolarUnvoiced")
        );
        alveolarVoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("alveolarVoiced")
        );

        TableColumn postAlveolarCol = new TableColumn("post-alveolar");
        TableColumn postAlveolarUnvoicedCol = new TableColumn("Unvoiced");
        TableColumn postAlveolarVoicedCol = new TableColumn("Voiced");
        postAlveolarCol.getColumns().addAll(postAlveolarUnvoicedCol, postAlveolarVoicedCol);
        postAlveolarUnvoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("postAlveolarUnvoiced")
        );
        postAlveolarVoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("postAlveolarVoiced")
        );

        TableColumn retroflexCol = new TableColumn("RetroFlex");
        TableColumn retroflexUnvoicedCol = new TableColumn("Unvoiced");
        TableColumn retroflexVoicedCol = new TableColumn("Voiced");
        retroflexCol.getColumns().addAll(retroflexUnvoicedCol, retroflexVoicedCol);
        retroflexUnvoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("retroFlexUnvoiced")
        );
        retroflexVoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("retroFlexVoiced")
        );

        TableColumn palatalCol = new TableColumn("palatal");
        TableColumn palatalUnvoicedCol = new TableColumn("Unvoiced");
        TableColumn palatalVoicedCol = new TableColumn("Voiced");
        palatalCol.getColumns().addAll(palatalUnvoicedCol, palatalVoicedCol);
        palatalUnvoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("palatalUnvoiced")
        );
        palatalVoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("palatalVoiced")
        );

        TableColumn velarCol = new TableColumn("velar");
        TableColumn velarUnvoicedCol = new TableColumn("Unvoiced");
        TableColumn velarVoicedCol = new TableColumn("Voiced");
        velarCol.getColumns().addAll(velarUnvoicedCol, velarVoicedCol);
        velarUnvoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("velarUnvoiced")
        );
        velarVoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("velarVoiced")
        );

        TableColumn uvularCol = new TableColumn("uvular");
        TableColumn uvularUnvoicedCol = new TableColumn("Unvoiced");
        TableColumn uvularVoicedCol = new TableColumn("Voiced");
        uvularCol.getColumns().addAll(uvularUnvoicedCol, uvularVoicedCol);
        uvularUnvoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("uvularUnvoiced")
        );
        uvularVoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("uvularVoiced")
        );

        TableColumn epiglottalCol = new TableColumn("epiglottal");
        TableColumn epiglottalUnvoicedCol = new TableColumn("Unvoiced");
        TableColumn epiglottalVoicedCol = new TableColumn("Voiced");
        epiglottalCol.getColumns().addAll(epiglottalUnvoicedCol, epiglottalVoicedCol);
        epiglottalUnvoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("epiglottalUnvoiced")
        );
        epiglottalVoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("epiglottalVoiced")
        );

        TableColumn glottalCol = new TableColumn("glottal");
        TableColumn glottalUnvoicedCol = new TableColumn("Unvoiced");
        TableColumn glottalVoicedCol = new TableColumn("Voiced");
        glottalCol.getColumns().addAll(glottalUnvoicedCol, glottalVoicedCol);
        glottalUnvoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("glottalUnvoiced")
        );
        glottalVoicedCol.setCellValueFactory(
                new PropertyValueFactory<ConsonantRow, Consonants>("glottalVoiced")
        );

        consonantsTable.getColumns().addAll(mannerCol, bilabialCol, labiodentalCol, linguolabialCol, dentalCol, alveolarCol, postAlveolarCol, retroflexCol, palatalCol, velarCol, uvularCol, epiglottalCol, glottalCol);

        final ObservableList<ConsonantRow> consonantTableData = FXCollections.observableArrayList(
                new ConsonantRow(
                        (StringProperty) new SimpleStringProperty("Nasal"),
                        Consonants.BILIABIAL_NASAL_VOICELESS,
                        Consonants.BILABIAL_NASAL_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.LABIODENTAL_NASAL_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.LINGUOLABIAL_NASAL_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.ALVEOLAR_NASAL_VOICELESS,
                        Consonants.ALVEOLAR_NASAL_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.RETROFLEX_NASAL_VOICELESS,
                        Consonants.RETROFLEX_NASAL_VOICED,
                        Consonants.PALATAL_NASAL_VOICELESS,
                        Consonants.PALATAL_NASAL_VOICED,
                        Consonants.VELAR_NASAL_VOICELESS,
                        Consonants.VELAR_NASAL_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.UVULAR_NASAL_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT
                ),
                new ConsonantRow(
                        (StringProperty) new SimpleStringProperty("STOP"),
                        Consonants.NULL_CONSONANT,
                        Consonants.BILABIAL_STOP_VOICED,
                        Consonants.LABIODENTAL_STOP_VOICELESS,
                        Consonants.LABIODENTAL_STOP_VOICED,
                        Consonants.LINGUOLABIAL_STOP_VOICELESS,
                        Consonants.LINGUOLABIAL_STOP_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.ALVEOLAR_STOP_VOICELESS,
                        Consonants.ALVEOLAR_STOP_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.RETROFLEX_STOP_VOICELESS,
                        Consonants.RETROFLEX_STOP_VOICED,
                        Consonants.PALATAL_STOP_VOICELESS,
                        Consonants.PALATAL_STOP_VOICED,
                        Consonants.VELAR_STOP_VOICELESS,
                        Consonants.VELAR_STOP_VOICED,
                        Consonants.UVULAR_STOP_VOICELESS,
                        Consonants.UVULAR_STOP_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.GLOTTAL_STOP_VOICELESS,
                        Consonants.NULL_CONSONANT
                ),
                new ConsonantRow(
                        (StringProperty) new SimpleStringProperty("S_FRICATIVE"),
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.ALVEOLAR_S_FRICATIVE_VOICELESS,
                        Consonants.ALVEOLAR_S_FRICATIVE_VOICED,
                        Consonants.POSTALVEOLAR_S_FRICATIVE_VOICELESS,
                        Consonants.POSTALVEOLAR_S_FRICATIVE_VOICED,
                        Consonants.RETROFLEX_S_FRICATIVE_VOICELESS,
                        Consonants.RETROFLEX_S_FRICATIVE_VOICED,
                        Consonants.PALATAL_S_FRICATIVE_VOICELESS,
                        Consonants.PALATAL_S_FRICATIVE_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT
                ),
                new ConsonantRow(
                        (StringProperty) new SimpleStringProperty("NS_FRICATIVE"),
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.LINGUOLABIAL_NS_FRICATIVE_VOICELESS,
                        Consonants.LINGUOLABIAL_NS_FRICATIVE_VOICED,
                        Consonants.DENTAL_NS_FRICATIVE_VOICELESS,
                        Consonants.DENTAL_NS_FRICATIVE_VOICED,
                        Consonants.ALVEOLAR_NS_FRICATIVE_VOICELESS,
                        Consonants.ALVEOLAR_NS_FRICATIVE_VOICED,
                        Consonants.POSTALVEOLAR_NS_FRICATIVE_VOICELESS,
                        Consonants.POSTALVEOLAR_NS_FRICATIVE_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.RETROFLEX_NS_FRICATIVE_VOICED,
                        Consonants.PALATAL_NS_FRICATIVE_VOICELESS,
                        Consonants.PALATAL_NS_FRICATIVE_VOICED,
                        Consonants.VELAR_NS_FRICATIVE_VOICELESS,
                        Consonants.VELAR_NS_FRICATIVE_VOICED,
                        Consonants.UVULAR_NS_FRICATIVE_VOICELESS,
                        Consonants.UVULAR_NS_FRICATIVE_VOICED,
                        Consonants.EPIGLOTTAL_NS_FRICATIVE_VOICELESS,
                        Consonants.NULL_CONSONANT,
                        Consonants.GLOTTAL_NS_FRICATIVE_VOICELESS,
                        Consonants.GLOTTAL_NS_FRICATIVE_VOICED
                ),
                new ConsonantRow(
                        (StringProperty) new SimpleStringProperty("APPROXIMANT"),
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.LABIODENTAL_APPROXIMANT_VOICELESS,
                        Consonants.LABIODENTAL_APPROXIMANT_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.ALVEOLAR_APPROXIMANT_VOICELESS,
                        Consonants.ALVEOLAR_APPROXIMANT_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.RETROFLEX_APPROXIMANT_VOICELESS,
                        Consonants.RETROFLEX_APPROXIMANT_VOICED,
                        Consonants.PALATAL_APPROXIMANT_VOICELESS,
                        Consonants.PALATAL_APPROXIMANT_VOICED,
                        Consonants.VELAR_APPROXIMANT_VOICELESS,
                        Consonants.VELAR_APPROXIMANT_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.GLOTTAL_APPROXIMANT_VOICED
                ),
                new ConsonantRow(
                        (StringProperty) new SimpleStringProperty("FLAP"),
                        Consonants.NULL_CONSONANT,
                        Consonants.BILABIAL_FLAP_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.LABIODENTAL_FLAP_VOICED,
                        Consonants.LINGUOLABIAL_FLAP_VOICELESS,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.ALVEOLAR_FLAP_VOICELESS,
                        Consonants.ALVEOLAR_FLAP_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.RETROFLEX_FLAP_VOICELESS,
                        Consonants.RETROFLEX_FLAP_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.EPIGLOTTAL_FLAP_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT
                ),
                new ConsonantRow(
                        (StringProperty) new SimpleStringProperty("TRILL"),
                        Consonants.NULL_CONSONANT,
                        Consonants.BILABIAL_TRILL_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.ALVEOLAR_TRILL_VOICELESS,
                        Consonants.ALVEOLAR_TRILL_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.RETROFLEX_TRILL_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.UVULAR_TRILL_VOICELESS,
                        Consonants.UVULAR_TRILL_VOICED,
                        Consonants.EPIGLOTTAL_TRILL_VOICELESS,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT
                ),
                new ConsonantRow(
                        (StringProperty) new SimpleStringProperty("LFRIC"),
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.ALVEOLAR_LFRIC_VOICELESS,
                        Consonants.ALVEOLAR_LFRIC_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.RETROFLEX_LFRIC_VOICELESS,
                        Consonants.RETROFLEX_LFRIC_VOICED,
                        Consonants.PALATAL_LFRIC_VOICELESS,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT
                ),
                new ConsonantRow(
                        (StringProperty) new SimpleStringProperty("LAPP"),
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.ALVEOLAR_LAPP_VOICELESS,
                        Consonants.ALVEOLAR_LAPP_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.RETROFLEX_LAPP_VOICELESS,
                        Consonants.RETROFLEX_LAPP_VOICED,
                        Consonants.PALATAL_LAPP_VOICELESS,
                        Consonants.PALATAL_LAPP_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.VELAR_LAPP_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.UVULAR_LAPP_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT
                ),
                new ConsonantRow(
                        (StringProperty) new SimpleStringProperty("LFLAP"),
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.ALVEOLAR_LFLAP_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.RETROFLEX_LFLAP_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.PALATAL_LFLAP_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.VELAR_LFLAP_VOICED,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT,
                        Consonants.NULL_CONSONANT
                )


                // TODO: add Vowels Table

                // Vowels Table
        );

        consonantsTable.setItems(consonantTableData);

    }

}

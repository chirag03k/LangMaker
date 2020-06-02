package com.chiragkawediya.langmaker.main;

import com.chiragkawediya.langmaker.langcomponents.Language;
import com.chiragkawediya.langmaker.langcomponents.alphabet.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;

public class FileHandler {

    public static Language openLanguageFile(String filepath) throws FileNotFoundException {
        File langFile = new File(filepath);

        Language resultLang = new Language();

        if(!langFile.exists()) {
            throw new FileNotFoundException();
        }

        try {
            // Open the file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document langDoc = dBuilder.parse(langFile);
            langDoc.getDocumentElement().normalize();

            // Alphabet
            Alphabet alphabet = readAlphabet(langDoc);
            resultLang.addAlphabet(alphabet);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultLang;
    }

    private static Alphabet readAlphabet(Document langDoc) {
        Alphabet alphabet = new Alphabet();

        // Goes to the Phonology section
        NodeList phonologyNodeList = langDoc.getElementsByTagName("Phonology");

        for (int i = 0; i < phonologyNodeList.getLength(); i++) {

            // Iterates through individual phonemes
            Node phonemeNode = phonologyNodeList.item(i);

            // Finds the phoneme data
            String type = ((Element) phonemeNode).getElementsByTagName("type").item(0).getTextContent();
            String ipaData = ((Element)phonemeNode).getElementsByTagName("ipa data").item(0).getTextContent();
            String romanization = ((Element)phonemeNode).getElementsByTagName("romanization").item(0).getTextContent();
            String notes = ((Element)phonemeNode).getElementsByTagName("noes").item(0).getTextContent();

            // adds to the alphabet
            Phoneme phoneme = new Phoneme(ipaData, romanization, type);
            phoneme.setNotes(notes);
            alphabet.addPhoneme(phoneme);
        }

        return alphabet;
    }

    public static void writeOut(Language language, String fileName) {
        try {
            // Create a file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document langDoc = dBuilder.newDocument();

            Element rootLanguage = langDoc.createElement("Language");

            Element phonologyElement = langDoc.createElement("Phonology");
            rootLanguage.appendChild(phonologyElement);

            // Write out individual phonemes
            for(Phoneme phoneme: language.alphabet.getPhonemeList()) {
                Element phonemeElement = langDoc.createElement("Phoneme");
                phonemeElement.appendChild(phonemeElement);

                Element phonemeTypeElement = langDoc.createElement("type");
                phonemeTypeElement.setTextContent(phoneme.type);

                Element phonemeIPAData = langDoc.createElement("ipa data");
                StringBuilder ipaDataString = new StringBuilder("");
                for(Phone phone: phoneme.construction) {
                    if(phone instanceof Vowels) {
                        ipaDataString.append(" ").append(((Vowels)phone).name());
                    }
                    if(phone instanceof Consonants) {
                        ipaDataString.append(" ").append(((Consonants)phone).name());
                    }
                }
                phonemeIPAData.setTextContent(ipaDataString.toString());

                Element phonemeRomanizationElement = langDoc.createElement("romanization");
                phonemeRomanizationElement.setTextContent(phoneme.romanization);

                phonemeElement.appendChild(phonemeTypeElement);
                phonemeElement.appendChild(phonemeIPAData);
                phonemeElement.appendChild(phonemeRomanizationElement);

            }


            // Write out the file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(langDoc);
            StreamResult streamResult = new StreamResult(new File(fileName));

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}

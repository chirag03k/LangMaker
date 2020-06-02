package com.chiragkawediya.langmaker.langcomponents.alphabet;

import javax.imageio.stream.FileImageInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Phoneme {

    public List<Phone> construction;
    public String romanization;
    public String type; // vowel, consonant, etc.
    public String notes = "";

    FileInputStream pronunciation;
    FileImageInputStream symbol;

    public Phoneme(List<Phone> construction, String symbol, String type) {
        this.construction = construction;
        this.romanization = symbol;
        this.type = type;
    }

    public Phoneme(String phoneList, String romanization, String type) {
        List<Phone> construction = new ArrayList<>();
        String[] phones = phoneList.split(" ");
        for (String s : phones) {
            Phone c;
            try {
                c = Consonants.valueOf(s);
                construction.add(c);
            } catch (IllegalArgumentException e) {
                try {
                    c = Vowels.valueOf(s);
                    construction.add(c);
                } catch (IllegalArgumentException ex) {
                    System.out.println(s + " is not a supported type of Vowel or Consonant Sound for the letter R");
                    e.printStackTrace();
                    ex.printStackTrace();
                }
            }
        }
        this.construction = construction;
        this.romanization = romanization;
        this.type = type;
    }

    // TODO: these exist
    public void addPronunciationRecording(String filepath) {
        try {
            pronunciation = new FileInputStream(new File(filepath));
        } catch (IOException e) {
            System.out.println("Cannot find recording at " + filepath);
        }
    }

    public void addSymbol(String filepath) {
        try {
            symbol = new FileImageInputStream(new File(filepath));
        } catch (IOException e) {
            System.out.println("Cannot find image at " + filepath);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("/").append(romanization).append("/");
        result.append(" [");
        for(Phone s: construction) {
            result.append(" ").append(s.getSymbol());
        }
        result.append("]");
        result.append(" ").append("(").append(type).append(")");
        return result.toString();
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}

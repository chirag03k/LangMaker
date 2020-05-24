package com.langconstructor.langcomponents.alphabet;

import javax.imageio.stream.FileImageInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class Phoneme {

    List<Phone> construction;
    String romanization;
    String type; // vowel, consonant, etc.

    FileInputStream pronunciation;
    FileImageInputStream symbol;

    Phoneme(List<Phone> construction, String symbol, String type) {
        this.construction = construction;
        this.romanization = symbol;
        this.type = type;
    }

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
        StringBuilder result = new StringBuilder(romanization);
        for(Phone s: construction) {
            result.append(" ").append(s.getSymbol());
        }
        return result.toString();
    }


}

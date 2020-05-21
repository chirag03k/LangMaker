package com.langconstructor.langcomponents.alphabet;

import javax.imageio.stream.FileImageInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class Phoneme {

    List<Phone> construction;
    String romanization;

    FileInputStream pronunciation;
    FileImageInputStream symbol;

    Phoneme(List<Phone> construction, String symbol) {
        this.construction = construction;
        this.romanization = symbol;
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

}

package com.chiragkawediya.langmaker.langcomponents;

import com.chiragkawediya.langmaker.langcomponents.alphabet.Alphabet;

public class Language {

    public Alphabet alphabet;

    public void initializeNew() {
        createAlphabet();
    }

    public void createAlphabet() {
        alphabet = new Alphabet();
    }

    public void addAlphabet(Alphabet a) {
        alphabet = a;
    }
}

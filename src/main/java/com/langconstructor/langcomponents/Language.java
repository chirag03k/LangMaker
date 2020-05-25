package com.langconstructor.langcomponents;

import com.langconstructor.langcomponents.alphabet.Alphabet;

public class Language {

    public Alphabet alphabet;

    public Language() {
        createAlphabet();
    }

    public void createAlphabet() {
        alphabet = new Alphabet();
    }

}

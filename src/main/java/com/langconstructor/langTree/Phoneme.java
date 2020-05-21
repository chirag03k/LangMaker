package com.langconstructor.langTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Phoneme {

    public static Collection<Phoneme> allPhonemes = new ArrayList<Phoneme>();

    private String value;
    private String romanization;

    public Phoneme(String val, String rom) {
        value = val;
        romanization = rom;
    }

    public void push() {
        allPhonemes.add(this);
    }
    public String getValue() {
        return value;
    }
    public String getRomanization() {
        return romanization;
    }

}

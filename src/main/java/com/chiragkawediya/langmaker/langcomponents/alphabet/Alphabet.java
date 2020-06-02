package com.chiragkawediya.langmaker.langcomponents.alphabet;

import java.util.ArrayList;
import java.util.List;

public class Alphabet {

    List<Phoneme> fullAlphabet;

    List<Phoneme> vowels;
    List<Phoneme> consonants;

    public Alphabet() {
        fullAlphabet = new ArrayList<Phoneme>();

    }

    public void addPhoneme(List<Phone> phoneList, String romanizedSymbol, String type) {

        Phoneme p = new Phoneme(phoneList, romanizedSymbol, type);
        fullAlphabet.add(p);
    }

    public void addPhoneme(String phoneList, String romanizedSymbol, String type) {


    }

    public void addPhoneme(Phoneme phoneme) {
        fullAlphabet.add(phoneme);
    }

    public List<Phoneme> getPhonemeList() {
        return fullAlphabet;
    }

    public boolean removePhoneme(Phoneme phoneme) {
        return fullAlphabet.remove(phoneme);
    }

    public static Alphabet generateRandomAlphabet() {
        // TODO: create method to generate alphabet once you understand better what phonemes can go together and what phoneme pairs cause problems

        return null;
    }
}

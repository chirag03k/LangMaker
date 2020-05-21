package com.langconstructor.langcomponents.alphabet;

import java.util.Collections;
import java.util.List;

public class Alphabet {

    List<Phoneme> fullAlphabet;

    boolean split;

    List<Phoneme> vowels;
    List<Phoneme> consonants;

    Alphabet(boolean splitVowelsAndConsonants) {
        split = splitVowelsAndConsonants;
    }

    public void addVowel(Vowels vowel, String romanizedSymbol) {
        if (split) {
            Phoneme p = new Phoneme(Collections.singletonList((Phone) vowel), romanizedSymbol);
            vowels.add(p);
        } else {
            System.out.println("This alphabet does not have specific vowels or consonants");
        }
    }

    public void addConsonant(Consonants consonant, String romanizedSymbol) {
        if (split) {
            Phoneme p = new Phoneme(Collections.singletonList((Phone) consonant), romanizedSymbol);
            vowels.add(p);
        } else {
            System.out.println("This alphabet does not have specific vowels or consonants");
        }
    }

    public void addGenericPhoneme(List<Phone> phoneList, String romanizedSymbol) {
        if(!split) {
            Phoneme p = new Phoneme(phoneList, romanizedSymbol);
            fullAlphabet.add(p);
        } else {
            System.out.println("This alphabet specifically distinguishes between vowels and consonants.");
        }
    }

    public static Alphabet generateRandomAlphabet() {
        // TODO: create method to generate alphabet once you understand better what phonemes can go together and what phoneme pairs cause problems

        return null;
    }
}

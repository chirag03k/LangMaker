package com.langconstructor.langTree;

import java.util.ArrayList;
import java.util.Collection;

public class Morpheme {

    public static Collection<Morpheme> allMorphemes = new ArrayList<Morpheme>();

    public enum MorphemeType {
        SUFFIX, PREFIX, FREE;
        // TODO: add support for infixes later
    }

    private Phoneme[] morpheme;
    private String englishMeaning;
    public MorphemeType type;
    public String string;

    public Morpheme(Phoneme[] morph, String meaning, MorphemeType t ) throws Exception {
        for(Phoneme p: morph) {
            if (!Phoneme.allPhonemes.contains(p)) {
                throw new Exception("Phoneme \'" + p.getRomanization() + "\' does not exist in this language");
            }
        }
        morpheme = morph;
        englishMeaning = meaning;
        type = t;
        allMorphemes.add(this);
        string = convert(morph);
    }

    public Morpheme(String m, String meaning, MorphemeType t) {

    }

    public String getPhoneme() {
        StringBuilder result = new StringBuilder();
        for(Phoneme p: morpheme) {
            result.append(p.getRomanization());
        }
        return result.toString();
    }

    private String convert(Phoneme[] m) {
        String r = "";
        for(Phoneme p: m) {
            r += p;
        }
        return r;
    }

    String define() {
        return englishMeaning;
    }

}

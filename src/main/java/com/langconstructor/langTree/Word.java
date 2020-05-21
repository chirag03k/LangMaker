package com.langconstructor.langTree;

public class Word {

    Morpheme[] morphemes;
    String definition;
    SpeechNode type;
    public String string;

    Word(Morpheme[] morphs, SpeechNode t) {
        morphemes = morphs;
        for(Morpheme morph:morphemes) {
            definition = definition +  morph.define() + " ";
            string += morph.string;
        }
        type = t;
        type.words.add(this);

    }

    public void setDefinition(String d) {
        definition = d;
    }

}

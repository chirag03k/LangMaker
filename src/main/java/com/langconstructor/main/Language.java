package com.langconstructor.main;

import com.langconstructor.langTree.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Language {

    String name;
    String description;
    List<SpeechNode> grammarTree;
    List<Phoneme> phonemes;
    List<Word> lexicon;

    void newLexClass(SpeechNode parentNode, SpeechNode child) {
        parentNode.addChildNode(child);
        grammarTree.add(child);
    }

    List<String> generateWordList() {
        List<String> result = new ArrayList<String>();
        for (Word word : lexicon) {
            result.add(word.string);
        }
        return result;
    }

}

package com.chiragkawediya.langmaker.main;

import com.chiragkawediya.langmaker.langTree.Phoneme;
import com.chiragkawediya.langmaker.langTree.SpeechNode;
import com.chiragkawediya.langmaker.langTree.Word;

import java.util.ArrayList;
import java.util.List;

@Deprecated
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

    public void export() {

    }
}

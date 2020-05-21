package com.langconstructor.langTree;

import java.util.ArrayList;
import java.util.List;

public class SpeechNode {

    public boolean exclude;
    public boolean optional;
    String description;
    List<SpeechNode> children = new ArrayList<SpeechNode>();
    String name;

    public void addChildNode(SpeechNode s) { children.add(s); }

    ArrayList<Word> words;

    public void addWord(Word w) { words.add(w); }

}

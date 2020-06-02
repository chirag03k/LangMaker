package com.chiragkawediya.langmaker.main;

import java.io.FileNotFoundException;

public class LangMain {

    // Just here because for some reason JavaFX does not like it when the main method is in the same class as the application
    // It also gets mad when I simply call LangApplication.launch(args) from here

    /**
     *
     * @param args Command Line Arguments.
     *             first argument is the filepath
     */
    public static void main(String[] args) throws FileNotFoundException {
        LangApplication.main(args);
    }

}

package com.langconstructor.langcomponents.alphabet;

public enum Vowels implements Phone {

    // TODO: add long/short vowel distinction

    //              Front                         Central                             Back

    // Close
                    CLOSE_FRONT_UNROUNDED("i"), CLOSE_CENTRAL_UNROUNDED("ɨ"),   CLOSE_BACK_UNROUNDED("ɯ"),
                    CLOSE_FRONT_ROUNDED("y"),   CLOSE_CENTRAL_ROUNDED("ʉ"),     CLOSE_BACK_ROUNDED("u"),
    // Near Close
                    NC_FRONT_UNROUNDED("ɪ"),
                    NC_FRONT_ROUNDED("ʏ"),                                         NC_BACK_ROUNDED("ʊ"),

    // Close-mid
                    CMID_FRONT_UNROUNDED("e"),  CMID_CENTRAL_UNROUNDED("ɘ"),    CMID_BACK_UNROUNDED("ɤ"),
                    CMID_FRONT_ROUNDED("ø"),    CMID_CENTRAL_ROUNDED("ɵ"),      CMID_BACK_ROUNDED("o"),

    // Mid
                                                   MID_CENTRAL_UNROUNDED("ə"),
                    MID_FRONT_ROUNDED("ø̞"),     MID_CENTRAL_ROUNDED("ə"),       MID_BACK_ROUNDED("o̞"),

    // Open-Mid
                    OMID_FRONT_UNROUNDED("ɛ"),  OMID_CENTRAL_UNROUNDED("ɜ"),     OMID_BACK_UNROUNDED("ʌ"),
                    OMID_FRONT_ROUNDED("œ"),    OMID_CENTRAL_ROUNDED("ɞ"),      OMID_BACK_ROUNDED("ɔ"),

    // Near-open
                    NO_FRONT_UNROUNDED("æ"),    NO_CENTRAL_UNROUNDED("ɐ"),
                                                   NO_CENTRAL_ROUNDED("ɐ"),

    // Open
                    OPEN_FRONT_UNROUNDED("a"),  OPEN_CENTRAL_UNROUNDED("ä"),     OPEN_BACK_UNROUNDED("ɑ"),
                    OPEN_FRONT_ROUNDED("ɶ"),                                        OPEN_BACK_ROUNDED("ɒ");

    String symbol;

    Vowels(String s) {
        this.symbol = s;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }



}

package com.company;

public enum ProjectType {
    EASY,
    MEDIUM,
    HARD;

    @Override
    public String toString(){
        switch(this) {
            case EASY:
                return "łatwy";
            case MEDIUM:
                return "średni";
            case HARD:
                return "złożony";
            default: return "undefined";
        }
    }
}

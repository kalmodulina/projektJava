package com.company;

public enum ContractorType {
    CHEAP,
    NORMAL,
    EXPENSIVE;

    @Override
    public String toString(){
        switch(this) {
            case CHEAP:
                return "najlepszy uczeń";
            case NORMAL:
                return "średni uczeń";
            case EXPENSIVE:
                return "koleś";
            default: return "undefined";
        }
    }
}

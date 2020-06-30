package com.company;

public enum EmployeeType {
    PROGRAMMER,
    TESTER,
    SELLER;

    @Override
    public String toString(){
        switch(this) {
            case PROGRAMMER:
                return "programista";
            case TESTER:
                return "tester";
            case SELLER:
                return "sprzedawca";
            default: return "undefined";
        }
    }
}

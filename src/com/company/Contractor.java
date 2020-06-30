package com.company;

import java.util.ArrayList;

public class Contractor {
        private String name;
        private ContractorType type;
        public ArrayList<Technology> technologies = new ArrayList<Technology>();

        public Contractor(String name, ContractorType type) {
            this.name = name;
            this.type = type;
        }

    @Override
    public String toString() {
        return "Nazwa podwykonawcy: " + this.name +
                "\nTyp podwykonawcy: " + this.type +
                "\nZestaw technologii jakie zna: " + this.technologies +
                "\n-------------------------\n";
    }
}

package com.company;

import java.util.ArrayList;
import java.util.List;

public class Contractor {
        private String name;
        private ContractorType type;
        private ArrayList<Technology> technologies = new ArrayList<Technology>();

        public Contractor(String name, ContractorType type) {
            this.name = name;
            this.type = type;
        }
}

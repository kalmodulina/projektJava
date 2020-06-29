package com.company;

import java.util.ArrayList;
import java.util.List;

public class Contractor {
        private String name;
        private ContractorType type;
        private List<Technology> technologies = new ArrayList<Technology>();

        public Contractor(String name, ContractorType type) {
            this.name = name;
            this.type = type;
        }
}

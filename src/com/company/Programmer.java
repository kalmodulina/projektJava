package com.company;

import java.util.ArrayList;
import java.util.List;

public abstract class Programmer extends Employee {

    private Level accuracy;
    private Level punctuality;
    private List<Technology> technologies = new ArrayList<Technology>();

    public Programmer(String firstName, String lastName, Double payment, Level accuracy, Level punctuality) {
        super(firstName, lastName, payment);
        this.accuracy = accuracy;
        this.punctuality = punctuality;
    }
}

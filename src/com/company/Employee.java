package com.company;

import java.util.ArrayList;

public class Employee {
    private String name;
    private Double payment;
    private EmployeeType type;
    public ArrayList<Technology> technologies = new ArrayList<Technology>();

    public Employee(String name, Double payment, EmployeeType type) {
        this.name = name;
        this.payment = payment;
        this.type = type;
    }

    public Boolean isTester() {
        if(this.type == EmployeeType.TESTER) {
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean isProgrammer() {
        if(this.type == EmployeeType.PROGRAMMER) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        if(this.type == EmployeeType.PROGRAMMER) {
            return "Nazwa pracownika: " + this.name +
                    "\nRodzaj pracownika: " + this.type +
                    "\nWynagrodzenie: " + this.payment +
                    "\nZestaw technologii jakie zna: " + this.technologies +
                    "\n-------------------------\n";
        }
        else {
            return "Nazwa pracownika: " + this.name +
                    "\nRodzaj pracownika: " + this.type +
                    "\nWynagrodzenie: " + this.payment +
                    "\n-------------------------\n";
        }
    }
}

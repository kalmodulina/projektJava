package com.company;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private Double budget;
    static final Double DEFAULT_BUDGET = 10000.0;
    private List<Employee> employees = new ArrayList<Employee>();

    public Company() {
        budget = DEFAULT_BUDGET;
    }

    public Double getBudget() {
        return budget;
    }

    public ArrayList<Employee> getEmployees() {
        return (ArrayList<Employee>) employees;
    }
}

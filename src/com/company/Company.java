package com.company;
import java.util.ArrayList;
import java.util.Arrays;

public class Company {
    private Double budget;
    static final Double DEFAULT_BUDGET = 10000.0;
    static final Double EMPLOYMENT_COST = 5000.0;
    static final Double EMPLOYEE_MAINTENANCE_COST = 1000.0;
    static final Double DISMISSAL_COST = 2000.0;
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private ArrayList<Technology> ownerTechnologies = new ArrayList<Technology>(Arrays.asList(Technology.BACKEND,
            Technology.DATABASE, Technology.FRONT_END, Technology.WORDPRESS, Technology.PRESTASHOP));
    public ArrayList<Project> activeProjects = new ArrayList<Project>();
    public ArrayList<Project> completedProjects = new ArrayList<Project>();

    public Company() {
        budget = DEFAULT_BUDGET;
    }

    public Double getBudget() {
        return budget;
    }

    public ArrayList<Employee> getEmployees() {
        return (ArrayList<Employee>) employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void dismissEmployee(Employee employee) {
        employees.remove(employee);
        this.budget = this.budget - DISMISSAL_COST;
    }

    public ArrayList<Technology> getOwnerTechnologies() {
        return (ArrayList<Technology>) ownerTechnologies;
    }
}

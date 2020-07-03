package com.company;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Company {
    private Double budget;
    static final Double DEFAULT_BUDGET = 10000.0;
    static final Double EMPLOYMENT_COST = 4000.0;
    static final Double EMPLOYEE_MAINTENANCE_COST = 1000.0;
    static final Double DISMISSAL_COST = 2000.0;
    static final Double JOB_ADVERTISEMENT_COST = 400.0;
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

    public void addJobAdvertisement() {
        this.budget = this.budget - JOB_ADVERTISEMENT_COST;
        System.out.println("Dodałeś nowe ogłoszenie o pracę, liczba dostępnych pracowników powinna wzrosnąć.");
    }

    public void hireEmployee(Employee employee) {
        employees.add(employee);
        this.budget = this.budget - EMPLOYMENT_COST;
    }

    public void dismissEmployee(Employee employee) {
        employees.remove(employee);
        this.budget = this.budget - DISMISSAL_COST;
    }

    public void completedProject(Project project) {
        if(project.isWorking() || project.getClient().getClientType() == ClientType.EASY) {
            this.budget = this.budget + project.getProjectPrice();
            completedProjects.remove(project);
            System.out.println("Brawo, udało Ci się oddać projekt dla klienta.");
        }
        else {
            if(project.getClient().getClientType() == ClientType.MEDIUM) {
                if(new Random().nextBoolean()) {
                    this.budget = this.budget + project.getProjectPrice();
                    completedProjects.remove(project);
                    System.out.println("Brawo, udało Ci się oddać projekt dla klienta.");
                }
                else {
                    completedProjects.remove(project);
                    System.out.println("Oddałeś niedziałający projekt, utraciłeś kontrakt bez zwrotu kosztów.");
                }
            }
            else {
                completedProjects.remove(project);
                System.out.println("Oddałeś niedziałający projekt, utraciłeś kontrakt bez zwrotu kosztów.");
            }
        }
    }

    public void testingProject(Project project) {
        int testerCount = 0;
        int programmerCount = 1;
        for (Employee employee : this.employees) {
            if(employee.isTester()) {
                testerCount++;
            }
            if(employee.isProgrammer()) {
                programmerCount++;
            }
        }
        if(testerCount > 0 && ((double)programmerCount)/3.0 <= (double)testerCount) {
            project.setIsWorking(true);
            System.out.println("Przeznaczono dzień na testowanie.");
        }
        else {
            System.out.println("Nie masz wystarczającej ilości testerów, aby zagwarantować, że nie oddasz klientowi nie działającego projektu");
        }

    }

    public ArrayList<Technology> getOwnerTechnologies() {
        return (ArrayList<Technology>) ownerTechnologies;
    }
}

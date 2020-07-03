package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Project {
    private String name;
    private Client client;
    private Integer daysToDeadline;
    private Double penalty;
    private Double price;
    private Integer daysToPayment;
    private ProjectType type;
    public ArrayList<Map.Entry<Technology, Integer>> technologiesWithDays = new ArrayList<Map.Entry<Technology, Integer>>();

    public Project(String name, Client client, Integer daysToDeadline, Double penalty, Double price, Integer daysToPayment, ProjectType type) {
        this.name = name;
        this.client = client;
        this.daysToDeadline = daysToDeadline;
        this.penalty = penalty;
        this.price = price;
        this.daysToPayment = daysToPayment;
        this.type = type;
    }

    public String getProjectName() {
        return name;
    }

    public Double getProjectPrice() {
        return price;
    }

    public ProjectType getProjectType() {
        return type;
    }

    public void programming(Map.Entry<Technology, Integer> technologyWithDays) {
        if(technologyWithDays.getKey() == Technology.DATABASE) {
            Integer days = technologyWithDays.getValue() - 1;
            technologiesWithDays.get(technologiesWithDays.indexOf(technologyWithDays)).setValue(days);
            if(technologiesWithDays.get(technologiesWithDays.indexOf(technologyWithDays)).getValue() == 0) {
                technologiesWithDays.remove(technologyWithDays);
            }
            System.out.println("Przeznaczono dzień na programowanie " + Technology.DATABASE);
        }
        if(technologyWithDays.getKey() == Technology.FRONT_END) {
            Integer days = technologyWithDays.getValue() - 1;
            technologiesWithDays.get(technologiesWithDays.indexOf(technologyWithDays)).setValue(days);
            if(technologiesWithDays.get(technologiesWithDays.indexOf(technologyWithDays)).getValue() == 0) {
                technologiesWithDays.remove(technologyWithDays);
            }
            System.out.println("Przeznaczono dzień na programowanie " + Technology.FRONT_END);
        }
        if(technologyWithDays.getKey() == Technology.BACKEND) {
            Integer days = technologyWithDays.getValue() - 1;
            technologiesWithDays.get(technologiesWithDays.indexOf(technologyWithDays)).setValue(days);
            if(technologiesWithDays.get(technologiesWithDays.indexOf(technologyWithDays)).getValue() == 0) {
                technologiesWithDays.remove(technologyWithDays);
            }
            System.out.println("Przeznaczono dzień na programowanie " + Technology.BACKEND);
        }
        if(technologyWithDays.getKey() == Technology.MOBILE) {
            Integer days = technologyWithDays.getValue() - 1;
            technologiesWithDays.get(technologiesWithDays.indexOf(technologyWithDays)).setValue(days);
            if(technologiesWithDays.get(technologiesWithDays.indexOf(technologyWithDays)).getValue() == 0) {
                technologiesWithDays.remove(technologyWithDays);
            }
            System.out.println("Przeznaczono dzień na programowanie " + Technology.MOBILE);
        }
        if(technologyWithDays.getKey() == Technology.WORDPRESS) {
            Integer days = technologyWithDays.getValue() - 1;
            technologiesWithDays.get(technologiesWithDays.indexOf(technologyWithDays)).setValue(days);
            if(technologiesWithDays.get(technologiesWithDays.indexOf(technologyWithDays)).getValue() == 0) {
                technologiesWithDays.remove(technologyWithDays);
            }
            System.out.println("Przeznaczono dzień na programowanie " + Technology.WORDPRESS);
        }
        if(technologyWithDays.getKey() == Technology.PRESTASHOP) {
            Integer days = technologyWithDays.getValue() - 1;
            technologiesWithDays.get(technologiesWithDays.indexOf(technologyWithDays)).setValue(days);
            if(technologiesWithDays.get(technologiesWithDays.indexOf(technologyWithDays)).getValue() == 0) {
                technologiesWithDays.remove(technologyWithDays);
            }
            System.out.println("Przeznaczono dzień na programowanie " + Technology.PRESTASHOP);
        }
    }

    @Override
    public String toString() {
        return "Nazwa projektu: " + this.name +
                "\nKlient: " + this.client.getName() +
                "\nIlość dni na wykonanie projektu: " + this.daysToDeadline +
                "\nWysokość kary za przekroczenie terminu: " + this.penalty +
                "\nCena za wykonanie projektu: " + this.price +
                "\nIlość dni na wypłacenie zapłaty po oddaniu projektu: " + this.daysToPayment +
                "\nPoziom złożoności projektu: " + this.type +
                "\nTechnologie wraz z przypisanymi do nich dniami potrzebnymi do zrealizowania: " + this.technologiesWithDays +
                "\n-------------------------\n";
    }
}

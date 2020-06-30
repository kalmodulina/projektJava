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

    public ProjectType getProjectType() {
        return type;
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

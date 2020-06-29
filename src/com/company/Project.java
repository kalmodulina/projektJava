package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Project {
    private String name;
    private Client client;
    private List<Map.Entry<Technology, Integer>> technologiesWithDays = new ArrayList<Map.Entry<Technology, Integer>>();
    private Integer daysToDeadline;
    private Double penalty;
    private Double price;
    private Integer daysToPayment;
    private ProjectType type;

    public Project(String name, Client client, Integer daysToDeadline, Double penalty, Double price, Integer daysToPayment, ProjectType type) {
        this.name = name;
        this.client = client;
        this.daysToDeadline = daysToDeadline;
        this.penalty = penalty;
        this.price = price;
        this.daysToPayment = daysToPayment;
        this.type = type;
    }
}

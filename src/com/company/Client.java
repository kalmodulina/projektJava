package com.company;

public class Client {
    private String name;
    private ClientType type;

    public Client(String name, ClientType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public ClientType getClientType() {
        return type;
    }

    public String toString() {
        return "Nazwa klienta: " + this.name;
    }
}

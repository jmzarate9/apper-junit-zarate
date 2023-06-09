package com.gcash;

public class Account {

    //Instance Variable
    private String id;
    private String name;
    private Double balance;

    //Constructor Parameter
    public Account(String id, String name, Double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    //Getter
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getBalance() {
        return balance;
    }

    //Setter
    public void setBalance(Double balance) {
        this.balance = balance;
    }

}

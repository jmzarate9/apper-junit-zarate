package com.gcash;

import java.util.Optional;

public class BalanceService {

    //instance variable
    private final AccountRepository repository;

    //Constructor Parameter
    public BalanceService(AccountRepository repository) {
        this.repository = repository;
    }

    public Double getBalance(String id) {
        // Account account = repository.getAccount(id);
        //throw an EXCEPTION HERE . "Account Not Found"
            // -- Create a class method
        return repository.getAccount(id).getBalance();
        // return account.getBalance();
    }

    public void debit(String id, Double balance) {
        //Subtract
        Account account = repository.getAccount(id);
        //throw an EXCEPTION HERE . "Account Not Found"
        if (account != null && account.getBalance() >= balance) {
            account.setBalance(account.getBalance() - balance);

            //throw an EXCEPTION HERE . "Insufficient Balance"
                // -- Create a class method
        }
    }

    public void credit(String id, Double balance) {
        //Add
        Account account = repository.getAccount(id);
        if (account != null) {
            account.setBalance(account.getBalance() + balance);
        }
    }

    public void transfer(String from, String to, Double balance) {
        //debit
        Account fromAccount = repository.getAccount(from);
        //credit
        Account toAccount = repository.getAccount(to);

        if (fromAccount != null && toAccount != null) {
            if (fromAccount.getBalance() >= balance) {
                fromAccount.setBalance(fromAccount.getBalance() - balance);
                toAccount.setBalance(toAccount.getBalance() + balance);
            }
        }

        // OTHER OPTION
            // debit(from, balance);
            // credit(to, balance);
    }
}
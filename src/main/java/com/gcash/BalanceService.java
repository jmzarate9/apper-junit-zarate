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
        return repository.getAccount(id).getBalance();

//        OTHER OPTION
//        Optional<Account> account = Optional.ofNullable(repository.getAccount(id));
//        return account.map(Account::getBalance).orElse(null);
    }

    public void debit(String id, Double balance) {
        //Subtract
        Account account = repository.getAccount(id);
        if (account != null && account.getBalance() >= balance) {
            account.setBalance(account.getBalance() - balance);
        }

//        OTHER OPTION
//        Optional<Account> account = Optional.ofNullable(repository.getAccount(id));
//        account.ifPresent(a -> a.setBalance(a.getBalance() - balance));
    }

    public void credit(String id, Double balance) {
        //Add
        Account account = repository.getAccount(id);
        if (account != null) {
            account.setBalance(account.getBalance() + balance);
        }

//        OTHER OPTION
//        Optional<Account> account = Optional.ofNullable(repository.getAccount(id));
//        account.ifPresent(a -> a.setBalance(a.getBalance() + balance));
    }

    public void transfer(String from, String to, Double balance) {
        Account fromAccount = repository.getAccount(from);
        Account toAccount = repository.getAccount(to);

        if (fromAccount != null && toAccount != null) {
            if (fromAccount.getBalance() >= balance) {
                fromAccount.setBalance(fromAccount.getBalance() - balance);
                toAccount.setBalance(toAccount.getBalance() + balance);
            }
        }
    }
}
package com.gcash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BalanceServiceTest {

    private AccountRepository repository = new AccountRepository();
    private BalanceService balanceService = new BalanceService(repository);

    @Test
    void testGetBalance() {
        // //Kick
        String accountId = repository.createAccount("John Doe", 10000.0);

        // Get the balance using the service
        Double balance = balanceService.getBalance(accountId);

        // Verify
        Assertions.assertEquals(10000.0, balance);
    }

    @Test
    void testDebit() {
        //Kick
        String accountId = repository.createAccount("John Doe", 10000.0);

        // Perform a debit of 2000.0
        balanceService.debit(accountId, 2000.0);

        // Get the updated balance
        Double balance = balanceService.getBalance(accountId);

        // Verify
        Assertions.assertEquals(8000.0, balance);
    }

    @Test
    void testCredit() {
        //Kick
        String accountId = repository.createAccount("John Doe", 10000.0);

        // Perform a credit of 5000.0
        balanceService.credit(accountId, 5000.0);

        // Get the updated balance
        Double balance = balanceService.getBalance(accountId);

        // Verify
        Assertions.assertEquals(15000.0, balance);
    }

    @Test
    void testTransfer() {
        //Kick
        String fromAccount = repository.createAccount("John Doe", 10000.0);
        String toAccount = repository.createAccount("Jane Smith", 5000.0);

        // Perform a transfer of 2000.0 from "fromAccount" to "toAccount"
        balanceService.transfer(fromAccount, toAccount, 2000.0);

        // Get the updated balances
        Double fromBalance = balanceService.getBalance(fromAccount);
        Double toBalance = balanceService.getBalance(toAccount);

        // Verify
        Assertions.assertEquals(8000.0, fromBalance);
        Assertions.assertEquals(7000.0, toBalance);
    }
}


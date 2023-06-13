package com.gcash;

import org.junit.jupiter.api.*;


public class BalanceServiceTest {

    //Instance Variable
    AccountRepository repository;
    BalanceService balanceService;

    @BeforeEach
    void setup() {
        System.out.println("Setting Up...");
        repository = new AccountRepository();
        balanceService = new BalanceService(repository);
    }

    /*@AfterEach
    void cleanup() {
        System.out.println("Cleaning Up...");
//        repository.deleteAllAccount;
    }*/

    @Test
//    @DisplayName("")
    void testGetBalance_ShouldReturnAccountBalance() {
        //Setup or given
            // given --> are the initial conditions, the input values
        String accountId = repository.createAccount("John Doe", 10000.0);

        // Kick or when
            // when --> where we invoke the method under test and usually store its result in a variable.
        // Get the balance using the service
        Double balance = balanceService.getBalance(accountId);

        // Verify or then
            // then --> we provide the assertions.
        Assertions.assertEquals(10000.0, balance);
    }

    /*void should_ThrowException() {
        // Setup

        //Kick
        Executable executable = () ->
        //verify
        assertThrows(ArithmeticException.class, executable);

    }
    */

    @Test
//    @DisplayName("")
    void testDebit_ShouldDebitAccount() {
        //Setup or given
        String accountId = repository.createAccount("John Doe", 10000.0);

        // Kick or when
            // Perform a debit of 2000.0
        balanceService.debit(accountId, 2000.0);
            // Get the updated balance
        Double balance = balanceService.getBalance(accountId);

        // Verify
        Assertions.assertEquals(8000.0, balance);
    }

    //testDebitInsufficientBalance()

    //testDebitAccountNotFound

    @Test
//    @DisplayName("")
    void testCredit_ShouldCreditAccount() {
        //Setup or given
        String accountId = repository.createAccount("John Doe", 10000.0);

        //Kick or when
            // Perform a credit of 5000.0
        balanceService.credit(accountId, 5000.0);
            // Get the updated balance
        Double balance = balanceService.getBalance(accountId);

        // Verify or then
        Assertions.assertEquals(15000.0, balance);
    }

    @Test
//    @DisplayName("")
    void testTransfer_ShouldTransferAmountBetweenAccounts() {
        //Setup or given
        String fromAccount = repository.createAccount("John Doe", 10000.0);
        String toAccount = repository.createAccount("Jane Smith", 5000.0);

        //Kick or when
            // Perform a transfer of 2000.0 from "fromAccount" to "toAccount"
        balanceService.transfer(fromAccount, toAccount, 2000.0);

            // Get the updated balances
        Double fromBalance = balanceService.getBalance(fromAccount);
        Double toBalance = balanceService.getBalance(toAccount);

        // Verify or then
        Assertions.assertEquals(8000.0, fromBalance);
        Assertions.assertEquals(7000.0, toBalance);
    }
}


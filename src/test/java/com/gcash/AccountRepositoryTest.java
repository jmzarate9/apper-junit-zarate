package com.gcash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccountRepositoryTest {

    @Test
//    @DisplayName("Creating an Account")
    void successfulAccountCreation() {
        //Setup
        AccountRepository repository = new AccountRepository();

        //Kick
        String accountId = repository.createAccount("josh", 89.9);

        //Verify
        //this assertions will verify if there is an account inside the accountRepository class and the size inside the class.
        Assertions.assertEquals(1, repository.getNumberOfAccounts(), "There must be one account registered");
        Assertions.assertEquals("josh", repository.getAccount(accountId).getName(), "The name must be 'josh'");
        Assertions.assertNotNull(accountId, "There must be an account saved in the database");
    }

    @Test
//    @DisplayName("")
    void successfulGetAccount() {
        //Setup
        AccountRepository repository = new AccountRepository();

        //Kick
        String accountId = repository.createAccount("josh", 89.9);

        //Verify
        Assertions.assertEquals("josh", repository.getAccount(accountId).getName());
        Assertions.assertEquals(89.9, repository.getAccount(accountId).getBalance());
        Assertions.assertEquals(null, repository.getAccount("randomId"));
    }


    @Test
//    @DisplayName("")
    void successfulDeletion() {
        //Setup
        AccountRepository repository  = new AccountRepository();
        String id = repository.createAccount("josh", 89.9);

        //Kick
        repository.deleteAccount(id);

        //Verify
        Assertions.assertEquals(0, repository.getNumberOfAccounts());
    }


    @Test
//    @DisplayName("")
    void successfulGetNumberOfAccounts() {
        //Setup
        AccountRepository repository = new AccountRepository();
        String id0 = repository.createAccount("josh", 89.9);
        String id1 = repository.createAccount("josh", 89.9);
        String id2 = repository.createAccount("josh", 89.9);
        String id3 = repository.createAccount("josh", 89.9);
        String id4 = repository.createAccount("josh", 89.9);
        String id5 = repository.createAccount("josh", 89.9);


        //Verify
        Assertions.assertEquals(6, repository.getNumberOfAccounts());

        //Setup
        repository.deleteAccount(id0);

        //Verify
        Assertions.assertEquals(5, repository.getNumberOfAccounts());
    }

    @Test
//    @DisplayName("")
    void testNoRegisteredAccount_ReturnsTrue_WhenNoAccountIsRegistered() {
        //Setup
        AccountRepository repository = new AccountRepository();

        //Verify
        Assertions.assertTrue(repository.noRegisteredAccount());
    }

    @Test
//    @DisplayName("")
    void testNoRegisteredAccount_ReturnsFalse_ForRegisteredAccount() {
        //Setup
        AccountRepository repository = new AccountRepository();
        String accountId = repository.createAccount("josh", 89.9);

        //Verify
        Assertions.assertFalse(repository.noRegisteredAccount());
    }

    //Test for getting all Account Names

}



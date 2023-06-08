package com.gcash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountRepositoryTest {

    @Test
    void successfulAccountCreation() {
        //Setup
        AccountRepository repository = new AccountRepository();

        //Kick
        String accountId = repository.createAccount("josh", 89.9);

        //Verify
        //this assertions will verify if there is an account inside the accountRepository class and the size inside the class.
        Assertions.assertEquals(1, repository.getNumberOfAccounts());
        Assertions.assertEquals("josh", repository.getAccount(accountId).name());
        Assertions.assertNotNull(accountId);
    }

    @Test
    void successfulGetAccount() {
        //Setup
        AccountRepository repository = new AccountRepository();

        //Kick
        String accountId = repository.createAccount("josh", 89.9);

        //Verify
        Assertions.assertEquals("josh", repository.getAccount(accountId).name());
        Assertions.assertEquals(89.9, repository.getAccount(accountId).balance());
        Assertions.assertEquals(null, repository.getAccount("randomId"));
    }


    @Test
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
    void successfulGettingRegisteredAccount() {
        //Setup
        AccountRepository repository = new AccountRepository();
        String accountId = repository.createAccount("josh", 89.9);

        //Kick
        repository.deleteAccount(accountId);

        //Verify
        Assertions.assertTrue(repository.noRegisteredAccount());
    }

}



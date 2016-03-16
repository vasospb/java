package ru.chigaev;

/**
 * Created by vaso on 08.03.2016.
 */
public class SavingAccount extends AbstractAccount {
    SavingAccount() {
        super();
        System.out.println("\tSaving account number " + accountIndex + " created.");
    }
}

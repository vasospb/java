package ru.chigaev;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vaso on 08.03.2016.
 */
public class Client {
    private String name;
    private List<Account> accounts;
    private Account activeAccount;
    private float initialOverdraft;

    static int cIndex = 0;

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    Client() {
        cIndex += 1;
        System.out.println("\nСlient number " + cIndex + " created");
        accounts = new ArrayList<Account>();

        accounts.add(new CheckingAccount());
        accounts.add(new SavingAccount());

    }

    Client(float initialOverdraft) {
        this();
        ( (CheckingAccount)accounts.get(0) ).setOverdraft(initialOverdraft);
    }

    void setActiveaccount(Account a) {

    }

    float getBallance() {
        return 0;
    }

    List<Account> getAccounts() {

        return accounts;
    }

    boolean deposit(float x) {
        return false;
    }

    boolean withdraw(float x) {
        return false;
    }

    Account createAccount(String accountType) {

        return null;
    }
}

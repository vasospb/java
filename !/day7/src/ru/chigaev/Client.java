package ru.chigaev;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vaso on 08.03.2016.
 */
public class Client {
    private static int clientIndex = 0;

    private String name;
    private List<Account> accounts;
    private Account activeAccount;
    private float initialOverdraft;
    Gender gender;
    private AccountType accountType;

    enum AccountType {
        CHECKING,
        SAVING
    }

    enum Gender {
        MALE("Dear Mr. "),
        FEMALE("Dear Ms. ");
        public String greeting;

        Gender(String greet) {
            this.greeting = greet;
        }
    }


    public void getClientSalutation() {
        System.out.println(gender.greeting + name);

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    Client() {
        clientIndex += 1;
        System.out.println("\nСlient number " + clientIndex + " created");
        accounts = new ArrayList<Account>();

        accounts.add(new CheckingAccount());
        accounts.add(new SavingAccount());

    }

    Client(Gender gender) {
        this();
        this.gender = gender;

    }

    Client(float initialOverdraft, Gender gender) {
        this();
        ((CheckingAccount) accounts.get(0)).setOverdraft(initialOverdraft);
        this.gender = gender;
    }

    void setActiveAccount(Account a) {
        activeAccount = a;
    }
    public Account getActiveAccount(){
        return activeAccount;
    }
    float getBallance() {
        return 0;
    }

    List<Account> getAccounts() {

        return accounts;
    }

    Account createAccount(AccountType accountType) {
        Account a;
        switch (accountType) {
            case CHECKING:
                a = new CheckingAccount();
                accounts.add(a);

                return a;
            case SAVING:
                a = new SavingAccount();
                accounts.add(a);
                return a;
            default:
               return null;
        }
    }
}

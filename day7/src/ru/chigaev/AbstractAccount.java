package ru.chigaev;

/**
 * Created by vaso on 08.03.2016.
 */
abstract public class AbstractAccount implements Account {
    protected float balance;
    protected int accountNumber;
    protected static int accountIndex = 0;


    public float deposit(float x) {
        if (x<0) {
            System.out.println("Deposit value cannot be negative");
            return balance;
        }
        balance += x;
        System.out.println(x + " was put into the account number: " + accountNumber);
        return balance;
    }

    public float getBalance() {
        return balance;
    }


    public float withdraw(float x) {
        if (x > balance) {
            System.out.println("Not enouph funds on the balance. Withdraw is not possible");
            return balance;
        } else {
            balance -= x;
            System.out.println(x + " was withdrawn from account number: " + accountNumber + ". " + balance + " left on account.");
            return balance;
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    AbstractAccount() {
        accountIndex ++;
        accountNumber = accountIndex;

    }
}

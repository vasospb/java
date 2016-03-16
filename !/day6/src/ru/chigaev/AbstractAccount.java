package ru.chigaev;

/**
 * Created by vaso on 08.03.2016.
 */
abstract public class AbstractAccount implements Account {
    private float ballance;
    private int accountNumber;
    protected static int accountIndex = 0;

    public float deposit(float x) {
        ballance += x;

        System.out.println(x + " was put into the account number: " + accountNumber);
        return ballance;
    }

    public float getBallance() {
        return ballance;
    }


    public float withdraw(float x) {
        ballance -= x;
        System.out.println(x + " was withdrawn from account number: " + accountNumber + ". " + ballance + " left on account.");
        return ballance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    AbstractAccount() {
        accountIndex += 1;
        accountNumber = accountIndex;

    }
}

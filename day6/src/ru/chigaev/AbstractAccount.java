package ru.chigaev;

/**
 * Created by vaso on 08.03.2016.
 */
abstract public class AbstractAccount implements Account {
    private float ballance;
    public int accNumber;

    static int accIndx = 0;

    public float deposit(float x) {
        ballance += x;

        System.out.println(x + " was put into the account number: " + accNumber);
        return ballance;
    }

    public float getBallance() {
        return ballance;
    }


    public float withdraw(float x) {
        ballance -= x;
        System.out.println(x + " was withdrawn from account number: " + accNumber + ". " + ballance + " left on account.");
        return ballance;
    }

    public int getAccNumber() {
        return accNumber;
    }

    AbstractAccount() {
        accIndx += 1;
        accNumber = accIndx;

    }
}

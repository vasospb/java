package ru.chigaev;

/**
 * Created by vaso on 08.03.2016.
 */
public interface Account {
    float getBalance();
    float deposit(float x);
    float withdraw(float x);
    int getAccountNumber();
}

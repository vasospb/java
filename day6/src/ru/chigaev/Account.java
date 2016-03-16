package ru.chigaev;

/**
 * Created by vaso on 08.03.2016.
 */
public interface Account {
    public float getBallance();
    public float deposit(float x);
    public float withdraw (float x);
    public int getAccNumber();
}

package ru.chigaev;

import java.util.Date;

/**
 * Created by vaso on 18.03.2016.
 */
public class Main {

 static   public long getTimeInMillis() {
        return System.currentTimeMillis();
    }


    public static void main(String[] args) {
        int i =1;
        System.out.println(++i);
        System.out.println(i);

      long currentTime= getTimeInMillis();
        Date currentDate =new Date(currentTime);
        System.out.println(currentTime);
        System.out.println(currentDate);
    }
}

package ru.chigaev;


import java.math.BigDecimal;
import java.math.RoundingMode;

/**
change on github
<<<<<<< HEAD
rrr
=======

>>>>>>> 8adb444e107f6ec74b35ed33468e802cf5dc9c4f
 */
public class rr {



    public static int getRandomAge(int minAge, int maxAge) {
      int rand;
        do {
            rand = (int) Math.round(Math.random() * maxAge);

        }
        while (rand<minAge);

        return rand;
    }

    public double getHypotenuse(double cathetus1,
                                double cathetus2) {
        double res;
       BigDecimal bd = new BigDecimal(Math.sqrt(cathetus1 * cathetus1 + cathetus2 * cathetus2));
        res=bd.setScale(2, RoundingMode.CEILING).doubleValue();
        return res;
    }
    public static void main(String[] args) {
        for(int i=0;i<100;i++) System.out.println(getRandomAge(18,35));
    }
}

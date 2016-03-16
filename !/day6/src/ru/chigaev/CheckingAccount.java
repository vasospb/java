package ru.chigaev;

/**
 * Created by vaso on 08.03.2016.
 */
public class CheckingAccount extends AbstractAccount {
   private float overdraft;

    public void setOverdraft(float x) {

        this.overdraft = x;
        System.out.println("\tOverdraft has been setup for accont number:"+ accountNumber + " to the value of "+ x);
    }




    CheckingAccount(){
        super();

        System.out.println("\tChecking account number "+ accIndx + " created.");

    }

}

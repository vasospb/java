package ru.chigaev;

/**
 * Created by vaso on 08.03.2016.
 */
public class CheckingAccount extends AbstractAccount {
    private float overdraft;

    public void setOverdraft(float x) {
        this.overdraft = x;
        System.out.println("\tOverdraft has been setup for accont number:" + accountNumber + " to the value of " + x);
    }
    public float getOverdraft(){
        return overdraft;
    }

    public float withdraw(float x) {
        float overdraftUsed;
        float prevOverdraft = overdraft;
        if (x > (balance + overdraft)) {
            System.out.println("Not funds for withdraw.\n You ask: "+x+" But you have "+ balance +" on balance. and "+
            overdraft+" for overdraft");
            return balance;
        } else if (x > balance && x < (balance + overdraft)) {

            overdraftUsed = x - balance;
            overdraft -= overdraftUsed;
            balance = 0;
            System.out.println("Withdrew "+x+" from your account.You use all balance and " + overdraftUsed + " from overdraft. ");
            System.out.println("You have left " + overdraft + " from "+prevOverdraft+" overdraft on your account.");
            return balance;
        } else {
            balance -= x;
            System.out.println(x + " was withdrawn from checking account number: " + accountNumber + ". " + balance + " left on account.");
            return balance;
        }
    }

    CheckingAccount() {
        super();
        System.out.println("\tChecking account number " + accountIndex + " created.");
    }

    CheckingAccount(float x) {
        this();
        overdraft = x;
    }

}

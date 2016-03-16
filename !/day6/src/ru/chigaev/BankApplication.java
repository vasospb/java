package ru.chigaev;

import java.util.List;


public class BankApplication {

    static void initialize(Bank bank, float[][] initialDeposit) {
        if (bank != null) {
            System.out.println("Bank created!");
        }

        bank.addClient(new Client());
        bank.addClient(new Client(100));

        bank.clients.get(0).setName("Чигаев В.В.");
        bank.clients.get(1).setName("Петров В.К.");


        //Deposit funds on all accounts

        bank.clients.get(0).getAccounts().get(0).deposit(initialDeposit[0][0]);
        bank.clients.get(0).getAccounts().get(1).deposit(initialDeposit[0][1]);

        bank.clients.get(1).getAccounts().get(0).deposit(initialDeposit[1][0]);
        bank.clients.get(1).getAccounts().get(1).deposit(initialDeposit[1][1]);
    }


    static void modifyBank(Bank bank, float[][] depArray, float[][] withdrawArray) {
        System.out.println("\nDeposit some moneyt:");

        for (Client c: bank.getClients()
             ) {


        }//first for
        bank.clients.get(0).getAccounts().get(0).deposit(depArray[0][0]);
        bank.clients.get(0).getAccounts().get(1).deposit(depArray[0][1]);
        bank.clients.get(1).getAccounts().get(0).deposit(depArray[1][0]);
        bank.clients.get(1).getAccounts().get(1).deposit(depArray[1][1]);


        System.out.println("\nWithdraw  some moneyt:");
        bank.clients.get(0).getAccounts().get(1).withdraw(withdrawArray[0][1]);
        bank.clients.get(1).getAccounts().get(0).withdraw(withdrawArray[1][0]);
        bank.clients.get(1).getAccounts().get(1).withdraw(withdrawArray[1][1]);
        bank.clients.get(0).getAccounts().get(0).withdraw(withdrawArray[0][0]);

    }

    static void test(Bank bank, float[][] initArray, float[][] depArray, float[][] withdrawArray) {
        int ii = 0;
        System.out.println("\nWe are starting test:");
        List<Client> cList = bank.clients;

        for (int i = 0; i < cList.size(); i++) {
            ii = i + 1;
            System.out.println("Client number " + ii + ": " + cList.get(i).getName());
            List<Account> aList = cList.get(i).getAccounts();
            for (int x = 0; x < aList.size(); x++) {
                //Compare data from arrays with the data from objects
                if ((initArray[i][x] + depArray[i][x] - withdrawArray[i][x]) == aList.get(x).getBallance()) {
                    System.out.println("\t Account number " + aList.get(x).getAccountNumber() + " test Passed");
                } else {
                    System.out.println("\t Account number " + aList.get(x).getAccountNumber() + " test failed");
                }
                System.out.println("\t Account number " + aList.get(x).getAccountNumber() + " initialy has: " + initArray[i][x] +
                        " then " + depArray[i][x] + " was added. " +
                        " and " + withdrawArray[i][x] + " was withdrawn " +
                        ": ballance now: " + aList.get(x).getBallance());
            }

        }


    }

    public static void main(String[] args) {
        // write your code here

        float[][] in = new float[2][2];
        in[0][0] = 10;
        in[0][1] = 20;
        in[1][0] = 30;
        in[1][1] = 40;

        float[][] dep = new float[2][2];
        dep[0][0] = 12;
        dep[0][1] = 15;
        dep[1][0] = 21;
        dep[1][1] = 24;

        float[][] withdraw = new float[2][2];
        withdraw[0][0] = 1;
        withdraw[0][1] = 5;
        withdraw[1][0] = 6;
        withdraw[1][1] = 4;


        Bank bank = new Bank();
        initialize(bank, in);

        modifyBank(bank, dep, withdraw);

        test(bank, in, dep, withdraw);
    }
}

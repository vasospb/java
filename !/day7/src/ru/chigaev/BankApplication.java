package ru.chigaev;

import java.util.List;

import ru.chigaev.Client.*;

import static ru.chigaev.Client.AccountType.*;
import static ru.chigaev.Client.Gender.*;


public class BankApplication {

    static void initialize(Bank bank, float[][] initialDeposit) {
        if (bank != null) {
            System.out.println("Bank created!");
        }

        bank.addClient(new Client(900, MALE));
        bank.addClient(new Client(100, FEMALE));

        bank.getClients().get(0).setName("Чигаев В.В.");
        bank.getClients().get(1).setName("Петров В.К.");

        bank.getClients().get(0).getClientSalutation();
        bank.getClients().get(1).getClientSalutation();

        bank.getClients().get(0).getAccounts().get(0).deposit(initialDeposit[0][0]);
        bank.getClients().get(0).getAccounts().get(1).deposit(initialDeposit[0][1]);

        bank.getClients().get(1).getAccounts().get(0).deposit(initialDeposit[1][0]);
        bank.getClients().get(1).getAccounts().get(1).deposit(initialDeposit[1][1]);
    }


    static void modifyBank(Bank bank, float[][] depArray, float[][] withdrawArray) {
        System.out.println("\nDeposit and withdraw some moneyt:");
        for (int i = 0; i < 2; i++) {
            for (int x = 0; x < 2; x++) {
                bank.getClients().get(i).getAccounts().get(x).deposit(depArray[i][x]);
                bank.getClients().get(i).getAccounts().get(x).withdraw(withdrawArray[i][x]);
            }
        }
        bank.getClients().get(0).createAccount(CHECKING);
     }

    static void test(Bank bank, float[][] initArray, float[][] depArray, float[][] withdrawArray) {
        System.out.println("\nWe are starting test:");
        List<Client> clientList = bank.getClients();



        for (int i = 0; i < clientList.size(); i++) {
            System.out.println("Client number " + (i+1) + ": " + clientList.get(i).getName());
            List<Account> aList = clientList.get(i).getAccounts();
            for (int x = 0; x < 2; x++) {
                //Compare data from arrays with the data from objects
                if ((initArray[i][x] + depArray[i][x] - withdrawArray[i][x]) == aList.get(x).getBalance()) {
                    System.out.println("\t Account number " + aList.get(x).getAccountNumber() + " test Passed");
                } else {
                    System.out.println("\t Account number " + aList.get(x).getAccountNumber() + " test failed");
                }
                System.out.println("\t Account number " + aList.get(x).getAccountNumber() + " initialy has: " + initArray[i][x] +
                        " then " + depArray[i][x] + " was added. " +
                        " and " + withdrawArray[i][x] + " was withdrawn " +
                        ": balance now: " + aList.get(x).getBalance());
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
        withdraw[0][0] = 10;
        withdraw[0][1] = 5;
        withdraw[1][0] = 6;
        withdraw[1][1] = 4;


        Bank bank = new Bank();
        initialize(bank, in);

        modifyBank(bank, dep, withdraw);

        test(bank, in, dep, withdraw);



    }
}

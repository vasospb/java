package ru.chigaev;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vaso on 08.03.2016.
 */
public class Bank {
    List<Client> clients = new ArrayList<Client>();

    //Methods
    List<Client> getClients() {

        return clients;
    }

    void addClient(Client cl) {
        clients.add(cl);

    }

}


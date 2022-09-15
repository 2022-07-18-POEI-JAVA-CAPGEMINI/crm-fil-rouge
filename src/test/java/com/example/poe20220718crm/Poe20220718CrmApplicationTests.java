package com.example.poe20220718crm;

import com.example.poe20220718crm.business.Client;
import com.example.poe20220718crm.business.ClientRepository;
import com.example.poe20220718crm.business.ClientState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Poe20220718CrmApplicationTests {

    @Autowired
    ClientRepository clientRepository;

    @Test
    void findAllClients() {
        List<Client> clients = clientRepository.findAll();
        for(Client client : clients){
            System.out.println(client);
        }
    }

    @Test
    void saveClient() {
        Client client = new Client("Google","Steven", "Bond", "a@a.com" ,
                "07070707707", "my street", "", "NY", "USA", ClientState.ACTIVE);
        clientRepository.save(client);
    }
}

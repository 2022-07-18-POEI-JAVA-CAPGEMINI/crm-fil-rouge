package com.example.poe20220718crm;

import com.example.poe20220718crm.business.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Poe20220718CrmApplicationTests {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    OrderRepository orderRepository;

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

    @Test
    void findAllOrders() {
        List<Order> orders =orderRepository.findAll();
        for(Order order : orders){
            System.out.println(order);
        }
    }

    @Test
    void saveOrder() {
        Client client = new Client("Google","Steven", "Bond", "a@a.com" ,
                "07070707707", "my street", "", "NY", "USA", ClientState.ACTIVE);
        clientRepository.save(client);
        Order order = new Order("Conseil en sécurité", "Procedure de hacking complete", 2, 900, OrderState.CONFIRMED);
        order.setClient(client);
        orderRepository.save(order);
    }
}

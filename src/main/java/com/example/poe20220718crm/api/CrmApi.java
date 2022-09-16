package com.example.poe20220718crm.api;

import com.example.poe20220718crm.business.Client;
import com.example.poe20220718crm.business.CrmService;
import com.example.poe20220718crm.business.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class CrmApi {

    @Autowired
    CrmService crmService;

    @GetMapping("clients")
    public List<Client> getAllClients() {

        return crmService.findAllClients();
    }

    @PostMapping("clients")
    public void createClient(@RequestBody Client newClient){
        crmService.saveClient(newClient);
    }

    @GetMapping("orders")
    public List<Order> getAllOrders() {

        return crmService.findAllOrders();
    }

    @PostMapping("orders")
    public void createOrder(@RequestBody Order newOrder){
        crmService.saveOrder(newOrder);
    }
}

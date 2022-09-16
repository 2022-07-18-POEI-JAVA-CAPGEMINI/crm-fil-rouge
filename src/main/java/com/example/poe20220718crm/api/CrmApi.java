package com.example.poe20220718crm.api;

import com.example.poe20220718crm.business.Client;
import com.example.poe20220718crm.business.CrmService;
import com.example.poe20220718crm.business.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class CrmApi {

    @Autowired
    CrmService crmService;

    @GetMapping("clients")
    public List<ClientDTO> getAllClients() {

        List<Client> clients = crmService.findAllClients();
        List<ClientDTO> dtos = new ArrayList<>();
        for(Client client : clients){
            dtos.add(ClientMapper.convertEntityToDTO(client));
        }
        return dtos;
    }

    @PostMapping("clients")
    public void createClient(@RequestBody Client newClient){
        crmService.saveClient(newClient);
    }

    @DeleteMapping("clients/{id}")
    public void deleteClient(@PathVariable("id") Long id){
        crmService.deleteClient(id);
    }

    @PutMapping("clients/{id}")
    public ResponseEntity<String> updateClient(@PathVariable("id") Long id, @RequestBody Client client){
        if(!id.equals(client.getId())){
            return ResponseEntity.badRequest().body("les id ne sont pas identiques");
        } else {
            Optional<Client> op = crmService.findClientById(id);
            if(op.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id not found");
            } else {
                crmService.updateClient(client);
                return ResponseEntity.ok().build();
            }
        }
    }


    /****************************************/

    @GetMapping("orders")
    public List<OrderDTO> getAllOrders() {

         List<Order> orders = crmService.findAllOrders();

         List<OrderDTO> dtos = new ArrayList<>();
         for(Order order: orders){
             dtos.add(OrderMapper.convertEntityToDTO(order));
         }

         return dtos;
    }

    @PostMapping("orders")
    public void createOrder(@RequestBody OrderDTO newOrder){
        crmService.saveOrder(OrderMapper.convertDTOToEntity(newOrder));
    }

    @DeleteMapping("orders/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long id){
        try {
            crmService.deleteOrder(id);
            return ResponseEntity.ok("Order deleted");
        }
        catch(EmptyResultDataAccessException e) {
            System.out.println("id inexistant dans deleteOrder()");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id inexistant");
        }
    }

    @PutMapping("orders/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable("id") Long id, @RequestBody Order order){
        if(!id.equals(order.getId())){
            return ResponseEntity.badRequest().body("les id ne sont pas identiques");
        } else {
            Optional<Order> op = crmService.findOrderById(id);
            if(op.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id not found");
            } else {
                crmService.updateOrder(order);
                return ResponseEntity.ok().build();
            }
        }
    }


    // http://localhost:8080/api/searchOrdersByClient?client=1
    @GetMapping("searchOrdersByClient")
    public List<Order> findAllOrdersByClient(@RequestParam("client") Client client){
        System.out.println(client);
        return crmService.findAllOrdersByClient(client);
    }
}

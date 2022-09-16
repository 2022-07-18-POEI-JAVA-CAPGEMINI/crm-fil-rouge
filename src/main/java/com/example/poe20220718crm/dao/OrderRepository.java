package com.example.poe20220718crm.dao;

import com.example.poe20220718crm.business.Client;
import com.example.poe20220718crm.business.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    public List<Order> findAllByClient(Client client);
}

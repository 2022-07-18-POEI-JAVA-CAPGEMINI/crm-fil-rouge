package com.example.poe20220718crm.api;

import com.example.poe20220718crm.business.Order;

public class OrderMapper {

    public static OrderDTO convertEntityToDTO(Order entity) {
        OrderDTO dto = new OrderDTO();
        dto.setId(entity.getId());
        dto.setTypePresta(entity.getTypePresta());
        dto.setDesignation(entity.getDesignation());
        dto.setNbDays(entity.getNbDays());
        dto.setUnitPrice(entity.getUnitPrice());
        dto.setState(entity.getState());
        dto.setClient(ClientMapper.convertEntityToDTO(entity.getClient()));

        dto.setPrixHT(entity.getUnitPrice() * entity.getNbDays());
        dto.setPrixTTC(dto.getPrixHT() * 1.2f);
        return dto;
    }

    public static Order convertDTOToEntity(OrderDTO dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setTypePresta(dto.getTypePresta());
        order.setDesignation(dto.getDesignation());
        order.setNbDays(dto.getNbDays());
        order.setUnitPrice(dto.getUnitPrice());
        order.setState(dto.getState());
        order.setClient(ClientMapper.convertDTOToEntity(dto.getClient()));
        return order;
    }
}

package com.example.poe20220718crm.api;

import com.example.poe20220718crm.business.Client;
import com.example.poe20220718crm.business.ClientState;

public class ClientMapper {

    public static ClientDTO convertEntityToDTO(Client entity){
        ClientDTO dto = new ClientDTO();

        dto.setId(entity.getId());
        dto.setCompanyName(entity.getCompanyName());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setAddress(entity.getAddress());
        dto.setZipCode(entity.getZipCode());
        dto.setCity(entity.getCity());
        dto.setCountry(entity.getCountry());
        dto.setState(entity.getState());

        return dto;
    }

    public static Client convertDTOToEntity(ClientDTO dto){
        Client entity = new Client();

        entity.setId(dto.getId());
        entity.setCompanyName(dto.getCompanyName());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setAddress(dto.getAddress());
        entity.setZipCode(dto.getZipCode());
        entity.setCity(dto.getCity());
        entity.setCountry(dto.getCountry());
        entity.setState(dto.getState());

        return entity;
    }
}

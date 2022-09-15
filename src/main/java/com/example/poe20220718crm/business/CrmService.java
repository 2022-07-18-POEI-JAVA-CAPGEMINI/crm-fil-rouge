package com.example.poe20220718crm.business;

import com.example.poe20220718crm.dao.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrmService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    public void saveClient(Client newClient) {
        // par sécurité on vire l'id pour pas permettre la modification de
        // la base de données
        newClient.setId(null);

        clientRepository.save(newClient);
    }
}

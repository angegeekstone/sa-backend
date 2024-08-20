package com.geekstone.sa_backend.service;

import com.geekstone.sa_backend.entites.Client;
import com.geekstone.sa_backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

   private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public  void creer(Client client){
       Client clientdanlabdd = this.clientRepository.findByEmail(client.getEmail());
       if(clientdanlabdd == null){
           this.clientRepository.save(client);
       }

    }

    public List<Client> rechercher() {
        return this.clientRepository.findAll();
    }

    public  Client lire (int id){
        Optional<Client> client = this.clientRepository.findById(id);
        return client.orElse(null);
    }

    public Client lireOuCreer(Client client) {
        Client clientDansLaBDD = this.clientRepository.findByEmail(client.getEmail());
        if(clientDansLaBDD == null){
           clientDansLaBDD =  this.clientRepository.save(client);
        }
        return  clientDansLaBDD;
    }

    public void modifier(int id, Client client) {
       Client clientDansLaBDD = this.lire(id);
       if(clientDansLaBDD.getId() == client.getId()){
           clientDansLaBDD.setEmail(client.getEmail());
           clientDansLaBDD.setTelephone(clientDansLaBDD.getTelephone());
           this.clientRepository.save(clientDansLaBDD);
       }

    }
}

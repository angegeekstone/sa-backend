package com.geekstone.sa_backend.service;

import com.geekstone.sa_backend.entites.Client;
import com.geekstone.sa_backend.entites.Sentiment;
import com.geekstone.sa_backend.enums.TypeSentiment;
import com.geekstone.sa_backend.repository.SentimentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class SentimentService {
    private ClientService clientService;
    private SentimentRepository sentimentRepository;

    public SentimentService(ClientService clientService, SentimentRepository sentimentRepository) {
        this.clientService = clientService;
        this.sentimentRepository = sentimentRepository;
    }

    public void creer(Sentiment sentiment){
       Client client = this.clientService.lireOuCreer(sentiment.getClient());
       sentiment.setClient(client);


       if(sentiment.getTexte().contains("pas")){
           sentiment.setType(TypeSentiment.NEGATIF);
       } else {
           sentiment.setType(TypeSentiment.POSITIF);
       }

      this.sentimentRepository.save(sentiment);
    }

    public List<Sentiment> rechercher(TypeSentiment typeSentiment) {
        if(typeSentiment == null){
            return  this.sentimentRepository.findAll();
        } else {
            return this.sentimentRepository.findByType(typeSentiment);
        }

    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public void supprimer(int id) {
    }
}

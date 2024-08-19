package com.geekstone.sa_backend.controller;


import com.geekstone.sa_backend.entites.Sentiment;
import com.geekstone.sa_backend.enums.TypeSentiment;
import com.geekstone.sa_backend.service.SentimentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "sentiment", produces = APPLICATION_JSON_VALUE)
public class SentimentController {
    private SentimentService sentimentService;
   public  SentimentController(SentimentService sentimentService){
       this.sentimentService = sentimentService;
   }



   @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Sentiment sentiment){
    this.sentimentService.creer(sentiment);
    }

    @GetMapping
    public @ResponseBody List<Sentiment> rechercher(@RequestParam(required = false) TypeSentiment typeSentiment){
      return this.sentimentService.rechercher(typeSentiment);
    }

    @DeleteMapping(path = "{id}")
    public void supprimer(@PathVariable int id){
       this.sentimentService.supprimer(id);
    }

}

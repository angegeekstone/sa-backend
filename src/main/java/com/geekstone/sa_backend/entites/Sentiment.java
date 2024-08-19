package com.geekstone.sa_backend.entites;

import com.geekstone.sa_backend.enums.TypeSentiment;
import jakarta.persistence.*;

import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "SENTIMENT")
public class Sentiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String texte;
    private TypeSentiment type;

    @ManyToOne(cascade = {PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    public Sentiment() {
    }

    public Sentiment(int id, String texte, TypeSentiment type, Client client) {
        this.id = id;
        this.texte = texte;
        this.type = type;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public String getTexte() {
        return texte;
    }

    public TypeSentiment getType() {
        return type;
    }

    public Client getClient() {
        return client;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public void setType(TypeSentiment type) {
        this.type = type;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

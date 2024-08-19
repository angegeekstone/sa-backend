package com.geekstone.sa_backend.repository;

import com.geekstone.sa_backend.entites.Sentiment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SentimentRepository extends JpaRepository<Sentiment, Integer> {

}

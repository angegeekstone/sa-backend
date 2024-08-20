package com.geekstone.sa_backend.repository;

import com.geekstone.sa_backend.entites.Sentiment;

import com.geekstone.sa_backend.enums.TypeSentiment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SentimentRepository extends JpaRepository<Sentiment, Integer> {
     List<Sentiment> findByType(TypeSentiment type);
}

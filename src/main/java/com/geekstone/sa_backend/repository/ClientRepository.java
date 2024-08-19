package com.geekstone.sa_backend.repository;

import com.geekstone.sa_backend.entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client ,Integer> {
   Client findByEmail(String email);
}

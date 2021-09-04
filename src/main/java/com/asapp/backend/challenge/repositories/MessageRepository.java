package com.asapp.backend.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asapp.backend.challenge.model.message.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}

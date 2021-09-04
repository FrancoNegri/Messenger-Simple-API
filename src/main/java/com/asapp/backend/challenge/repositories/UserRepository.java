package com.asapp.backend.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asapp.backend.challenge.model.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
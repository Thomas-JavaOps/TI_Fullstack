package com.example.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {

}

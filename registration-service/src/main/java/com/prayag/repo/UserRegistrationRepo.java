package com.prayag.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prayag.entity.User;

public interface UserRegistrationRepo extends JpaRepository<User, Integer>{

}

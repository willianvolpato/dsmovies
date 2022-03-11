package com.willian.dsmovies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.willian.dsmovies.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User getByEmail(String email);

}

package com.willian.dsmovies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.willian.dsmovies.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {}

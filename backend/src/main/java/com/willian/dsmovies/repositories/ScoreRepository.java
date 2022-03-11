package com.willian.dsmovies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.willian.dsmovies.entities.Score;
import com.willian.dsmovies.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {}

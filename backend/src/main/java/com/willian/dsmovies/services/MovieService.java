package com.willian.dsmovies.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.willian.dsmovies.dto.MovieDTO;
import com.willian.dsmovies.entities.Movie;
import com.willian.dsmovies.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable){
		Page<Movie> pageResult = repository.findAll(pageable);
		
		return pageResult.map(result -> new MovieDTO(result));
	}

	@Transactional(readOnly = true)
	public MovieDTO findById(Long movieId){
		Movie result = repository.findById(movieId).orElseThrow();
		
		return new MovieDTO(result);
	}

}

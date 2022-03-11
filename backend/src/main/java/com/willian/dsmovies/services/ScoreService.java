package com.willian.dsmovies.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.willian.dsmovies.dto.MovieDTO;
import com.willian.dsmovies.dto.ScoreDTO;
import com.willian.dsmovies.entities.Movie;
import com.willian.dsmovies.entities.Score;
import com.willian.dsmovies.entities.User;
import com.willian.dsmovies.repositories.MovieRepository;
import com.willian.dsmovies.repositories.ScoreRepository;
import com.willian.dsmovies.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ScoreRepository scoreRepository;

	@Transactional
	public MovieDTO saveScore(ScoreDTO scoreDto) {
		User user = userRepository.getByEmail(scoreDto.getEmail());
		
		if(user == null) {
			user = userRepository.saveAndFlush(new User(null, scoreDto.getEmail()));
		}
		
		Movie movie = movieRepository.getById(scoreDto.getMovieId());
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(scoreDto.getScore());
		
		scoreRepository.saveAndFlush(score);
		
		double scoresSum = 0.0;
		for(Score movieScore : movie.getScores()) {
			scoresSum += movieScore.getValue();
		}
		
		double scoresAvg = scoresSum / movie.getScores().size();
		
		movie.setScore(scoresAvg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.saveAndFlush(movie);
		
		return new MovieDTO(movie);
	}

}

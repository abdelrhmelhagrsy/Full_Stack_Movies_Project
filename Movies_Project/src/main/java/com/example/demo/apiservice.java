package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class apiservice {


		private final  MoviesRepository moviesRepository;
       
       

		@Autowired
			public apiservice(MoviesRepository moviesRepository) {
		
			this.moviesRepository = moviesRepository;
		}



	public MoviePage Get_Popular_Movies(int page) {
		
		  
		 String apiKey = "a97243d7813d31446f6c43284e6854d5";

		 String apiUrl = "https://api.themoviedb.org/3";

		  String URL_SEGEMENT_FOR_POPULAR = "/movie/popular";
		
		RestTemplate restTemplate = new RestTemplate();
		String urlForPopularMovies = apiUrl + URL_SEGEMENT_FOR_POPULAR + "?api_key=" + apiKey + "&page="
				+ page;
		
		
		return restTemplate.getForEntity(urlForPopularMovies, MoviePage.class).getBody();
	}

	
	// add all popular movies in Database (postgresql)
	public void put_popular_movies_InDatabase(List<Movie> movie) {
	
		moviesRepository.saveAll(movie);

	}


  // search movie by id from Data base
	public Movie search_by_id(Long id) {
		
		return moviesRepository.Searchbyid(id);
	}


  //search movie by movie id from external api
	public Movie search_by_movieID(Long movie_id) {
		 String apiUrl = "https://api.themoviedb.org/3";
		 String apiKey = "a97243d7813d31446f6c43284e6854d5";
		 String URL_SEGEMENT_FOR_POPULAR = "/movie/"+movie_id;
		 
		 String urlForPopularMovies = apiUrl + URL_SEGEMENT_FOR_POPULAR + "?api_key=" + apiKey;
		 RestTemplate restTemplate = new RestTemplate();			
			

		 
		return restTemplate.getForEntity(urlForPopularMovies, Movie.class).getBody();

	}


  // add movie in Data base
	public void add_movie_inDatabase(Movie movie) {
		moviesRepository.save(movie);
		
	}


   // search in data_base and external api about movie name
	public Movie search_by_name(String movie_name) {
		
		return moviesRepository.Searchbyname(movie_name);
	}


   

	
}

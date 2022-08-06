package com.example.demo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1/movie")
public class apicontroller {
	

    private final apiservice apiservice;
 
	
	public apicontroller(com.example.demo.apiservice apiservice) {
	
		this.apiservice = apiservice;
	}


	

   
	// search in data base and external api about details 
	@GetMapping(path = "SearchDetails")
	public Movie Search_by_details(@RequestParam Long movie_id)
	{
		try {
			
			Movie obj = apiservice.search_by_id(movie_id); // search from database
	        if(obj!=null)		
				return obj;
	        else
	        {
	        	Movie obj2 = apiservice.search_by_movieID(movie_id); //search from external api
	        	apiservice.add_movie_inDatabase(obj2);  //add movie to data base if it not exist
	        	return obj2;
	        }
			
			
			} catch(Exception e) {
			  throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "Required Movies is Missing");
			}
	   
	}
	
	
	//search in data base and external api about movie  by name
	@GetMapping(path = "SearchbyName")
	public Movie Search_by_details(@RequestParam String movie_name)
	{
		try {
		Movie null_obj =null;;
		Movie obj = apiservice.search_by_name(movie_name); // search from database
          if(obj!=null)		// if movie in data_base return movie 
			return obj;
			  else
		        {
		        	MoviePage moviePage = apiservice.Get_Popular_Movies(1); //search movie from external api
		        	
		        	List<Movie> results =moviePage.getResults();
		        	for (Movie item : results) {
		        	    if(item.getOriginal_title().equals(movie_name))
		        	    	
		        	    	{
		        	    	apiservice.add_movie_inDatabase(item); // add movie in database
		        	    	return item; // return movie from api search by name 
		        	    	}
		        	}
		        	
		        	return null_obj;
		        }
				
				
				} catch(Exception e) {
				  throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "Required Movies is Missing");
				}
        
        			
	}
	
	
	// get all popular movies by page number
	@GetMapping(path = "external")
	public MoviePage Get_Popular_Movies(@RequestParam int page){
		
	
		try {
			
			return apiservice.Get_Popular_Movies(page);
			
			} catch(Exception e) {
			  throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "Required Movies is Missing");
			}
	   
		
		
	}
	
	//////////////////////////////////////////////////
	

	//Extra function add all popular movies page in Data_base 
	
	// add all popular movies from external api to Database(postgresql)
	@PostMapping
	public void add_popular_movies_InDatabase(@RequestParam int page)
	{
		
	   
		
		try {
			
			MoviePage obj =  getpopular(page);
			if(obj!=null)
			 apiservice.put_popular_movies_InDatabase(obj.getResults());
			
			} catch(Exception e) {
				
			  throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "Movies not added to database");
			}
		
		
	}
	
	private MoviePage getpopular( int page){
		
		MoviePage obj = new MoviePage();
		obj = apiservice.Get_Popular_Movies(page);
		
	   
		return  obj;
		
	}
	


}

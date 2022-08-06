package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Long>{

	
	
    @Query("SELECT p FROM Movie p WHERE p.id =?1")    
    public Movie Searchbyid(Long keyword);

    @Query("SELECT p FROM Movie p WHERE p.original_title =?1")    
    public Movie Searchbyname(String keyword);
	
	
}

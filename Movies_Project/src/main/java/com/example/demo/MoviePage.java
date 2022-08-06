package com.example.demo;

import java.util.List;




public class MoviePage {
	private Integer page;
	
	private List<Movie> results;

	public MoviePage(Integer page, List<Movie> results) {
		super();
		this.page = page;
		this.results = results;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public List<Movie> getResults() {
		return results;
	}

	public void setResults(List<Movie> results) {
		this.results = results;
	}

	public MoviePage() {
		super();
	}
	
	

}

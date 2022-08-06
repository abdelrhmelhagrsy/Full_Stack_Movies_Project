import { useEffect, useState } from "react";
import { useParams, Link } from "react-router-dom";
import MoviesContainer from "./MoviesContainer";
import SearchBox from "./SearchBox";
import axios from "axios";
import "./Search.css";


import noimg from "../images/noimg.jpg";


const Search = () => {

  const imageBaseUrl = "https://images.tmdb.org/t/p/w500/";

  const params = useParams();
  let query = params.query;
  if (query == "") query = "none";
  console.log(query);
  const queryUrl =
    "http://localhost:8080/api/v1/movie/SearchbyName?movie_name=" + query ;
  const [movie, setMovies] = useState([]);
  useEffect(() => {
    const fetchMovies = async () => {
      return axios.get(queryUrl);
    };
    fetchMovies().then((response) => {
      console.log(response);
      setMovies(response.data);
    });
    console.log(movie.data);
  });
  return (
    <>
      
   


      <div className="moviePage">
        <img
          className="moviePagePoster"
          src={
            movie.poster_path ? imageBaseUrl + movie.poster_path : noimg
          }
          alt={movie.title + " poster"}
        />
        <div className="movieDetails">
          <h2 className="title">{movie.title}</h2>
          <div className="otherDetails">
           
            <p className="releaseDate">Released on : {movie.release_date}</p>
            <p className="revenue">Revenuse : {movie.revenue}</p>
          
            
              
              <p className="popularity">Popularity: {movie.popularity}</p>
            
          </div>
          <h2 className="oh">OverView about Movie :</h2>
          <p className="description">{movie.overview}</p>
        </div>
      </div>
    
    </>
  );
};

export default Search;

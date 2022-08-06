import { useEffect, useState } from "react";
import { useParams, Link } from "react-router-dom";
import axios from "axios";

import "./MovieDetails.css";


import noimg from "../images/noimg.jpg";

const MovieDetails = () => {
  const params = useParams();
  const movieId = params.id;
  const baseUrl = "http://localhost:8080/api/v1/movie/SearchDetails?movie_id=";
  const imageBaseUrl = "https://images.tmdb.org/t/p/w500/";
  const [movie, setMovie] = useState({});
  useEffect(() => {
    const fetchDetails = async () => {
      const res = await axios.get(baseUrl + movieId);
      return res;
    };
    fetchDetails().then((response) => {
      console.log(response.data);
      setMovie(response.data);
    });
  }, []);
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

export default MovieDetails;

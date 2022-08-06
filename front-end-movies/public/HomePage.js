import React, { useState, useEffect } from "react";
import MovieContainer from "../components/MovieContainer";
import NavBar from "../components/NavBar";
import axios from "axios";
import classes from "../styles/homePage.module.css";

const HomePage = () => {
  const [Movies, setMovies] = useState([]);

  useEffect(() => {
    getMovies();
  }, []);

  const getMovies = async () => {
    let res = await axios.get(
      `http://localhost:8080/api/v1/movie/external?page=1`
    );

    setMovies(res.data.results);
  };

  return (
    <div className={classes.page}>
      <NavBar />
      <br />
      <MovieContainer
        className={classes.test}
        movies={Movies}
        search={false}
        x
      />
    </div>
  );
};

export default HomePage;

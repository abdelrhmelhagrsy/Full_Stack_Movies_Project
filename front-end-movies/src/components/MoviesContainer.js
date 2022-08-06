import Movie from "./Movie.js";
import "./MoviesContainer.css";

const MoviesContainer = (props) => {
  const movies = props.movies;
  return (
    <div className="container">
      {movies.map((movie) => {
        return (
          <Movie
            key={movie.id}
            id={movie.id}
            title={movie.title}
            path={movie.poster_path}
          />
        );
      })}
    </div>
  );
};

export default MoviesContainer;

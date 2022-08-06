import "./Movie.css";
import { useNavigate } from "react-router-dom";
import noimg from "../images/noimg.jpg";

const Movie = (props) => {
  const title = props.title;
  const path = props.path;
  const id = props.id;
  const basePosterUrl = "https://images.tmdb.org/t/p/w300/";
  let navigate = useNavigate();
  const movieClickHandler = () => {
    navigate(`/movie/${id}`);
  };
  return (
    <div className="movie" onClick={movieClickHandler}>
      <img
        className="poster"
        src={path ? basePosterUrl + path : noimg}
        alt={"Img Not Found"}
      />
      <p className="movieTitle">{title}</p>
    </div>
  );
};

export default Movie;

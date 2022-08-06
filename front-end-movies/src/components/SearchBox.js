import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./SearchBox.css";

const SearchBox = () => {
  const navigate = useNavigate();
  const [search, setSearch] = useState();
  const searchBarChangeHandler = (event) => {
    setSearch(event.target.value);
  };
  const submitHandler = (e) => {
    e.preventDefault();
    const queryValue = search;
    setSearch("");
    navigate("/search/" + queryValue);
  };

  return (
    <form className="search" onSubmit={submitHandler}>
      <input
        className="searchBar"
        type="text"
        placeholder="search for movies here"
        value={search}
        onChange={searchBarChangeHandler}
      ></input>
      <button type="submit" className="searchButton" on onClick={submitHandler}>
        search
      </button>
    </form>
  );
};

export default SearchBox;

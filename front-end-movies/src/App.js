import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./components/Home.js";
import Search from "./components/Search.js";
import MovieDetails from "./components/MovieDetails";
import Error from "./components/Error.js";

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Routes>
          <Route path="/" exact element={<Home />} />
          <Route path="/search/:query" exact element={<Search />} />
          <Route path="/movie/:id" exact element={<MovieDetails />} />
          <Route path="*" element={<Error />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;

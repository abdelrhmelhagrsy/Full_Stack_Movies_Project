import { Link } from "react-router-dom";
import "./Error.css";
const Error = () => {
  return (
    <>
      <h1 className="error">404 Page Not Avaialble</h1>
      <Link to="/">
        <h3 className="home">Home</h3>
      </Link>
    </>
  );
};
export default Error;

import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import Login from "./component/admin/login";
import "./App.css";

function App() {
  const [count, setCount] = useState(0);

  return (
    <>
      {" "}
      <div className="App">
        <h1>Mi Aplicación</h1>
        <Login /> {/* Aquí agregas el componente Login */}
      </div>
    </>
  );
}

export default App;

import { useState } from "react";
import axios from "axios";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const handleLogin = async (e) => {
    e.preventDefault();
    setError(""); // Limpiar el mensaje de error

    try {
      // Usamos Axios para enviar los datos de login
      const response = await axios.post(
        "http://localhost:4040/api/workers/login",
        {
          email,
          password,
        }
      );

      console.log("Login exitoso:", response.data);

      // Si la respuesta es exitosa, puedes guardar el token en localStorage
      localStorage.setItem("token", response.data.token);

      // Redirigir o realizar alguna acción post-login, si es necesario
      // Por ejemplo, puedes redirigir al usuario a otra página (usando React Router)
    } catch (err) {
      setError("Credenciales incorrectas");
      console.error("Error de login:", err);
    }
  };

  return (
    <div>
      <h2>Iniciar Sesión</h2>
      {error && <p style={{ color: "red" }}>{error}</p>}
      <form onSubmit={handleLogin}>
        <input
          type="email"
          placeholder="Correo electrónico"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />
        <input
          type="password"
          placeholder="Contraseña"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
        <button type="submit">Iniciar Sesión</button>
      </form>
    </div>
  );
};

export default Login;

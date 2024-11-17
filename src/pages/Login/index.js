import React, { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import ImagemPerfil from "../images/perfil.png";

import "./index.css";

function Login() {
  const [usuario, setUsuario] = useState("");
  const [senha, setSenha] = useState("");
  const navigate = useNavigate();

  const handleLogin = (e) => {
    e.preventDefault();

    // Verifica se o usuário e senha são válidos
    if (usuario === "admin" && senha === "0000") {
      // Redireciona para a página visaoGeral
      navigate("/visaogeral");
    } else {
      alert("Usuário ou senha inválidos!");
    }
  };

  return (
    <div className="container">
      <img src={ImagemPerfil} alt="Logo" className="perfil" />
      <form onSubmit={handleLogin}>
        <div className="input-group">
          <input
            type="text"
            id="usuario"
            name="usuario"
            placeholder="Usuário"
            value={usuario}
            onChange={(e) => setUsuario(e.target.value)}
            required
          />
        </div>
        <div className="input-group">
          <input
            type="password"
            id="senha"
            name="senha"
            placeholder="Senha"
            value={senha}
            onChange={(e) => setSenha(e.target.value)}
            required
          />
        </div>
        <button type="submit" className="btn-login">
          Login
        </button>

        <div className="links">
          <Link to="/cadastro" className="link-voltar">
            Cadastre-se
          </Link>
          <Link to="/recuperacaoconta" className="link-voltar">
            Esqueci minha senha
          </Link>
        </div>
      </form>
    </div>
  );
}

export default Login;
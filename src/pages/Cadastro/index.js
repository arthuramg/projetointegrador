import React from "react";
import { Link } from "react-router-dom";
import "./index.css";

function Cadastro() {
  return (
    <div className="container">
      <h2>Cadastre-se <br /> agora mesmo!</h2>
      <form action="#">
        <div className="input-group">
          <input
            type="text"
            id="nome"
            name="nome"
            placeholder="Nome Completo"
            required
          />
        </div>
        <div className="input-group">
          <input
            type="email"
            id="email"
            name="email"
            placeholder="Email"
            required
          />
        </div>
        <div className="input-group">
          <input
            type="password"
            id="senha"
            name="senha"
            placeholder="Senha"
            required
          />
        </div>
        <div className="input-group">
          <input
            type="password"
            id="confirmar-senha"
            name="confirmar-senha"
            placeholder="Confirmar Senha"
            required
          />
        </div>
        <button type="submit" className="btn-cadastrar">Cadastrar</button>
        <Link to="/" className="link-voltar">
          Voltar ao Login
        </Link>
      </form>
    </div>
  );
}

export default Cadastro;
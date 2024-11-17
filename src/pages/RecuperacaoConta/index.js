import React from "react";
import { Link } from "react-router-dom";
import "./index.css";

function RecuperacaoConta() {
  return (
    <div className="container">
      <h2>Recuperação<br />da sua conta.</h2>
      <form action="#">
        <div className="input-group">
          <input
            type="email"
            id="email"
            name="email"
            placeholder="Email"
            required
          />
        </div>
        <p>
          Uma senha temporária foi enviada para o seu email.<br />
          Verifique sua caixa de entrada.
        </p>
        <button type="submit" className="btn-env-senha">
          Enviar Senha Temporária
        </button>
        <div className="links">
          <Link to="/" className="link-voltar">
            Voltar ao Login
          </Link>
        </div>
      </form>
    </div>
  );
}

export default RecuperacaoConta;
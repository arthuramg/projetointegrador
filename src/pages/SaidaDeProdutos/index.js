import React from "react";
import { Link } from "react-router-dom";
import "./index.css";
import IconVisaoGeral from "../icons/VisaoGeral.svg";
import IconEntrada from "../icons/Entrada.svg";
import IconSaida from "../icons/Saida.svg";
import IconCategorias from "../icons/Categorias.svg";
import IconFornecedores from "../icons/Fornecedores.svg";
import IconValidade from "../icons/Validade.svg";

function SaidaDeProdutos() {
  return (
    <div className="app">
      <aside className="sidebar">
        <h2 className="sidebar-title">E-STOCK</h2>
        <ul className="menu">
          <li className="menu-item">
            <Link to="/visaogeral">
              <img src={IconVisaoGeral} alt="Visão Geral" className="icon" />
              Visão Geral
            </Link>
          </li>
          <li className="menu-item">
            <Link to="/entradadeprodutos">
              <img src={IconEntrada} alt="Entrada de Produtos" className="icon" />
              Entrada de Produtos
            </Link>
          </li>
          <li className="menu-item active">
            <Link to="/saidadeprodutos">
              <img src={IconSaida} alt="Saída de Produtos" className="icon" />
              Saída de Produtos
            </Link>
          </li>
          <li className="menu-item">
            <Link to="/categoriasdeprodutos">
              <img src={IconCategorias} alt="Categorias de Produtos" className="icon" />
              Categorias de Produtos
            </Link>
          </li>
          <li className="menu-item">
            <Link to="/fornecedores">
              <img src={IconFornecedores} alt="Fornecedores" className="icon" />
              Fornecedores
            </Link>
          </li>
          <li className="menu-item">
            <Link to="/alertasdevalidade">
              <img src={IconValidade} alt="Alertas de Validade" className="icon" />
              Alertas de Validade
            </Link>
          </li>
        </ul>
        <footer className="sidebar-footer">PowerBy E-Stock</footer>
      </aside>
      <main className="main">
        <header className="header">
          <h1>CONTROLE DE ESTOQUE</h1>
          <div className="dropdown">
            PADARIA SANTA
            <span className="status-icon"></span>
          </div>
        </header>
        <section className="form-section">
          <form className="form">
            <h2>FORMULÁRIO DE SAÍDA</h2>
            <label>
              Produto:
              <select>
                <option value="">Selecione o produto</option>
              </select>
            </label>
            <label>
              Quantidade:
              <input type="number" placeholder="Quantidade" />
            </label>
            <label>
              Destino:
              <input type="text" placeholder="Destino" />
            </label>
            <label>
              Detalhes: (Opcional)
              <textarea placeholder="Detalhes adicionais"></textarea>
            </label>
            <div className="form-actions">
              <button type="button" className="cancel-btn">Cancelar</button>
              <button type="submit" className="submit-btn">Gerar Requisição</button>
            </div>
          </form>
        </section>
      </main>
    </div>
  );
}

export default SaidaDeProdutos;

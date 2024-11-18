import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import "./index.css";
import IconVisaoGeral from "../icons/VisaoGeral.svg";
import IconEntrada from "../icons/Entrada.svg";
import IconSaida from "../icons/Saida.svg";
import IconCategorias from "../icons/Categorias.svg";
import IconFornecedores from "../icons/Fornecedores.svg";
import IconCadastroEmpresas from "../icons/Empresas.png";
import IconGenerico from "../icons/Generico.png";

function SaidaDeProdutos() {
  const [showModal, setShowModal] = useState(false);
  const navigate = useNavigate();

  const handleLogoutClick = () => {
    setShowModal(true);
  };

  const handleConfirmLogout = () => {
    setShowModal(false)
    navigate("/");
  };

  const handleCancelLogout = () => {
    setShowModal(false);
  };

  return (
    <div className="app">
      <aside className="sidebar">
        <h3 className="sidebar-title">E-STOCK</h3>
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
            <Link to="/cadastroempresas">
              <img src={IconCadastroEmpresas} alt="Cadastro de Empresas" className="icon" />
              Cadastro de Empresas
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
            <img
              src={IconGenerico}
              alt="Genérico"
              className="icon"
              onClick={handleLogoutClick}
              style={{ cursor: "pointer" }}
            />
          </div>
        </header>
        <section className="form-section">
          <form className="form">
            <h2>FORMULÁRIO DE SAÍDA</h2>
            <label>
              <select>
                <option value="">Selecione o produto</option>
              </select>
            </label>
            <label>
              <input type="number" placeholder="Quantidade" />
            </label>
            <div className="form-actions">
              <button type="button" className="cancel-btn">Cancelar</button>
              <button type="submit" className="submit-btn">Gerar Requisição</button>
            </div>
          </form>
        </section>
      </main>
      {showModal && (
        <div className="modal-overlay">
          <div className="modal">
            <p>Tem certeza que deseja sair?</p>
            <div className="modal-actions">
              <button className="cancel-btn" onClick={handleCancelLogout}>
                Cancelar
              </button>
              <button className="submit-btn" onClick={handleConfirmLogout}>
                Confirmar
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}

export default SaidaDeProdutos;

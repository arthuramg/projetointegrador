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

function VisaoGeral() {
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
        <div className="sidebar-separator"></div>
        <ul className="menu">
          <li className="menu-item active">
            <Link to="/visaogeral" className="menu-link">
              <img src={IconVisaoGeral} alt="Visão Geral" className="icon" />
              Visão Geral
            </Link>
          </li>
          <li className="menu-item">
            <Link to="/entradadeprodutos" className="menu-link">
              <img src={IconEntrada} alt="Entrada de Produtos" className="icon" />
              Entrada de Produtos
            </Link>
          </li>
          <li className="menu-item">
            <Link to="/saidadeprodutos" className="menu-link">
              <img src={IconSaida} alt="Saída de Produtos" className="icon" />
              Saída de Produtos
            </Link>
          </li>
          <li className="menu-item">
            <Link to="/categoriasdeprodutos" className="menu-link">
              <img src={IconCategorias} alt="Categorias de Produtos" className="icon" />
              Categorias de Produtos
            </Link>
          </li>
          <li className="menu-item">
            <Link to="/fornecedores" className="menu-link">
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
          <h1>Controle de Estoque</h1>
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
        <section className="table-section">
          <table className="data-table">
            <thead>
              <tr>
                <th>Produto</th>
                <th>Categoria</th>
                <th>Fornecedor</th>
                <th>Entrada (qtd)</th>
                <th>Data de Entrada</th>
                <th>Saída (qtd)</th>
                <th>Data Saída</th>
              </tr>
            </thead>
          </table>
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

export default VisaoGeral;
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

function CadastroEmpresas() {
  const [showModal, setShowModal] = useState(false);
  const navigate = useNavigate();

  const handleLogoutClick = () => {
    setShowModal(true);
  };

  const handleConfirmLogout = () => {
    setShowModal(false);
    navigate("/");
  };

  const handleCancelLogout = () => {
    setShowModal(false);
  };

  const [empresas, setEmpresas] = useState([
    { nome: "Concreteira Apolo", cnpj: "12.144.675/0001-31" },
  ]);
  const [novaEmpresa, setNovaEmpresa] = useState("");
  const [cnpj, setCnpj] = useState("");
  const [modalAberto, setModalAberto] = useState(false);
  const [empresaParaExcluir, setEmpresaParaExcluir] = useState(null);

  const handleAdicionarEmpresa = () => {
    if (novaEmpresa && cnpj) {
      setEmpresas([...empresas, { nome: novaEmpresa, cnpj }]);
      setNovaEmpresa("");
      setCnpj("");
    } else {
      alert("Preencha todos os campos!");
    }
  };

  const handleAbrirModal = (index) => {
    setEmpresaParaExcluir(index);
    setModalAberto(true);
  };

  const handleFecharModal = () => {
    setModalAberto(false);
    setEmpresaParaExcluir(null);
  };

  const handleExcluir = () => {
    const novasEmpresas = empresas.filter((_, i) => i !== empresaParaExcluir);
    setEmpresas(novasEmpresas);
    setModalAberto(false);
  };

  return (
    <div className="app">
      {/* Sidebar */}
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
          <li className="menu-item">
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
          <li className="menu-item active">
            <Link to="/cadastroempresas">
              <img src={IconCadastroEmpresas} alt="Cadastro de Empresas" className="icon" />
              Cadastro de Empresas
            </Link>
          </li>
        </ul>
        <footer className="sidebar-footer">PowerBy E-Stock</footer>
      </aside>

      {/* Main */}
      <main className="main">
        <header className="header">
          <h1>CADASTRO DE EMPRESAS</h1>
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
          {/* Formulário de Nova Empresa */}
          <div className="form">
            <h2>ADICIONAR NOVA EMPRESA</h2>
            <label>
              <input
                type="text"
                value={novaEmpresa}
                onChange={(e) => setNovaEmpresa(e.target.value)}
                placeholder="Nome da Empresa"
              />
            </label>
            <label>
              <input
                type="text"
                value={cnpj}
                onChange={(e) => setCnpj(e.target.value)}
                placeholder="CNPJ"
              />
            </label>
            <div className="form-actions">
              <button
                className="cancel-btn"
                onClick={() => {
                  setNovaEmpresa("");
                  setCnpj("");
                }}
              >
                Cancelar
              </button>
              <button className="submit-btn" onClick={handleAdicionarEmpresa}>
                Adicionar
              </button>
            </div>
          </div>

          {/* Lista de Empresas */}
          <div className="table-container">
            <h2>LISTA DE EMPRESAS</h2>
            <table>
              <thead>
                <tr>
                  <th>Empresa</th>
                  <th>CNPJ</th>
                  <th>Ações</th>
                </tr>
              </thead>
              <tbody>
                {empresas.map((empresa, index) => (
                  <tr key={index}>
                    <td>{empresa.nome}</td>
                    <td>{empresa.cnpj}</td>
                    <td>
                      <button className="delete-btn" onClick={() => handleAbrirModal(index)}>
                        Excluir
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
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

      {/* Modal de Exclusão */}
      {modalAberto && (
        <div className="modal-overlay">
          <div className="modal">
            <p>
              Tem certeza que deseja excluir a empresa{" "}
              <strong>{empresas[empresaParaExcluir]?.nome}</strong>?
            </p>
            <div className="modal-actions">
              <button className="cancel-btn" onClick={handleFecharModal}>
                Cancelar
              </button>
              <button className="submit-btn" onClick={handleExcluir}>
                Excluir
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}

export default CadastroEmpresas;

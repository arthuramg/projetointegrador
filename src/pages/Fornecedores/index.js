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

function Fornecedores() {
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

  const [fornecedores, setFornecedores] = useState([
    { nome: "Fornecedor A", contato: "fornecedorA@email.com" },
    { nome: "Fornecedor B", contato: "(99) 99999-9999" },
    { nome: "Fornecedor C", contato: "fornecedorC@email.com" },
  ]);

  const [novoFornecedor, setNovoFornecedor] = useState("");
  const [contato, setContato] = useState("");

  const [modalAberto, setModalAberto] = useState(false);
  const [fornecedorParaExcluir, setFornecedorParaExcluir] = useState(null);

  const handleAdicionarFornecedor = () => {
    if (novoFornecedor && contato) {
      setFornecedores([...fornecedores, { nome: novoFornecedor, contato }]);
      setNovoFornecedor("");
      setContato("");
    }
  };

  const handleAbrirModal = (index) => {
    setFornecedorParaExcluir(index);
    setModalAberto(true);
  };

  const handleFecharModal = () => {
    setModalAberto(false);
    setFornecedorParaExcluir(null);
  };

  const handleExcluir = () => {
    const novosFornecedores = fornecedores.filter((_, i) => i !== fornecedorParaExcluir);
    setFornecedores(novosFornecedores);
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
          <li className="menu-item active">
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

      {/* Main */}
      <main className="main">
        <header className="header">
          <h1>CONTROLE DE FORNECEDORES</h1>
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
          {/* Formulário de Novo Fornecedor */}
          <div className="form">
            <h2>ADICIONAR NOVO FORNECEDOR</h2>
            <label>
              <input
                type="text"
                value={novoFornecedor}
                onChange={(e) => setNovoFornecedor(e.target.value)}
                placeholder="Nome do Fornecedor:"
              />
            </label>
            <label>
              <input
                type="text"
                value={contato}
                onChange={(e) => setContato(e.target.value)}
                placeholder="Contato: (Número ou Email)"
              />
            </label>
            <div className="form-actions">
              <button className="cancel-btn" onClick={() => {
                setNovoFornecedor("");
                setContato("");
              }}>
                Cancelar
              </button>
              <button className="submit-btn" onClick={handleAdicionarFornecedor}>
                Adicionar
              </button>
            </div>
          </div>

          {/* Lista de Fornecedores */}
          <div className="table-container">
            <h2>LISTA DE FORNECEDORES</h2>
            <table>
              <thead>
                <tr>
                  <th>Nome do Fornecedor</th>
                  <th>Contato</th>
                  <th>Ações</th>
                </tr>
              </thead>
              <tbody>
                {fornecedores.map((fornecedor, index) => (
                  <tr key={index}>
                    <td>{fornecedor.nome}</td>
                    <td>{fornecedor.contato}</td>
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

      {/* Modal */}
      {modalAberto && (
        <div className="modal-overlay">
          <div className="modal">
            <p>
              Tem certeza que deseja excluir o fornecedor{" "}
              <strong>{fornecedores[fornecedorParaExcluir]?.nome}</strong>?
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

export default Fornecedores;

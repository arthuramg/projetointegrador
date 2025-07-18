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

function CategoriasDeProdutos() {
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

  const [categorias, setCategorias] = useState([
    { nome: "Refrigerantes", quantidade: 43 },
    { nome: "Enlatados", quantidade: 23 },
    { nome: "Pães", quantidade: 32 },
  ]);

  const [novaCategoria, setNovaCategoria] = useState("");
  const [descricao, setDescricao] = useState("");

  const [modalAberto, setModalAberto] = useState(false);
  const [categoriaParaExcluir, setCategoriaParaExcluir] = useState(null);

  const handleAdicionarCategoria = () => {
    if (novaCategoria) {
      setCategorias([...categorias, { nome: novaCategoria, quantidade: 0 }]);
      setNovaCategoria("");
      setDescricao("");
    }
  };

  const handleAbrirModal = (index) => {
    setCategoriaParaExcluir(index);
    setModalAberto(true);
  };

  const handleFecharModal = () => {
    setModalAberto(false);
    setCategoriaParaExcluir(null);
  };

  const handleExcluir = () => {
    const novasCategorias = categorias.filter((_, i) => i !== categoriaParaExcluir);
    setCategorias(novasCategorias);
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
          <li className="menu-item active">
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

      {/* Main */}
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
          {/* Formulário de Nova Categoria */}
          <div className="form">
            <h2>ADICIONAR NOVA CATEGORIA</h2>
            <label>
              <input
                type="text"
                value={novaCategoria}
                onChange={(e) => setNovaCategoria(e.target.value)}
                placeholder="Nome da Categoria"
              />
            </label>
            <div className="form-actions">
              <button className="cancel-btn" onClick={() => setNovaCategoria("")}>
                Cancelar
              </button>
              <button className="submit-btn" onClick={handleAdicionarCategoria}>
                Adicionar
              </button>
            </div>
          </div>

          {/* Lista de Categorias */}
          <div className="table-container">
            <h2>LISTA DE CATEGORIAS</h2>
            <table>
              <thead>
                <tr>
                  <th>Nome da Categoria</th>
                  <th>Número de Produtos</th>
                  <th>Ações</th>
                </tr>
              </thead>
              <tbody>
                {categorias.map((categoria, index) => (
                  <tr key={index}>
                    <td>{categoria.nome}</td>
                    <td>{categoria.quantidade} Produtos</td>
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
              Tem certeza que deseja excluir a categoria{" "}
              <strong>{categorias[categoriaParaExcluir]?.nome}</strong>?
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

export default CategoriasDeProdutos;
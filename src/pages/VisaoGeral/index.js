import React from "react";
import { Link } from "react-router-dom";
import "./index.css";
import IconVisaoGeral from "../icons/VisaoGeral.svg";
import IconEntrada from "../icons/Entrada.svg";
import IconSaida from "../icons/Saida.svg";
import IconCategorias from "../icons/Categorias.svg";
import IconFornecedores from "../icons/Fornecedores.svg";
import IconValidade from "../icons/Validade.svg";

function VisaoGeral() {
  return (
    <div className="app">
      <aside className="sidebar">
        <h2 className="sidebar-title">E-STOCK</h2>
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
            <Link to="/alertasdevalidade" className="menu-link">
              <img src={IconValidade} alt="Alertas de Validade" className="icon" />
              Alertas de Validade
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
            <span className="status-icon" />
          </div>
        </header>
        <section className="table-section">
          <h2>Estoque/Pedidos</h2>
          <table className="data-table">
            <thead>
              <tr>
                <th>ID</th>
                <th>Produto</th>
                <th>Categoria</th>
                <th>Quantidade</th>
                <th>Data de Entrada/Solicitação</th>
                <th>Fornecedor/Cliente</th>
                <th>Status</th>
                <th>Destino</th>
                <th>Ação</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>001</td>
                <td>Pepsi-Cola</td>
                <td>Refrigerantes</td>
                <td>150 UN</td>
                <td>15/10/2024</td>
                <td>Distribuidor X</td>
                <td>Em estoque</td>
                <td>Armazém Central</td>
                <td>
                  <button className="action-btn">Editar</button>
                  <button className="action-btn">Excluir</button>
                </td>
              </tr>
              {/* Adicione outras linhas conforme necessário */}
            </tbody>
          </table>
        </section>
      </main>
    </div>
  );
}

export default VisaoGeral;
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import Login from './pages/Login';
import Cadastro from './pages/Cadastro';
import RecuperacaoConta from './pages/RecuperacaoConta';
import VisaoGeral from './pages/VisaoGeral';
import EntradaDeProdutos from './pages/EntradaDeProdutos';
import SaidaDeProdutos from './pages/SaidaDeProdutos';
import CategoriasDeProdutos from './pages/CategoriasDeProdutos';
import Fornecedores from './pages/Fornecedores';
import CadastroEmpresas from './pages/CadastroEmpresas';

function RoutesApp(){
    return(
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Login />} /> 
                <Route path="/cadastro" element={<Cadastro />} /> 
                <Route path="/recuperacaoconta" element={<RecuperacaoConta/>} /> 
                <Route path="/visaogeral" element={<VisaoGeral />} />
                <Route path="/entradadeprodutos" element={<EntradaDeProdutos />} />
                <Route path="/saidadeprodutos" element={<SaidaDeProdutos />} />
                <Route path="/categoriasdeprodutos" element={<CategoriasDeProdutos />} />
                <Route path="/fornecedores" element={<Fornecedores />} />
                <Route path="/cadastroempresas" element={<CadastroEmpresas />} />


            </Routes>
        </BrowserRouter>
    );
}

export default RoutesApp;
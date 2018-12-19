import React from 'react';
import { Route } from 'react-router-dom';

import Aux from '../../hoc/Aux';
import Funcionarios from '../../components/Funcionarios/Funcionarios';
import Lojas from '../../components/Lojas/Lojas';
import VisitasPorFuncionario from '../../components/Visitas/VisitasPorFuncionario';
import VisitasPorLoja from '../../components/Visitas/VisitasPorLoja';

const localizacao = (props) => (
  <Aux>
    <Route path="/funcionarios" component={ Funcionarios } />
    <Route path="/lojas" component={ Lojas } />
    <Route path="/visitas-por-funcionario" component={ VisitasPorFuncionario } />
    <Route path="/visitas-por-loja" component={ VisitasPorLoja } />
  </Aux>
);

export default localizacao;

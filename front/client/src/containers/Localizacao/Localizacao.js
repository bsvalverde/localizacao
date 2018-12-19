import React from 'react';
import { Route } from 'react-router-dom';

import Aux from '../../hoc/Aux';
import Funcionarios from '../../components/Funcionarios/Funcionarios';
import Lojas from '../../components/Lojas/Lojas';

const localizacao = (props) => (
  <Aux>
    <Route path="/funcionarios" component={ Funcionarios } />
    <Route path="/lojas" component={ Lojas } />
  </Aux>
);

export default localizacao;

import React from 'react';
import { NavLink } from 'react-router-dom';

import classes from './MenuSuperior.module.scss';

const menuSuperior = (props) => (
  <div className={ classes.MenuSuperior }>
    <NavLink to="/funcionarios" className={ classes.Botao } activeClassName={ classes.Ativo }>
      Funcionários
    </NavLink>
    <NavLink to="/lojas" className={ classes.Botao } activeClassName={ classes.Ativo }>
      Lojas
    </NavLink>
  </div>
);

export default menuSuperior;
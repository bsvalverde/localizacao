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
    <NavLink to="/visitas-por-funcionario" className={ classes.Botao } activeClassName={ classes.Ativo }>
      Visitas por Funcionário
    </NavLink>
    <NavLink to="/visitas-por-loja" className={ classes.Botao } activeClassName={ classes.Ativo }>
      Visitas por Loja
    </NavLink>
  </div>
);

export default menuSuperior;
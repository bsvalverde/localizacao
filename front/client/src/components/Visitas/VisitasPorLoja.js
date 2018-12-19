import React, { Component } from 'react';

import classes from './Visitas.module.scss';

import Visita from './Visita';

class VisitasPorLoja extends Component {

  state = {
    funcionarios: [],
    lojas: [],
    funcionarioLoja: []
  }

  componentDidMount() {
    this.getFuncionariosFromDatabase();
    this.getLojasFromDatabase();
    this.getFuncionarioLojaFromDatabase();
  }

  getFuncionariosFromDatabase = () => {
    fetch("/api/getFuncionarios")
      .then(data => data.json())
      .then(res => {
        res.funcionarios.sort((a, b) => { return a.name > b.name });
        this.setState({ funcionarios: res.funcionarios })
      });
  }

  getLojasFromDatabase = () => {
    fetch("/api/getLojas")
      .then(data => data.json())
      .then(res => {
        res.lojas.sort((a, b) => { return a.name > b.name });
        this.setState({ lojas: res.lojas })
      });
}

  getFuncionarioLojaFromDatabase = () => {
    fetch("/api/getFuncionarioLoja")
      .then(data => data.json())
      .then(res => this.setState({ funcionarioLoja: res.funcionario_loja }));
  }

  render() {
    const visitas = this.state.lojas.map((loja) => {
      const funcionarioLoja = this.state.funcionarioLoja.filter(funcionarioLoja => funcionarioLoja.loja_id === loja._id);
      const funcionarioIDs = funcionarioLoja.map((funcionarioLoja) => { return funcionarioLoja.funcionario_id });
      const funcionarios = this.state.funcionarios.filter(funcionario => funcionarioIDs.includes(funcionario._id));
      return <Visita
              key={ loja._id }
              objetoReferencia={ loja }
              objetosProximos={ funcionarios } />
    });
    return (
      <div className={ classes.Visitas }>
        { this.state.funcionarioLoja.length > 0 ? visitas : <p>Nada para mostrar</p> }
      </div>
    );
  }
}

export default VisitasPorLoja;

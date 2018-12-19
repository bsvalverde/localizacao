import React, { Component } from 'react';

import classes from './Visitas.module.scss';

import Visita from './Visita';

class VisitasPorFuncionario extends Component {

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
    const visitas = this.state.funcionarios.map((funcionario) => {
      const funcionarioLoja = this.state.funcionarioLoja.filter(funcionarioLoja => funcionarioLoja.funcionario_id === funcionario._id);
      const lojaIDs = funcionarioLoja.map((funcionarioLoja) => { return funcionarioLoja.loja_id });
      const lojas = this.state.lojas.filter(loja => lojaIDs.includes(loja._id));
      return <Visita
              key={ funcionario._id }
              objetoReferencia={ funcionario }
              objetosProximos={ lojas } />
    });
    return (
      <div className={ classes.Visitas }>
        { this.state.funcionarioLoja.length > 0 ? visitas : <p>Nada para mostrar</p> }
      </div>
    );
  }
}

export default VisitasPorFuncionario;

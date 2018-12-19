import React, { Component } from 'react';

import classes from './Funcionarios.module.scss';

import ObjetoGeografico from '../ObjetoGeografico/ObjetoGeografico';

class Funcionarios extends Component {

  state = {
    funcionarios: []
  }

  componentDidMount() {
    this.getFuncionariosFromDatabase();
  }

  getFuncionariosFromDatabase = () => {
    fetch("/api/getFuncionarios")
      .then(data => data.json())
      .then(res => {
        res.funcionarios.sort((a, b) => { return a.name > b.name });
        this.setState({ funcionarios: res.funcionarios })
      });
  }

  render() {
    const funcionarios = this.state.funcionarios.map((funcionario) => {
      return <ObjetoGeografico
                key={ funcionario._id }
                nome={ funcionario.name }
                latitude={ funcionario.latitude }
                longitude={ funcionario.longitude } />
    });
    return (
      <div className={ classes.Funcionarios }>
        { this.state.funcionarios.length > 0 ? funcionarios : <p>Nada para mostrar</p> }
      </div>
    );
  }
}

export default Funcionarios;

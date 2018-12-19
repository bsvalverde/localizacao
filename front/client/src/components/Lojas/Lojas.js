import React, { Component } from 'react';

import classes from './Lojas.module.scss';

import ObjetoGeografico from '../ObjetoGeografico/ObjetoGeografico';

class Lojas extends Component {

  state = {
    lojas: []
  }

  componentDidMount() {
    this.getLojasFromDatabase();
  }

  getLojasFromDatabase = () => {
    fetch("/api/getLojas")
      .then(data => data.json())
      .then(res => {
        res.lojas.sort((a, b) => { return a.name > b.name });
        this.setState({ lojas: res.lojas })
      });
  }

  render() {
    const lojas = this.state.lojas.map((loja) => {
      return <ObjetoGeografico
                key={ loja._id }
                nome={ loja.name }
                latitude={ loja.latitude }
                longitude={ loja.longitude } />
    });
    return (
      <div className={ classes.Lojas }>
        { this.state.lojas.length > 0 ? lojas : <p>Nada para mostrar</p> }
      </div>
    );
  }
}

export default Lojas;

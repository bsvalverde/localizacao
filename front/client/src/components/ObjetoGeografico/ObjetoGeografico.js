import React from 'react';

import classes from './ObjetoGeografico.module.scss';

const objetoGeografico = (props) => (
  <div className={ classes.Card }>
    <p className={ classes.Nome }>{ props.nome }</p>
    <p><span className={ classes.Subtitulo }>Latitude:</span> {props.latitude}°</p>
    <p><span className={ classes.Subtitulo }>Longitude:</span> {props.longitude}°</p>
  </div>
);

export default objetoGeografico;

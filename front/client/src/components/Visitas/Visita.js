import React from 'react';

import classes from './Visita.module.scss';

const visita = (props) => {
  const objetosProximos = props.objetosProximos.map((objeto) => {
    return <li>{ objeto.name }</li>;
  });
  return (
    <div className={ classes.Card }>
      <p className={ classes.Nome }>{ props.objetoReferencia.name }</p>
      <ul>
        { objetosProximos }
      </ul>
    </div>
    );
}

export default visita;

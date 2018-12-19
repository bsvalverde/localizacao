import React from 'react';

import Aux from '../../hoc/Aux';
import MenuSuperior from '../MenuSuperior/MenuSuperior';

const layout = (props) => (
  <Aux>
    <MenuSuperior />
    <main>
      { props.children }
    </main>
  </Aux>
);

export default layout;

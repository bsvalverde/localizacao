import React from 'react';
import { BrowserRouter as Router } from 'react-router-dom';

import './App.scss'

import Layout from './components/Layout/Layout';
import Localizacao from './containers/Localizacao/Localizacao';

const app = (props) => (
  <Router>
    <Layout>
      <Localizacao />
    </Layout>
  </Router>
);

export default app;

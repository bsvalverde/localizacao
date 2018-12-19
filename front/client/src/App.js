import React, { Component } from 'react';

class App extends Component {

  state = {
    msg: "not yet"
  }

  // componentDidMount() {
  //   this.getDataFromDatabase();
  // }

  getDataFromDatabase = () => {
    fetch("/api/get")
      .then(data => data.json())
      .then(res => this.setState({ msg: res.msg }))
  }

  render() {
    return (
      <div>
        Here we go!
        <p>{ this.state.msg }</p>
        <button onClick={ this.getDataFromDatabase }>Fetch</button>
      </div>
    );
  }
}

export default App;

import React, { Component } from 'react';
import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import KardexPage from './components/kardex/KardexPage';
import RegisterPage from './components/register/RegisterPage';
import { BrowserRouter as Router, Switch, Route  } from 'react-router-dom';


class App extends Component {
  constructor() {
    super();
    this.state = {
      registers: []
    }
  }

  render() {
    return (
      
        <Router >
          <div className="container">
            
            <Switch>
              <Route path='/' exact component={KardexPage} />              
              <Route path='/kardex/:id' exact component={RegisterPage} />
            </Switch>
          </div>
        </Router>
     
    );
  }
}
export default App;

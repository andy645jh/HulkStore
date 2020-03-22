import React, { Component } from 'react';
import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import KardexPage from './components/kardex/KardexPage';
import RegisterPage from './components/register/RegisterPage';
import HomePage from './components/home/HomePage';
import { BrowserRouter as Router, NavLink, Switch, Route } from 'react-router-dom';
import ErrorPage from './components/errors/ErrorPage';


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
          <div className="row">
            <div className="col menu">
              <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
                <a className="navbar-brand" href="/">Hulk Store</a>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                  <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarNav">
                  <ul className="navbar-nav">
                    <li className="nav-item active">
                      <NavLink exact activeClassName="current" className="nav-link" to="/">Inicio <span className="sr-only">(current)</span></NavLink>
                    </li>
                    <li className="nav-item">
                      <NavLink exact activeClassName="current" className="nav-link" to="/kardex">Productos</NavLink>
                    </li>
                    <li className="nav-item">                    
                      <a className="nav-link" href="#">Vender</a>
                    </li>
                  </ul>
                </div>               
              </nav>
            </div>
          </div>
          <Switch>
            <Route path='/' exact component={HomePage} />
            <Route path='/kardex/:id' exact component={RegisterPage} />
            <Route path='/kardex' exact component={KardexPage} />
            <Route path='/error' exact component={ErrorPage} />
          </Switch>
        </div>
      </Router>

    );
  }
}
export default App;

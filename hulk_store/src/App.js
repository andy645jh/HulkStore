import React, { Component } from 'react';
import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import Table from './Table';
import Form from './components/Form';
import RegisterService from './services/RegisterService';

class App extends Component 
{
  constructor()
  {
    super();
    this.state = {
      registers:[]
    }
    this.services = new RegisterService();

  }

  componentDidMount() {
    this.getAllRegisters();
  }

  getAllRegisters() {
    this.services.getAlldRegister().then(registers => {
      console.log("Registers:", registers); 
      this.setState({ isLoading: false, registers: registers });
    });
  }

  createRegister(register) {
    console.log("CreateRegister:", register);    
    this.services.createRegister(register, 1).then((result) => {
      
      console.log("CreateRegisterResult:", result);
      if(result)
      {        
        /*this.setState({...this.state, fields:{
          firstname:'',
          lastname:''
        }});*/
        this.getAllRegisters();
        return true;
      }else{
        return false;
      }
      
    });
  }

  render()
  {
    const registers = this.state.registers;    
    const lastRegister = registers[registers.length-1];
    console.log("Last Register: ", lastRegister);
    return (
      <>
      { (registers!=null) && 
        <div className="container">
          <Form lastRegister={lastRegister} create={(p) => this.createRegister(p)}/>
          <Table registers={this.state.registers} />
        </div>
      }
      </>
    );
  }
  
}

export default App;

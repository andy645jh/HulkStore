import React, { Component } from 'react';
import RegisterForm from './RegisterForm';
import RegisterService from '../../services/RegisterService';
import RegisterList from './RegisterList';

class RegisterPage extends Component 
{
  constructor(props)
  {
    super(props);
    this.state = {
      registers:[],
      kardex:{}
    }
    this.services = new RegisterService();
    this.id = props.match.params.id;
    console.log("Param: ", this.id );
  }

  componentDidMount() {
    this.getAllRegisters();
  }

  getAllRegisters() {
    this.services.getAlldRegister().then(registers => {
      console.log("Registers 0:", registers[0].darkex);       
      this.setState({ isLoading: false, registers: registers, kardex: registers[0].darkex });
    });
  }

  createRegister(register) {
    console.log("CreateRegister:", register);    
    this.services.createRegister(register, this.id).then((result) => {
      
      console.log("CreateRegisterResult:", result);
      if(result)
      {   
        this.getAllRegisters();
        return true;
      }else{
        return false;
      }
      
    });
  }

  render()
  {
    const { kardex, registers } = this.state;    
    const lastRegister = registers[registers.length-1];
    console.log("Last Register: ", this.state);
    return (
      <>
      { (registers!=null) && 
        <div className="container">   
          <div className="container"><h2>{kardex.productName}</h2></div>             
          <RegisterForm lastRegister={lastRegister} create={(p) => this.createRegister(p)}/>
          <RegisterList registers={this.state.registers} /> 
        </div>
      }
      </>
    );
  }
  
}

export default RegisterPage;
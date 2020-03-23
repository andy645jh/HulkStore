import React, { Component } from 'react';
import RegisterForm from './RegisterForm';
import RegisterService from '../../services/RegisterService';
import RegisterList from './RegisterList';
import Tittle from '../general/Tittle';

class RegisterPage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      registers: [],
      kardex: {}
    }
    this.services = new RegisterService();
    this.id = props.match.params.id;
    console.log("Param: ", this.id);
  }

  componentDidMount() {
    this.getAllRegisters();
  }

  getAllRegisters() {
    this.services.getdRegisterBy(this.id).then(registers => {
      console.log("Registers 0:", registers[0].darkex);
      if (registers.length <= 0) {
        this.props.history.push('/error');
      }
      this.setState({ isLoading: false, registers: registers, kardex: registers[0].darkex });
    });
  }

  createRegister(register) {
    console.log("CreateRegister:", register);
    this.services.createRegister(register, this.id).then((result) => {

      console.log("CreateRegisterResult:", result);
      if (result) {
        this.getAllRegisters();
        return true;
      } else {
        return false;
      }

    });
  }

  render() {
    const { kardex, registers } = this.state;
    const lastRegister = registers[registers.length - 1];
    console.log("Last Register: ", lastRegister);
    return (
      <>
        {(lastRegister != null) &&
          <div className="container">
            <Tittle tittle={kardex.productName} />
            <RegisterForm lastRegister={lastRegister} create={(p) => this.createRegister(p)} />
            <div className="mt-5">
              <RegisterList registers={this.state.registers} />
            </div>
          </div>
        }
      </>
    );
  }

}

export default RegisterPage;
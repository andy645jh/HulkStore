import React, { Component } from 'react';
import RegisterServices from '../../services/RegisterService';

class RegisterList extends Component {
    constructor() {
        super();
        this.state = {
            isLoading: false,            
            registers: []
          };

        this.regServices = new RegisterServices();
    }   

    render() {
        const registers = this.props.registers;

        return (
            <div className="container">
            <h2>REGISTROS</h2>
            <table className="table table-bordered text-center">
                <thead>
                    <tr>
                        <th rowSpan="2" scope="col">#</th>
                        <th rowSpan="2" scope="col">Fecha</th>
                        <th rowSpan="2" scope="col">Descripcion</th>
                        <th rowSpan="2" scope="col">Vlr Unit</th>
                        <th colSpan="2" scope="col">Entrada</th>
                        <th colSpan="2" scope="col">Salida</th>
                        <th colSpan="2" scope="col">Saldo</th>                       
                    </tr>
                    <tr>                        
                        <th scope="col">Cant</th>
                        <th scope="col">Valor</th>
                        <th scope="col">Cant</th>
                        <th scope="col">Valor</th>
                        <th scope="col">Cant</th>
                        <th scope="col">Valor</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        (registers!=null) &&
                        registers.map((reg) => 
                        <tr key={reg.id}>                        
                            <td>{reg.id}</td>                                                     
                            <td>{reg.date}</td>
                            <td>{reg.description}</td>  
                            <td>{reg.unitVal}</td>
                            <td>{reg.cantEntrada}</td>
                            <td>{reg.valEntrada}</td>
                            <td>{reg.cantSalida}</td>
                            <td>{reg.valSalida}</td>
                            <td>{reg.cantSaldo}</td>
                            <td>{reg.valSaldo}</td>
                        </tr>)
                    }
                    
                </tbody>
            </table>
            </div>
        );
    }
}

export default RegisterList;
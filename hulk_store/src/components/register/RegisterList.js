import React, { Component } from 'react';
import RegisterServices from '../../services/RegisterService';
import dateFormat from 'dateformat';
import {IntlProvider,FormattedNumber} from 'react-intl';

class RegisterList extends Component {
    constructor() {
        super();
        this.state = {
            isLoading: false,
            registers: []
        };

        this.regServices = new RegisterServices();
        var dat = dateFormat(new Date(), "yyyy-mm-dd");
        console.log("Date : "+dat);
    }

    formatVal(operation, val, esEntrada)
    {
        
        console.log("OPer: "+operation);
        switch(operation)
        {
            case 3:
                return esEntrada ? '-'+val: val;
            case 4:
                return !esEntrada ? '-'+val: val;

            default:
                return val;
        }        
    }

    render() {
        const registers = this.props.registers;

        return (
            <div className="container">                
                <table className="table table-bordered text-center">
                    <thead className="bg-thead">
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
                            (registers != null) &&
                            registers.map((reg) =>
                                <tr key={reg.id}>
                                    <td>{reg.id}</td>
                                    <td>{dateFormat(reg.date, "dd-mm-yyyy")}</td>
                                    <td>{reg.description}</td>
                                    <td><FormattedNumber value={reg.unitVal} style="currency"/></td>
                                    <td>{ this.formatVal(reg.operation, reg.cantEntrada, true)}</td>
                                    <td>{ this.formatVal(reg.operation, reg.valEntrada, true)}</td>
                                    <td>{ this.formatVal(reg.operation, reg.cantSalida)}</td>
                                    <td>{ this.formatVal(reg.operation, reg.valSalida)}</td>
                                    <td>{reg.cantSaldo}</td>
                                    <td>{reg.valSaldo}</td>
                                </tr>
                            )
                        }

                    </tbody>
                </table>
            </div>
        );
    }
}

export default RegisterList;
import React, { Component } from 'react';

class RegisterForm extends Component {

    constructor(props) {
        super(props);
        console.log("Props: ", props);
    }

    onClickAdd(e) {
        e.preventDefault();

        const register = {
            description: this.refs.description.value,
            unitVal: this.refs.unitVal.value,
            cantEntrada: 0,
            cantSalida: 0,
            date: new Date(),
            operation: this.refs.operation.value
        }


        switch (this.refs.operation.value) {
            case '1':
            case '3':
                console.log("Valor Compra: ", this.refs.cantidad.value);
                register.cantEntrada = this.refs.cantidad.value;
                break;

            case '2':
            case '4':
                console.log("Valor Venta: ", this.refs.cantidad.value);
                register.cantSalida = this.refs.cantidad.value;
                break;

            default:
                console.log("No entro a ninguna: ", this.refs.operation.value);
                break;
        }

        //create register
        this.props.create(register);


        this.refs.description.value = '';
        this.refs.unitVal.value = '';
        this.refs.cantidad.value = '';
    }

    render() {
        return (
            <div className="container">
                <h2>AGREGAR REGISTRO</h2>
                <form className="form-row mt-3 mb-3">

                    <div className="d-sm-inline d-xs-block">
                        <select id="tipoOperacion" ref="operation" className="form-control">
                            <option value="1">Compra</option>
                            <option value="2">Venta</option>
                            <option value="3">Devolucion Compra</option>
                            <option value="4">Devolucion Venta</option>
                        </select>
                    </div>

                    <div className="d-sm-inline d-xs-block">
                        <input type="text" className="form-control" ref="description" placeholder="Descripcion" />
                    </div>

                    <div className="d-sm-inline d-xs-block">
                        <input type="number" className="form-control" ref="unitVal" placeholder="Valor Unitario" />
                    </div>

                    <div className="d-sm-inline d-xs-block">
                        <input type="number" className="form-control" ref="cantidad" placeholder="Cantidad" />
                    </div>

                    <button onClick={(e) => this.onClickAdd(e)} type="button" className="btn btn-primary">Agregar</button>
                </form>
            </div>
        );
    }
}
export default RegisterForm;
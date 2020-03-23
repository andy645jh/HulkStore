import React, { Component } from 'react';
import * as Icon from 'react-bootstrap-icons';


class RegisterForm extends Component {

    constructor(props) {
        super(props);
        this.state = {
            errors: {
                description: '',
                unitVal: '',
                cantidad: ''
            }
        }
        console.log("Props ", props);
    }
    onClickAdd(e) {
        e.preventDefault();

        if (!this.isValid()) return;

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

        this.setErrors('');
    }

    setErrors(val) {
        var errors = { ...this.state.errors };
        errors.description = val;
        errors.unitVal = val;
        errors.cantidad = val;
        this.setState({ errors: errors });
    }
    
    isValid() {
        var isGood = true;

        //se hace directo porq el setErrors 
        //requiere de un tiempo para llamar el render
        var errors = { ...this.state.errors };
        errors.description = 'is-valid';
        errors.unitVal = 'is-valid';
        errors.cantidad = 'is-valid';

        if (this.refs.description.value === '') {
            errors.description = 'is-invalid';
            isGood = false;
        }

        if (this.refs.unitVal.value === '' || this.refs.unitVal.value === '0') {
            errors.unitVal = 'is-invalid';
            isGood = false;
        }

        const maxProductos = this.props.lastRegister.cantSaldo;
        const cant = parseInt(this.refs.cantidad.value);
        console.log("Cant: "+cant);
        if (this.refs.cantidad.value==='' || cant<=0 || cant>maxProductos) {           
            
            errors.cantidad = 'is-invalid';
            isGood = false;
        }

        
        this.setState({ errors: errors });
        return isGood;
    }

    render() {
        const maxProductos = this.props.lastRegister.cantSaldo;
        console.log("Max Productos ", maxProductos);

        return (
            <div className="container">
                <form className="form-row mt-3 mb-3 d-flex justify-content-around">
                    <div className="col-7">
                        <div className="row">
                            <div className="col-6">
                                <select id="tipoOperacion" ref="operation" className="form-control">
                                    <option value="1">Compra</option>
                                    <option value="2">Venta</option>
                                    <option value="3">Devolucion Compra</option>
                                    <option value="4">Devolucion Venta</option>
                                </select>
                            </div>

                            <div className="col-6">
                                <div className="form-group">
                                    <input type="text-area" className={"form-control " + this.state.errors.description} ref="description" placeholder="Descripcion" required />
                                    <div className="invalid-feedback">Campo requerido*</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="col-5">
                        <div className="row">
                            <div className="col-4">
                                <div className="form-group">
                                    <input type="number" className={"form-control " + this.state.errors.unitVal} ref="unitVal" placeholder="Valor Unitario" required />
                                    <div className="invalid-feedback">Campo requerido*</div>
                                </div>
                            </div>

                            <div className="col-4">
                                <div className="form-group">
                                    <input type="number" className={"form-control " + this.state.errors.cantidad} ref="cantidad" max={maxProductos} placeholder="Cantidad" required />
                                    <div className="invalid-feedback">Cantidad incorrecta*</div>
                                </div>
                            </div>

                            <button onClick={(e) => this.onClickAdd(e)} type="button" className="btn btn-primary fit">
                                <span className="btn-span"><Icon.Plus /></span>Agregar
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        );
    }
}
export default RegisterForm;
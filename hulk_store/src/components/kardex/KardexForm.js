import React, { Component } from 'react';
import * as Icon from 'react-bootstrap-icons';

class KardexForm extends Component {
    constructor(props)
    {
        super(props);
        this.state = {
            errors: {                
                product:'',
                proveedores:'',
                description: '',
                unitVal: '',
                cantidad: ''
            }
        }
    }

    onClickAdd(e) {
        e.preventDefault();

        if(!this.isValid()) return;

        const kardex = {
            productName: this.refs.product.value,
            proveedores: this.refs.proveedores.value
        };

        const register = {
            description: this.refs.description.value,
            unitVal: this.refs.unitVal.value,
            cantEntrada: this.refs.cantidad.value,
            date: new Date(),
            operation: 1
        }

        //create kardex
        this.props.create(kardex, register);

        this.refs.description.value = '';
        this.refs.unitVal.value = '';
        this.refs.cantidad.value = '';
        this.refs.product.value = '';
        this.refs.proveedores.value = '';

        this.setErrors('');
    }

    setErrors(val) {
        var errors = { ...this.state.errors };
        errors.product = val;
        errors.proveedores = val;
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
        errors.product = 'is-valid';
        errors.proveedores = 'is-valid';
        errors.description = 'is-valid';
        errors.unitVal = 'is-valid';
        errors.cantidad = 'is-valid';

        if (this.refs.product.value === '') {
            errors.product = 'is-invalid';
            isGood = false;
        }

        if (this.refs.proveedores.value === '') {
            errors.proveedores = 'is-invalid';
            isGood = false;
        }

        if (this.refs.description.value === '') {
            errors.description = 'is-invalid';
            isGood = false;
        }

        if (this.refs.unitVal.value === '' || this.refs.unitVal.value === '0') {
            errors.unitVal = 'is-invalid';
            isGood = false;
        }

        if (this.refs.cantidad.value === '' || this.refs.cantidad.value === '0') {
            errors.cantidad = 'is-invalid';
            isGood = false;
        }

        this.setState({ errors: errors });
        return isGood;
    }

    render() {
        const errors = this.state.errors;
        return (
            <div className="container border">
                <h5 className="my-3">REGISTRAR PRODUCTO</h5>
                <form className="form-group mt-3 mb-3">
                    <div className="form-row mt-2">
                        <div className="col">
                            <div className="form-group">
                                <input type="text" className={"form-control "+errors.product} ref="product" placeholder="Producto" required />
                                <div className="invalid-feedback">Campo requerido*</div>
                            </div>
                        </div>

                        <div className="col">
                            <div className="form-group">
                                <input type="text" className={"form-control "+errors.proveedores} ref="proveedores" placeholder="Proveedores" required />
                                <div className="invalid-feedback">Campo requerido*</div>
                            </div>
                        </div>
                    </div>

                    <div className="form-row mt-2">
                        <div className="col">
                            <div className="form-group">
                                <input type="text-area" className={"form-control "+errors.description} ref="description" placeholder="Descripcion" required />
                                <div className="invalid-feedback">Campo requerido*</div>
                            </div>
                        </div>

                        <div className="col">
                            <div className="row">
                                <div className="col">
                                    <div className="form-group">
                                        <input type="number" className={"form-control "+errors.unitVal} ref="unitVal" placeholder="Valor Unitario" required />
                                        <div className="invalid-feedback">Valor Incorrecto*</div>
                                    </div>
                                </div>
                                <div className="col">
                                    <div className="form-group">
                                        <input type="number" className={"form-control "+errors.cantidad} ref="cantidad" placeholder="Cantidad" required />
                                        <div className="invalid-feedback">Valor Incorrecto*</div>
                                    </div>
                                </div>
                                <div className="col">
                                    <button onClick={(e) => this.onClickAdd(e)} type="button" className="btn btn-primary w-100">
                                        <Icon.Plus size={25} />Agregar
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        );
    }
}
export default KardexForm;
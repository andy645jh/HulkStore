import React, { Component } from 'react';
import * as Icon from 'react-bootstrap-icons';

class KardexForm extends Component {

    onClickAdd(e) {
        e.preventDefault();
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

        //create register
        this.props.create(kardex, register);


        this.refs.description.value = '';
        this.refs.unitVal.value = '';
        this.refs.cantidad.value = '';
        this.refs.product.value = '';
        this.refs.proveedores.value = '';
    }

    render() {
        return (
            <div className="container border">
                <h5 className="my-3">REGISTRAR PRODUCTO</h5>
                <form className="form-group mt-3 mb-3">
                    <div className="form-row mt-2">
                        <div className="col">
                            <input type="text" className="form-control" ref="product" placeholder="Producto" />
                        </div>

                        <div className="col">
                            <input type="text" className="form-control" ref="proveedores" placeholder="Proveedores" />
                        </div>
                    </div>

                    <div className="form-row mt-2">
                        <div className="col">
                            <input type="text-area" className="form-control" ref="description" placeholder="Descripcion" />
                        </div>

                        <div className="col">
                            <div className="row">
                                <div className="col">
                                    <input type="number" className="form-control" ref="unitVal" placeholder="Valor Unitario" />
                                </div>
                                <div className="col">
                                    <input type="number" className="form-control" ref="cantidad" placeholder="Cantidad" />
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
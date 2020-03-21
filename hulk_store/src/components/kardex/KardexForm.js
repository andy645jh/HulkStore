import React, { Component } from 'react';

class KardexForm extends Component {

    constructor(props)
    {
        super(props);           
    }

    onClickAdd(e) {
        e.preventDefault();
        const kardex = {
            productName:this.refs.product.value,
            proveedores:this.refs.proveedores.value
        };

        const register = {
            description: this.refs.description.value,
            unitVal: this.refs.unitVal.value,
            cantEntrada: this.refs.cantidad.value,            
            date: new Date(),
            operation: 1
        }

        //create register
        this.props.create(kardex,register);


        this.refs.description.value = '';
        this.refs.unitVal.value = '';
        this.refs.cantidad.value = '';
        this.refs.product.value = '';
        this.refs.proveedores.value = '';
    }

    render() {
        return (
            <div className="container">
                <h2>NUEVO KARDEX</h2>
                <form className="form-row mt-3 mb-3">
                    
                    <div className="d-sm-inline d-xs-block">                       
                        <input type="text" className="form-control" ref="product" placeholder="Producto"/>
                    </div>

                    <div className="d-sm-inline d-xs-block">                       
                        <input type="text" className="form-control" ref="proveedores" placeholder="Proveedores"/>
                    </div>

                    <div className="d-sm-inline d-xs-block">                       
                        <input type="text" className="form-control" ref="description" placeholder="Descripcion"/>
                    </div>

                    <div className="d-sm-inline d-xs-block">                       
                        <input type="number" className="form-control" ref="unitVal" placeholder="Valor Unitario"/>
                    </div>

                    <div className="d-sm-inline d-xs-block">                    
                        <input type="number" className="form-control" ref="cantidad" placeholder="Cantidad"/>
                    </div>

                    <button onClick={(e) => this.onClickAdd(e)} type="button" className="btn btn-primary">Agregar</button>
                </form>
            </div>
        );
    }
}
export default KardexForm;
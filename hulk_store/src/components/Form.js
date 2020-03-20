import React, { Component } from 'react';

class Form extends Component {

    constructor(props)
    {
        super(props);   
        console.log("Props: ",props);
    }
    
    onClickAdd(e) {
        e.preventDefault();

        const register = {
            description: this.refs.description.value,
            unitVal: this.refs.unitVal.value,
            cantEntrada: this.refs.cantEntrada.value,
            date: new Date(),
            operation: this.refs.operation.value
        }
        
        
        this.props.create(register);
        

        this.refs.description.value = '';
        this.refs.unitVal.value = '';
        this.refs.cantEntrada.value = '';
    }    

    render() {
        return (
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
                    <input type="text" className="form-control" ref="description" placeholder="Descripcion"/>
                </div>

                <div className="d-sm-inline d-xs-block">                       
                    <input type="number" className="form-control" ref="unitVal" placeholder="Valor Unitario"/>
                </div>

                 <div className="d-sm-inline d-xs-block">                    
                    <input type="number" className="form-control" ref="cantEntrada" placeholder="Cantidad"/>
                </div>

                <button onClick={(e) => this.onClickAdd(e)} type="button" className="btn btn-primary">Agregar</button>
            </form>
        );
    }
}
export default Form;
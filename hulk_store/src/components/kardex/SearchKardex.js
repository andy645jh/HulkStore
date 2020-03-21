import React, { Component } from 'react';
import ServiceKardex from '../../services/KardexService';

class SearchKardex extends Component {

    constructor(props)
    {
        super(props);   
        this.serviceKardex = new ServiceKardex();        
    }

    onClickSearch(e)
    {
        e.preventDefault();       

        //create register
        this.props.search(this.refs.word.value);
        this.refs.word.value = '';       
    }

    render() {
        return (
            <div className="container">
                <h2>BUSCAR PRODUCTO</h2>
                <form className="form-row mt-3 mb-3">
                    
                    <div className="d-sm-inline d-xs-block">                       
                        <input type="text" className="form-control" ref="word" placeholder="Ingresa una palabra"/>
                    </div>

                    <button onClick={(e) => this.onClickSearch(e)} type="button" className="btn btn-primary">Search</button>
                </form>
            </div>
        );
    }
}
export default SearchKardex;
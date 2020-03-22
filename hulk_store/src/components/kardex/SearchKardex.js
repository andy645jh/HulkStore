import React, { Component } from 'react';
import ServiceKardex from '../../services/KardexService';
import * as Icon from 'react-bootstrap-icons';

class SearchKardex extends Component {

    constructor(props) {
        super(props);
        this.serviceKardex = new ServiceKardex();
    }

    onClickSearch(e) {
        e.preventDefault();

        //create register
        this.props.search(this.refs.word.value);
        this.refs.word.value = '';
    }

    onChange(e) {
        e.preventDefault();
        console.log("Event: ", e);
    }

    render() {
        return (
            <div className="container bg-light">
                <div className="col">
                    <div className="row align-items-center">
                        <div className="col">
                            <h2 className="row">LISTADO DE PRODUCTOS</h2>
                        </div>
                        <div className="col d-flex justify-content-end">
                            <form className="form-row m-2 mb-4">

                                <div className="d-sm-inline d-xs-block mx-1">
                                    <input type="text" className="form-control" ref="word" placeholder="Ingresa el producto" onChange={(e) => this.onChange(e)} />
                                </div>
                                
                                <button onClick={(e) => this.onClickSearch(e)} type="button" className="btn btn-primary mx-1">
                                    <Icon.Search />
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}
export default SearchKardex;
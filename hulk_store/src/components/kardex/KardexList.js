import React, { Component } from 'react';
import {BrowserRouter as Router, Link, Route} from 'react-router-dom';

class KardexList extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        const darkexList = this.props.darkexList;
        return (
            <div className="container">
                <div>
                    <h2 className="row">LISTA KARDEX</h2>
                    <div className="row">
                        <div className="col">
                            {
                                (darkexList != null) &&
                                darkexList.map((darkex) =>
                                    <div className="row my-3" key={darkex.id}>
                                        <div className="col">{darkex.productName}</div>
                                        <div className="col">{darkex.proveedores}</div>
                                        <div className="col">
                                            <Link className="btn btn-primary" to={"/kardex/"+darkex.id}>Detalle</Link>                                           
                                        </div>
                                    </div>
                                )
                            }
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}
export default KardexList;
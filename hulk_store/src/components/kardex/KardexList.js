import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import * as Icon from 'react-bootstrap-icons';

class KardexList extends Component {

    delete(e, id) {
        e.preventDefault();
        console.log("Delete: " + id);
        this.props.delete(id);
    }

    render() {
        const darkexList = this.props.darkexList;
        return (
            <div className="container">
                <table className="table table-bordered text-center">
                    <thead>
                        <tr>
                            <th rowSpan="2" scope="col">Producto</th>
                            <th rowSpan="2" scope="col">Proveedores</th>
                            <th rowSpan="2" scope="col">Opciones</th>
                        </tr>
                    </thead>
                    <tbody>

                        {
                            (darkexList != null) &&
                            darkexList.map((darkex) =>
                                <tr className="align-items-center" key={darkex.id}>
                                    <td>{darkex.productName}</td>
                                    <td>{darkex.proveedores}</td>
                                    <td>
                                        <Link className="btn btn-primary mx-1" to={"/kardex/" + darkex.id}>
                                            <Icon.EyeFill />
                                        </Link>
                                        <button className="btn btn-warning mx-1" onClick={(e) => this.delete(e, darkex.id)}>
                                            <Icon.TrashFill />
                                        </button>
                                    </td>
                                </tr>
                            )
                        }

                    </tbody>
                </table>

            </div>
        );
    }
}
export default KardexList;
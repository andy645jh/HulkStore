import React, { Component } from 'react';
import KardexForm from './KardexForm';
import KardexList from './KardexList';
import SearchKardex from './SearchKardex';
import RegisterService from '../../services/RegisterService';
import KardexService from '../../services/KardexService';

class KardexPage extends Component {

    constructor(props) {
        super(props);
        this.state = {
            darkexList: []
        }

        this.regServices = new RegisterService();
        this.kardexServices = new KardexService();
    }

    componentDidMount() {
        this.getAllKardex();
    }

    getAllKardex() {
        this.kardexServices.getAllKardex().then(kardexList => {
            console.log("darkex:", kardexList);
            this.setState({ isLoading: false, darkexList: kardexList });
        });
    }

    createKardex(kardex,register) {
        console.log("createKardex:", kardex);
        this.kardexServices.createKardex(kardex).then((result) => {

            console.log("createKardexResult:", result);
            if (result) {
                this.regServices.createRegister(register, result.id).then((res) => {
                    console.log("RegisterResult:", res);
                    this.getAllKardex();
                });              
                
                return true;
            } else {
                return false;
            }

        });
    }

    searchKardex(word) {
        console.log("searchKardex:", word);
        this.kardexServices.searchKardex(word).then((result) => {

            console.log("searchKardexResult:", result);
            if (result) {
                this.setState({ isLoading: false, darkexList: result });           
                
                return true;
            } else {
                return false;
            }

        });
    }

    render() {
        return (
            <>
                <SearchKardex search={(w)=> this.searchKardex(w)} />
                <KardexForm create={(k,r) => this.createKardex(k,r)}/>
                <KardexList darkexList={this.state.darkexList} />
            </>
        );
    }
}
export default KardexPage;
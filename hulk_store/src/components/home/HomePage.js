import React from 'react';

function HomePage() {
    return (
        <div className="container pt-3">
            <h1>Hulk Store</h1>
            <br></br>
            <h4>BIENVENIDOS,</h4>
            <br></br>
            <div className="text-justify">
                <p>Les contaré un poco acerca, este sistema permite el registro de productos basados en el Sistema Kardex de Promedio Ponderado, en la seccion de productos se podrá realizar el registro de cada productos, el cual nos permite crear productos, eliminar y visualizar el kardex del producto seleccionado.</p>
                <br></br>
                <p>Al entrar en la opción de kardex para cada producto podremos registrar procesos como compra, venta, devolucion de la compra y devolucion de la venta.</p>
                <br></br>
                <p>El sistema calculará internamente y mostrará los resultados en una tabla que contiene todos los movimientos del kardex.</p>
                <br></br>
                <p>Muchas gracias.</p>
            </div>
        </div>
    );
}

export default HomePage;
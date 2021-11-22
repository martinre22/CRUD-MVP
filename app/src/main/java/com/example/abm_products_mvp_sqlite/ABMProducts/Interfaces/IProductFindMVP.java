package com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces;

import com.example.abm_products_mvp_sqlite.pojo.Product;

/**
 * Interfaz MVP de Consulta Product.
 * Contiene acceso a otras interfaces utilizadas para controlar la vista de consulta de producto
 * y el acceso a datos.
 * @version 21/21/2021
 */
public interface IProductFindMVP {

    /**
     * Interfaz utilizado que controla funciones de la vista Consulta Producto.
     */
    interface view{

        /**
         * Metodo que devuelve codigo de producto ingresado.
         * @return dato de de tipo String utilizado para consultar producto en repositorio.
         */
        String getCodeProduct();

        /**
         * Metodo que devuelve la informacion de producto consultado en repositorio.
         * @param dataProduct dato de tipo String formateado con informacion del producto consultado.
         */
        void showProductInfo(String dataProduct);

        /**
         * Metodo que indica error cuando no se introduce un codigo de producto.
         */
        void showErrorCodeProductEmptyField();
    }

    /**
     * Interfaz que controla funciones de la capa de presentacion.
     */
    interface presenter{
        /**
         * Metodo que controla la accion del button Consulta Producto
         */
        void buttonFindProductViewClicked();
    }

    /**
     * Interfaz que controla funciones de la capa de modelo.
     */
    interface model{
        /**
         * Metodo que devuelve informacion del producto consultado.
         * @param codeProduct codigo de producto a consultar.
         * @return dato de tipo String formateado con informacion del producto consultado.
         */
        String existsProduct(String codeProduct);
    }
}

package com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces;

/**
 * Interfaz MVP de Menu Product
 * Contiene acceso a otras interfaces utilizadas para controlar la vista y el acceso a datos
 * @version 21/21/2021
 */
public interface IMenuProductMVP {

    /**
     * Interfaz utilizado que controla funciones de la vista
     */
    interface view{
        /**
         * Metodo que dirige al activity registro de productos
         */
        void toActivityNewProductRegister();
        /**
         * Metodo que dirige al activity actualizacion de productos
         */
        void toActivityUpdateProduct();
        /**
         * Metodo que dirige al activity consulta de productos
         */
        void toActivityFindProduct();
        /**
         * Metodo que dirige al activity list de productos
         */
        void toActivityListProduct();
    }

    /**
     * Interfaz que controla funciones de la capa de presentacion
     */
    interface presenter{
        /**
         * Metodo que controla accion del button Register
         */
        void buttonRegisterProductClicked();
        /**
         * Metodo que controla accion del button Update
         */
        void buttonUpdateProductClicked();
        /**
         * Metodo que controla accion del button Find
         */
        void buttonFindProductClicked();
        /**
         * Metodo que controla accion del button List
         */
        void buttonListProductClicked();
    }

    /**
     * Interfaz model
     * sin funcion en version actual
     */
    interface model{}
}

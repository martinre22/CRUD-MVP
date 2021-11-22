package com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces;

/**
 * Interfaz MVP de Registro de  Productos.
 * Contiene acceso a otras interfaces utilizadas para controlar la vista de registro de productos
 * y el acceso a datos.
 * @version 21/21/2021
 */
public interface IProductRegisterMVP {
    /**
     * Interfaz utilizado que controla funciones de la vista Registro de Productos.
     */
    interface view{
        /**
         * Metodo que obtiene datos de descripcion de producto de la vista.
         * @return tipo String con datos de la descripcion de producto.
         */
        String getProductDescription();

        /**
         * Metodo que obtiene datos de codigo de barra de producto de la vista.
         * @return tipo String con datos de codigo de barra de producto.
         */
        String getProductBarcode();

        /**
         * Metodo que obtiene datos del codigo de producto de la vista.
         * @return tipo String con datos de codigo de producto.
         */
        String getProductCode();

        /**
         * Metodo que obtiene datos altura de producto de la vista.
         * @return tipo String con datos de altura de producto.
         */
        String getProductHeight();

        /**
         * Metodo que obtiene datos de paquetes por base de producto de la vista.
         * @return tipo String con datos de la descripcion de producto.
         */
        String getProductPackagePerBase();


        /**
         * Metodo que informa error de campo vacio.
         */
        void showErrorProductDescriptionEmptyField();
        /**
         * Metodo que informa error de campo vacio.
         */
        void showErrorProductCodeEmptyField();
        /**
         * Metodo que informa error de campo vacio.
         */
        void showErrorProductBarCodeEmptyField();

    }

    /**
     * Interfaz que controla funciones de la capa de presentacion.
     */
    interface presenter{

        /**
         * Metodo que controla la accion del button de la vista.
         */
        void buttonRegisterProductViewClicked();
    }

    /**
     * Interfaz que controla funciones de la capa de modelo.
     */
    interface model{

        /**
         * Metodo que retorna un valor booleano si producto fue registrado.
         * @param descriptionProduct parametro de tipo string, descripcion producto.
         * @param codeProduct parametro de tipo string, codigo producto.
         * @param barCodeProduct parametro de tipo string, codigo de barra de producto.
         * @param AmountProductPerBase parametro de tipo string, cantidad de bultos por base.
         * @param productHeight parametro de tipo int, altura de producto.
         * @return valor de tipo booleano.
         * true --> Registro Exitoso.
         * False --> Fallo Registro.
         */
        boolean registerProduct(String descriptionProduct, String codeProduct,
                                String barCodeProduct, String AmountProductPerBase, int productHeight);
    }
}

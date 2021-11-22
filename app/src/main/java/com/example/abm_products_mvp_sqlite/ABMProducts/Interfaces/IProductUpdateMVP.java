package com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces;

import com.example.abm_products_mvp_sqlite.pojo.Product;

/**
 * Interfaz MVP de Actualizacion datos de  Productos.
 * Contiene acceso a otras interfaces utilizadas para controlar la vista de actualizacion de datos de productos
 * y el acceso a datos.
 * @version 21/21/2021
 */
public interface IProductUpdateMVP {
    /**
     * Interfaz utilizado que controla funciones de la vista actualizacion datos de Productos.
     */
    interface view{

        /**
         * Metodo que obtiene datos del codigo de producto de la vista.
         * @return tipo String con datos de codigo de producto.
         */
        String getCodeProduct();

        /**
         * Metodo que obtiene datos de descripcion de producto de la vista.
         * @return tipo String con datos de la descripcion de producto.
         */
        String getDescriptionProduct();

        /**
         * Metodo que obtiene datos de paquetes por base de producto de la vista.
         * @return tipo String con datos de la descripcion de producto.
         */
        String getPackagePerBase();

        /**
         * Metodo que obtiene datos altura de producto de la vista.
         * @return tipo String con datos de altura de producto.
         */
        String getPackageHeight();

        /**
         * Metodo que obtiene datos de codigo de barra de producto de la vista.
         * @return tipo String con datos de codigo de barra de producto.
         */
        String getBarCode();

        /**
         * Metodo que carga informacion del codigo de barra de producto.
         * @param productBarCode parametro string con datos de producto.
         */
        void showProductBarCode(String productBarCode);

        /**
         * Metodo que carga informacion de descripcion de producto.
         * @param productDescription parametro string con datos de producto.
         */
        void showProductDescription(String productDescription);

        /**
         * Metodo que carga informacion del producto por base de producto.
         * @param productPerBase parametro string con datos de producto.
         */
        void showProductPackagePerBase(String productPerBase);

        /**
         * Metodo que carga informacion de la altura de producto.
         * @param productHeight parametro string con datos de producto.
         */
        void showProductPackageHeight(String productHeight);


        /**
         * Metodo que muestra error de campo vacio.
         */
        void showErrorProductCodeEmptyField();

    }

    /**
     * Interfaz que controla funciones de la capa de presentacion.
     */
    interface presenter{
        /**
         * Metodo que controla accion del boton update de la vista.
         */
        void buttonUpdateViewClicked();

        /**
         * Metodo que controla accion del boton buscar producto de la vista.
         * @param codeProduct
         */
        void buttonSearchViewClicked(String codeProduct);

    }

    /**
     * Interfaz que controla funciones de la capa de modelo.
     */
    interface model{

        /**
         * Metodo que retorna un valor booleano si producto fue actualizado.
         * @param codeProduct parametro de tipo string, codigo producto.
         * @param barCode parametro de tipo string, codigo de barra de producto.
         * @param productPerBase parametro de tipo string, cantidad de bultos por base.
         * @param productHeight parametro de tipo int, altura de producto.
         * @return valor de tipo booleano.
         * true --> Actualizacion Exitosa.
         * False --> Fallo Actualizacion.
         */
        boolean updateProduct(String codeProduct, String barCode, String productPerBase, int productHeight);

        /**
         * Metodo que obtiene un objeto de la clase Producto, en base al parametro recibido.
         * @param codeProduct parametro de tipo string, codigo de producto.
         */
        void getProduct(String codeProduct);

        /**
         * Metodo que devuelve un objeto de la clase Product.
         * @return objeto de la clase Product.
         */
        Product getProduct();
    }
}

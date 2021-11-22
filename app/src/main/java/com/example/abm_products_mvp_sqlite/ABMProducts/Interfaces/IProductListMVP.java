package com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces;
import com.example.abm_products_mvp_sqlite.ABMProducts.adapter.ListProductAdapter;
import com.example.abm_products_mvp_sqlite.pojo.Product;

import java.util.List;


/**
 * Interfaz MVP de Listado de  Productos.
 * Contiene acceso a otras interfaces utilizadas para controlar la vista de listado de productos
 * y el acceso a datos.
 * @version 21/21/2021
 */
public interface IProductListMVP {
    /**
     * Interfaz utilizado que controla funciones de la vista Listado de Productos.
     */
    interface view{
        /**
         * Metodo que carga el listado de todos los productos almacenados en repositorio
         * @param listProductAdapter  List que contiene cargado objetos de la clase Product.
         */
        void showProducts(ListProductAdapter listProductAdapter);
    }

    /**
     * Interfaz que controla funciones de la capa de presentacion.
     */
    interface presenter{
        /**
         * Metodo que carga listado de productos al iniciar actividad o view Listado de Productos.
         */
        void loadProducts();
    }

    /**
     * Interfaz que controla funciones de la capa de modelo.
     */
    interface model{
        /**
         * Metodo que retorna una lista con todos los productos almacenados en repositorio.
         * @return List de productos almacenados en repositorio.
         */
        List<Product> getProducts();
    }
}

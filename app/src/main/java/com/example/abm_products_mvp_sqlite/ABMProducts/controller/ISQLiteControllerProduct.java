package com.example.abm_products_mvp_sqlite.ABMProducts.controller;

import com.example.abm_products_mvp_sqlite.pojo.Product;

import java.util.List;

/**
 * Interfaz que provee los metodos para administrar CRUD de objetos de la clase Producto
 * almacenados en un repositorio 'x'
 * @version 21/21/2021
 */
public interface ISQLiteControllerProduct {
    /**
     * Metodo para registrar un producto
     * @param product el parametro product es un objeto de la clase Product,
     *                utilizado para el registro en repositorio
     * @return retorna tipo de dato boolean indicando si el registro fue satisfactorio o no
     *  return true --> producto registrado
     *  return false --> producto no registrado
     */
    boolean registerProduct(Product product);

    /**
     * Metodo que busca y retorna un objeto de la clase Producto, almacenado en repositorio
     * @param productCode parametro utilizado para la busqueda del objeto product
     * @return objeto product en base al parametro recibido
     */
    Product getProduct(String productCode);

    /**
     * Metodo que devuelve una lista de objetos de la clase Product almacenados en repositorio
     * @return lista de objetos de la clase Product
     */
    List<Product> showProducts();

    /**
     * Metodo para realizar la actualizacion de datos de un producto almacenado en repositorio
     * @param codeProduct parametro para realizar la busqueda de objeto de la clase Product en repositorio
     * @param product parametro objeto de la clase Product utilizado para actualizar la informacion del producto
     * @return tipo de dato boolean indicando si update fue satisfactorio o no
     *      *  return true --> producto actualizado
     *      *  return false --> producto no actualizado
     */
    boolean updateProduct(String codeProduct, Product product);


}

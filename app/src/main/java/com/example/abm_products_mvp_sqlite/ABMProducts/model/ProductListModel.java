package com.example.abm_products_mvp_sqlite.ABMProducts.model;

import android.content.Context;

import com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces.IProductListMVP;
import com.example.abm_products_mvp_sqlite.ABMProducts.controller.ISQLiteControllerProduct;
import com.example.abm_products_mvp_sqlite.pojo.Product;
import com.example.abm_products_mvp_sqlite.repositories.sqliteControllerEntities.ProductControllerSQL;

import java.util.List;

/**
 * Esta clase implementa la interfaz IProductListMVP.model.
 * Enlaza con repositorio local Sqlite. Muestra listado de productos almacenados en BD.
 * @version 21/11/2021
 */
public class ProductListModel implements IProductListMVP.model {

    //Variable de interfaz
    private ISQLiteControllerProduct isqLiteControllerProduct;

    /**
     * Constructor de la clase.
     * @param context parametro de tipo Context.
     */
    public ProductListModel(Context context) {
        this.isqLiteControllerProduct = new ProductControllerSQL(context);
    }

    /**
     * Metodo de interfaz.
     * @see IProductListMVP.model
     */
    @Override
    public List<Product> getProducts() {

        List<Product> listProduct = null;
        listProduct = isqLiteControllerProduct.showProducts();
        return listProduct;
    }
}

package com.example.abm_products_mvp_sqlite.ABMProducts.model;

import android.content.Context;

import com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces.IProductFindMVP;
import com.example.abm_products_mvp_sqlite.ABMProducts.controller.ISQLiteControllerProduct;
import com.example.abm_products_mvp_sqlite.pojo.Product;
import com.example.abm_products_mvp_sqlite.repositories.sqliteControllerEntities.ProductControllerSQL;

/**
 * Esta clase implementa la interfaz IProductFindMVP.model.
 * Enlaza con repositorio local Sqlite. Realiza la consulta de un producto, en base a codigo de producto.
 * @version 21/11/2021
 */
public class ProductFindModel implements IProductFindMVP.model {

    //Variable de interfaz
    private ISQLiteControllerProduct controllerProduct;

    /**
     * Constructor de la clase
     * @param context parametro de tipo Context.
     */
    public ProductFindModel(Context context) {
        this.controllerProduct = new ProductControllerSQL(context);
    }

    /**
     * Metodo de interfaz.
     * @see IProductFindMVP.model
     */
    @Override
    public String existsProduct(String codeProduct) {
        String product = "";
        Product obProduct = controllerProduct.getProduct(codeProduct);
        if (obProduct != null)
        {
            product = obProduct.toString();

        }
        return product;
    }
}

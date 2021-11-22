package com.example.abm_products_mvp_sqlite.ABMProducts.model;

import android.content.Context;

import com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces.IProductRegisterMVP;
import com.example.abm_products_mvp_sqlite.ABMProducts.controller.ISQLiteControllerProduct;
import com.example.abm_products_mvp_sqlite.pojo.Product;
import com.example.abm_products_mvp_sqlite.repositories.sqliteControllerEntities.ProductControllerSQL;


/**
 * Esta clase implementa la interfaz IProductRegisterMVP.model.
 * Enlaza con repositorio local Sqlite. Realiza el registro de un producto en BD.
 * @version 21/11/2021
 */
public class ProductRegisterModel implements IProductRegisterMVP.model {

    //Variable interfaz
    private ISQLiteControllerProduct isqLiteControllerProduct;

    /**
     * Constructor de la clase.
     * @param context parametro de tipo Context.
     */
    public ProductRegisterModel(Context context){

        this.isqLiteControllerProduct = new ProductControllerSQL(context);
    }

    /**
     * Metodo de interfaz.
     * @see IProductRegisterMVP.model
     */
    @Override
    public boolean registerProduct(String descriptionProduct, String codeProduct,
                                   String barCodeProduct, String AmountProductPerBase,
                                   int productHeight) {
        Product obProduct = new Product(codeProduct, descriptionProduct,
                barCodeProduct, productHeight, AmountProductPerBase);

        if (isqLiteControllerProduct.registerProduct(obProduct))
            return true;

        return false;
    }
}

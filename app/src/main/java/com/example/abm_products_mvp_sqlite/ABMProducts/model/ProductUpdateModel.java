package com.example.abm_products_mvp_sqlite.ABMProducts.model;

import android.content.Context;

import com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces.IProductRegisterMVP;
import com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces.IProductUpdateMVP;
import com.example.abm_products_mvp_sqlite.ABMProducts.controller.ISQLiteControllerProduct;
import com.example.abm_products_mvp_sqlite.pojo.Product;
import com.example.abm_products_mvp_sqlite.repositories.sqliteControllerEntities.ProductControllerSQL;

/**
 * Esta clase implementa la interfaz IProductUpdateMVP.model.
 * Enlaza con repositorio local Sqlite. Realiza la actualizacion de datos de un producto en BD.
 * @version 21/11/2021
 */
public class ProductUpdateModel implements IProductUpdateMVP.model {

    //Variable de interfaz
    private ISQLiteControllerProduct sqLiteControllerProduct;

    //Variable de clase Product
    private Product obProduct;

    /**
     * Constructor de la clase.
     * @param context parametro de tipo Context.
     */
    public ProductUpdateModel(Context context) {
        this.sqLiteControllerProduct = new ProductControllerSQL(context);
    }

    /**
     * Metodo de interfaz.
     * @see IProductUpdateMVP.model
     */
    @Override
    public boolean updateProduct(String codeProduct, String barCode, String productPerBase, int productHeight) {
        Product obProduct = new Product(
                barCode,
                productHeight,
                productPerBase
        );

        if (sqLiteControllerProduct.updateProduct(codeProduct, obProduct)){
            return true;
        }
        return false;
    }


    /**
     * Metodo de interfaz.
     * @see IProductUpdateMVP.model
     */
    @Override
    public void getProduct(String codeProduct) {
        obProduct = sqLiteControllerProduct.getProduct(codeProduct);

    }

    /**
     * Metodo de interfaz.
     * @see IProductUpdateMVP.model
     */
    @Override
    public Product getProduct() {
        return obProduct;
    }
}

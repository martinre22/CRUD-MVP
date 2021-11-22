package com.example.abm_products_mvp_sqlite.repositories.sqliteControllerEntities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.abm_products_mvp_sqlite.ABMProducts.controller.ISQLiteControllerProduct;
import com.example.abm_products_mvp_sqlite.pojo.Product;
import com.example.abm_products_mvp_sqlite.repositories.sqlite.SQLiteHelper;
import com.example.abm_products_mvp_sqlite.repositories.sqlite.SQLiteTables;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para realizar CRUD de Productos en repositorio local Sqlite.
 * Implementa la interfaz ISQLiteControllerProduct.
 * @version 21/11/2021
 */
public class ProductControllerSQL implements ISQLiteControllerProduct {

    //Variable de tipo SQLiteHelper
    private SQLiteHelper sqLiteHelper;

    /**
     * Constructor de la clase.
     * @param context parametro de tipo Context.
     */
    public ProductControllerSQL(Context context) {
        this.sqLiteHelper = new SQLiteHelper(context);
    }


    /**
     * Metodo de interfaz.
     * @see ISQLiteControllerProduct
     */
    @Override
    public boolean registerProduct(Product product) {
        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SQLiteTables.ProductEntry.COL_PRODUCT_PRODUCTCODE, product.getProductCode());
        cv.put(SQLiteTables.ProductEntry.COL_PRODUCT_DESCRIPTION, product.getDescription());
        cv.put(SQLiteTables.ProductEntry.COL_PRODUCT_BARCODE, product.getProductBarCode());
        cv.put(SQLiteTables.ProductEntry.COL_PRODUCT_PACKAGEPERBASE, product.getPackagesPerBase());
        cv.put(SQLiteTables.ProductEntry.COL_PRODUCT_PACKAGEHEIGHT, product.getPackageHeight());

        long regId = db.insert(SQLiteTables.ProductEntry.TABLE_NAME_PRODUCT,
                null,
                cv);

        if (regId != -1)
            return true;
        return false;

    }

    /**
     * Metodo de interfaz.
     * @see ISQLiteControllerProduct
     */
    @Override
    public Product getProduct(String productCode) {

        Product obProduct = null;

        SQLiteDatabase db = sqLiteHelper.getReadableDatabase();
        String[] columns = {
                SQLiteTables.ProductEntry.COL_PRODUCT_PRODUCTCODE,
                SQLiteTables.ProductEntry.COL_PRODUCT_DESCRIPTION,
                SQLiteTables.ProductEntry.COL_PRODUCT_BARCODE,
                SQLiteTables.ProductEntry.COL_PRODUCT_PACKAGEHEIGHT,
                SQLiteTables.ProductEntry.COL_PRODUCT_PACKAGEPERBASE

        };
        String selectionArgs = SQLiteTables.ProductEntry.COL_PRODUCT_PRODUCTCODE + "=?";
        String[] args = {
                productCode
        };

        Cursor c = db.query(
                SQLiteTables.ProductEntry.TABLE_NAME_PRODUCT,
                columns,
                selectionArgs,
                args,
                null,
                null,
                null
        );


        if (c != null)
        {
            try{
                if (c.moveToFirst()){
                    obProduct = new Product(
                            c.getString(0), //productCode
                            c.getString(1), //productDescription
                            c.getString(2), //barcode
                            c.getInt(3),    //packageHeight
                            c.getString(4) //packageperbase
                    );
                }
            }finally {
                c.close();
            }
        }else{
            return null;
        }
        return obProduct;
    }

    /**
     * Metodo de interfaz.
     * @see ISQLiteControllerProduct
     */
    @Override
    public List<Product> showProducts() {

        List<Product> listProducts;
        SQLiteDatabase db = sqLiteHelper.getReadableDatabase();
        String[] columns = {
                SQLiteTables.ProductEntry.COL_PRODUCT_PRODUCTCODE,
                SQLiteTables.ProductEntry.COL_PRODUCT_DESCRIPTION,
                SQLiteTables.ProductEntry.COL_PRODUCT_BARCODE,
                SQLiteTables.ProductEntry.COL_PRODUCT_PACKAGEHEIGHT,
                SQLiteTables.ProductEntry.COL_PRODUCT_PACKAGEPERBASE
        };


        Cursor c = db.query(SQLiteTables.ProductEntry.TABLE_NAME_PRODUCT,
                columns,
                null,
                null,
                null,
                null,
                null
        );

        listProducts = new ArrayList<>();
        if (c.moveToFirst())
        {
            do {
                listProducts.add(new Product(
                        c.getString(0),
                        c.getString(1),
                        c.getString(2),
                        c.getInt(3),
                        c.getString(4)
                ));
            }while (c.moveToNext());
        }else{
            return null;
        }
        return listProducts;
    }

    /**
     * Metodo de interfaz.
     * @see ISQLiteControllerProduct
     */
    @Override
    public boolean updateProduct(String codeProduct, Product product) {

        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();

        String selArgs = SQLiteTables.ProductEntry.COL_PRODUCT_PRODUCTCODE + "=?";
        String[] args = {
                codeProduct
        };
        ContentValues cv = new ContentValues();
        cv.put(SQLiteTables.ProductEntry.COL_PRODUCT_BARCODE, product.getProductBarCode());
        cv.put(SQLiteTables.ProductEntry.COL_PRODUCT_PACKAGEHEIGHT, product.getPackageHeight());
        cv.put(SQLiteTables.ProductEntry.COL_PRODUCT_PACKAGEPERBASE, product.getPackagesPerBase());

        int updId = db.update(SQLiteTables.ProductEntry.TABLE_NAME_PRODUCT,
                cv,
                selArgs, args);
        if (updId > 0)
            return true;
        else
            return false;

    }

}

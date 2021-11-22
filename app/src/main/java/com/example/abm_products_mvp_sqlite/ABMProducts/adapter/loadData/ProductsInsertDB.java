package com.example.abm_products_mvp_sqlite.ABMProducts.adapter.loadData;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.icu.text.Edits;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import androidx.constraintlayout.motion.utils.ViewSpline;

import com.example.abm_products_mvp_sqlite.ABMProducts.adapter.ListProductAdapter;
import com.example.abm_products_mvp_sqlite.pojo.Product;
import com.example.abm_products_mvp_sqlite.repositories.sqlite.SQLiteTables;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Clase de registro automatico de Productos (valores de prueba)
 * Esta clase define un ArrayList que devuelve una Arrar de objetos del tipo Product y los registra en Base de Datos
 * de Datos SQLite. Registro de Productos en BD a modo de prueba de funcionamiento
 * @version 21/11/2021
 */

public class ProductsInsertDB {

    /**
     * Metodo para registro de una lista de objetos Product automaticamente al iniciar la app
     * @param db el parametro db es una instancia de Base de datos SQLite
     */
    public static void registerProducts(SQLiteDatabase db)
    {

        for (Product p:
             getProductList()) {
            ContentValues cv = new ContentValues();
            cv.put(SQLiteTables.ProductEntry.COL_PRODUCT_PRODUCTCODE, p.getProductCode());
            cv.put(SQLiteTables.ProductEntry.COL_PRODUCT_DESCRIPTION, p.getDescription());
            cv.put(SQLiteTables.ProductEntry.COL_PRODUCT_BARCODE , p.getProductBarCode());
            cv.put(SQLiteTables.ProductEntry.COL_PRODUCT_PACKAGEPERBASE, p.getPackagesPerBase());
            cv.put(SQLiteTables.ProductEntry.COL_PRODUCT_PACKAGEHEIGHT, p.getPackageHeight());

            db.insert(SQLiteTables.ProductEntry.TABLE_NAME_PRODUCT,
                    null,
                    cv);
        }
    }

    /**
     * Metodo que devuelve una lista cargada de productos (Clase Product)
     * @return lista de productos
     */
    private static List<Product> getProductList(){
        List<Product> productList = new ArrayList<>();
        productList.add(
                new Product("1004013", "turron mani arcor", "1700966369", 17, "9" ));
        productList.add(
                new Product("1004014", "turron mani misky", "1722966369", 17, "9" ));
        productList.add(
                new Product("1006616", "pure tomate tetra arcor", "1700966369", 15, "15" ));
        productList.add(
                new Product("1010603", "jugo bc manzana 1L", "17790801060366", 26, "16" ));
        productList.add(
                new Product("1005679", "tomate perita lata", "17790585679001", 28, "16" ));
        productList.add(
                new Product("1010600", "jugo naranja bc 1L", "177905801060023", 26, "16" ));
        productList.add(
                new Product("1003363", "galletas mediatarde", "17790580336366", 45, "15" ));
        productList.add(
                new Product("1003339", "galletas mediatarde", "17790580333900", 45, "15" ));
        productList.add(
                new Product("1006264", "bizcochuelo godet choco", "177905806264", 28, "16" ));
        productList.add(
                new Product("1006266", "bizcochuelo godet vaini", "17790586266", 28, "16" ));
        productList.add(
                new Product("1006267", "bizcochuelo godet marmol", "177905806267033", 28, "16" ));
        productList.add(
                new Product("1006906", "chicle topline menta", "17790580690612", 22, "12" ));
        productList.add(
                new Product("1006900", "chicle topline fruta", "1779058690033", 22, "12" ));
        productList.add(
                new Product("1010128", "menthoplus menta", "1779058101012855", 18, "20" ));
        productList.add(
                new Product("1010130", "menthoplus mentol black", "1779058101013022", 18, "20" ));
        productList.add(
                new Product("1010520", "saladix jamon", "177905801052033", 32, "6" ));
        productList.add(
                new Product("1006973", "saladix queso", "179058069730012", 38, "13" ));
        productList.add(
                new Product("1003871", "saladix jamon/queso", "17790583871003", 32, "10" ));
        productList.add(
                new Product("1003870", "saladix pizza", "177905803870556", 32, "6" ));
        productList.add(
                new Product("1006807", "surtido diversion", "17779508680700", 48, "13" ));
        productList.add(
                new Product("1006805", "surtido desfile", "17779508680500", 48, "13" ));
        productList.add(
                new Product("1006151", "caramelo mogul", "1779058615100", 20, "15" ));
        productList.add(
                new Product("1006401", "caramelo mogul fruta", "1779058640100", 20, "15" ));
        productList.add(
                new Product("1006152", "caramelo mogul menta", "1779058615200", 20, "15" ));
        productList.add(
                new Product("1005044", "dulce membrillo estuche", "17790582504411", 17, "22" ));
        productList.add(
                new Product("1005046", "dulce batata estuche", "1779058250461", 17, "22" ));
        productList.add(
                new Product("1005048", "dulce bat/choc estuche", "17790582504811", 17, "22" ));
        productList.add(
                new Product("1006710", "membrillo lata", "1700966369", 10, "8" ));

        return productList;

    }
}

package com.example.abm_products_mvp_sqlite.repositories.sqlite;

import android.provider.BaseColumns;

import com.example.abm_products_mvp_sqlite.pojo.ProductType;

/**
 * Clase para definir el esquema de base de datos.
 * @version 21/11/2021
 */
public abstract class SQLiteTables {

    public static final String CREATE_TABLE_PRODUCTS = "create table "
            + ProductEntry.TABLE_NAME_PRODUCT
            + " ("
            + ProductEntry.COL_PRODUCT_ID + " integer primary key autoincrement,"
            + ProductEntry.COL_PRODUCT_PRODUCTCODE + " integer,"
            + ProductEntry.COL_PRODUCT_DESCRIPTION + " text,"
            + ProductEntry.COL_PRODUCT_BARCODE + " text,"
            + ProductEntry.COL_PRODUCT_STOCK + " integer,"
            + ProductEntry.COL_NUMBER_LOTE + " text,"
            + ProductEntry.COL_PRODUCT_PACKAGEHEIGHT + " integer,"
            + ProductEntry.COL_PRODUCT_PACKAGEPERBASE + " text,"
            + ProductEntry.COL_PRODUCT_PRODUCTWEIGHT + " text,"
            + ProductEntry.COL_PRODUCT_FK_UM + " integer,"
            + ProductEntry.COL_PRODUCT_FK_PRODUCT_TYPE + " integer,"
            + "UNIQUE (" + ProductEntry.COL_PRODUCT_ID + ")" 
            + ")";

    public static final String DROP_TABLE_PRODUCTS = "drop table if exists "
            + ProductEntry.TABLE_NAME_PRODUCT;


    public static final String CREATE_TABLE_PRODUCTTYPE = "create table "
            + ProductTypeEntry.TABLE_NAME_PRODUCT_TYPE
            + " ("
            + ProductTypeEntry.COL_PRODUCT_TYPE_ID + " integer primary key autoincrement,"
            + ProductTypeEntry.COL_PRODUCT_TYPE_DESCRIPTION + " text,"
            + ProductTypeEntry.COL_PRODUCT_TYPE_STACKLEVEL + " real,"
            + "UNIQUE (" + ProductTypeEntry.COL_PRODUCT_TYPE_ID + ")"
            + ")";

    public static final String DROP_TABLE_PRODUCTTYPE = "drop table if exists "
            + ProductTypeEntry.TABLE_NAME_PRODUCT_TYPE;


    public static final String CREATE_TABLE_UM = "create table "
            + UmEntry.TABLE_NAME_UM
            + " ("
            + UmEntry.COL_UM_ID + " integer primary key autoincrement, "
            + UmEntry.COL_UM_UMNAMEABREVIATION + " text, "
            + UmEntry.COL_UM_DESCRIPTION + " text, "
            + "UNIQUE (" + UmEntry.COL_UM_ID + ")"
            + ")";

    public static final String DROP_TABLE_UM = "drop table if exists "
            + UmEntry.TABLE_NAME_UM;



    public static abstract class ProductEntry implements BaseColumns{
        public static final String TABLE_NAME_PRODUCT = "Product";

        public static final String COL_PRODUCT_ID = "_id";
        public static final String COL_PRODUCT_PRODUCTCODE = "ProductCode";
        public static final String COL_PRODUCT_DESCRIPTION = "Description";
        public static final String COL_PRODUCT_BARCODE = "ProductBarCode";
        public static final String COL_PRODUCT_STOCK = "Stock";
        public static final String COL_NUMBER_LOTE = "NumberLote";
        public static final String COL_PRODUCT_PACKAGEHEIGHT = "PackageHeight";
        public static final String COL_PRODUCT_PACKAGEPERBASE = "PackagePerBase";
        public static final String COL_PRODUCT_PRODUCTWEIGHT = "ProductWeight";
        public static final String COL_PRODUCT_FK_UM = "FKUm";
        public static final String COL_PRODUCT_FK_PRODUCT_TYPE = "FKProductType";
    }


    public static abstract class ProductTypeEntry implements BaseColumns{
        public static final String TABLE_NAME_PRODUCT_TYPE = "ProductType";

        public static final String COL_PRODUCT_TYPE_ID = "_id";
        public static final String COL_PRODUCT_TYPE_DESCRIPTION = "Description";
        public static final String COL_PRODUCT_TYPE_STACKLEVEL = "StackLevel";
    }


    public static abstract class UmEntry implements BaseColumns{
        public static final String TABLE_NAME_UM = "Um";

        public static final String COL_UM_ID = "_id";
        public static final String COL_UM_UMNAMEABREVIATION = "NameAbreviation";
        public static final String COL_UM_DESCRIPTION = "Description";
    }
}

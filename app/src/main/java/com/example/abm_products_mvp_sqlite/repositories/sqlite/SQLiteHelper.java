package com.example.abm_products_mvp_sqlite.repositories.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.abm_products_mvp_sqlite.ABMProducts.adapter.loadData.ProductsInsertDB;

/**
 * Clase para la creacion y administracion de base de datos Sqlite.
 * @version 21/11/2021
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    //Variable version nombre db
    private static final String DATABASE_NAME = "PRODUCTIVEMANAGEMENT.db";
    //Variable version db
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructor de la clase.
     * @param context parametro de tipo Context.
     */
    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Metodo donde se definen las tablas de la BD.
     * Se realiza carga de datos previos.
     * @param db parametro SQLiteDatabase.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLiteTables.CREATE_TABLE_PRODUCTS);
        db.execSQL(SQLiteTables.CREATE_TABLE_PRODUCTTYPE);
        db.execSQL(SQLiteTables.CREATE_TABLE_UM);

        ProductsInsertDB.registerProducts(db);
    }

    /**
     * Metodo utilizado cuando se realiza una actualizacion en la BD.
     * @param db parametro SQLiteDataBase.
     * @param oldVersion parametro version antigua DB.
     * @param newVersion parametro actual version DB.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
        {
            db.execSQL(SQLiteTables.DROP_TABLE_PRODUCTS);
            db.execSQL(SQLiteTables.DROP_TABLE_PRODUCTTYPE);
            db.execSQL(SQLiteTables.DROP_TABLE_UM);
            onCreate(db);
        }
    }
}

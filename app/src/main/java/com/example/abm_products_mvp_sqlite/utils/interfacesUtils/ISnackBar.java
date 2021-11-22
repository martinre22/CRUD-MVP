package com.example.abm_products_mvp_sqlite.utils.interfacesUtils;

import android.content.Context;
import android.view.View;

/**
 * Interfaz para mostrar SnackBar en la vista.
 * @version 21/12/2021
 */
public interface ISnackBar {

    /**
     * Metodo que muestra un SnackBar en una vista.
     * @param mContext parametro de tipo Context.
     * @param view parametro de tipo vista donde se añade el SnackBar.
     * @param msg parametro de tipo string, mensaje a mostrar.
     */
    void showSnackBar(Context mContext, View view, String msg);
}

package com.example.abm_products_mvp_sqlite.utils;

import android.content.Context;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abm_products_mvp_sqlite.R;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.ISnackBar;
import com.google.android.material.snackbar.Snackbar;

/**
 * Clase para mostrar SnackBar en la vista o activity.
 * Implementa la interfaz ISnackBar.
 * @version 21/11/2021
 */
public class SnackBarUtils implements ISnackBar {

    /**
     * Metodo de interfaz.
     * @see ISnackBar
     */
    @Override
    public void showSnackBar(Context mContext, View view, String msg) {
        Snackbar.make(mContext, view, msg, Snackbar.LENGTH_LONG)
                .setBackgroundTint(view.getResources().getColor(R.color.light_blue_800))
                .setTextColor(view.getResources().getColor(R.color.white))
                .show();
    }
}

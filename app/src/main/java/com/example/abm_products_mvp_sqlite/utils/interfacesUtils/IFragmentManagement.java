package com.example.abm_products_mvp_sqlite.utils.interfacesUtils;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

/**
 * Interfaz para el manejo de vistas (Fragmentos)
 * @version 21/11/2021
 */
public interface IFragmentManagement {

    /**
     * Metodo para inflar la vista con un fragment.
     * @param activity parametro de tipo Activity.
     * @param contextm parametro de tipo Context.
     * @param containerId parametro layout contenedor.
     * @param fragment parametro de tipo Fragment.
     */
    public void fragmentManager(AppCompatActivity activity, Context contextm, int containerId, Fragment fragment);
}

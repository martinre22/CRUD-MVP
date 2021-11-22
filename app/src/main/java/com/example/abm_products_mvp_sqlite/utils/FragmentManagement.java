package com.example.abm_products_mvp_sqlite.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.abm_products_mvp_sqlite.ABMProducts.view.MenuProductView;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.IFragmentManagement;

/**
 * Clase que administra la carga de fragmentos en una vista o activity.
 * Implementa la interfaz IFragmentManagement
 * @version 21/11/2021
 */
public final class FragmentManagement extends FragmentActivity implements IFragmentManagement {

    /**
     * Metodo de interfaz.
     * @see IFragmentManagement
     */
    @Override
    public void fragmentManager(AppCompatActivity activity, Context contextm, int containerId, Fragment fragment) {
        if (containerId != 0 && fragment != null && activity != null)
        {
            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(containerId, fragment);
            transaction.commit();
        }else{
            if (containerId == 0)
                Toast.makeText(contextm, "not container", Toast.LENGTH_LONG).show();
            if (fragment == null)
                Toast.makeText(contextm, "not fragment", Toast.LENGTH_LONG).show();
        }
    }




}

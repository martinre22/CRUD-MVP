package com.example.abm_products_mvp_sqlite.ABMProducts.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces.IMenuProductMVP;
import com.example.abm_products_mvp_sqlite.ABMProducts.presenter.MenuProductPresenter;
import com.example.abm_products_mvp_sqlite.ABMProducts.presenter.ProductListPresenter;
import com.example.abm_products_mvp_sqlite.ABMProducts.view.fragments.ProductFindViewFragment;
import com.example.abm_products_mvp_sqlite.ABMProducts.view.fragments.ProductRegisterViewFragment;
import com.example.abm_products_mvp_sqlite.ABMProducts.view.fragments.ProductUpdateViewFragment;
import com.example.abm_products_mvp_sqlite.R;
import com.example.abm_products_mvp_sqlite.databinding.ActivityMenuProductViewBinding;
import com.example.abm_products_mvp_sqlite.utils.FragmentManagement;
import com.example.abm_products_mvp_sqlite.utils.SnackBarUtils;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.IFragmentManagement;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.IGeneralMessage;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.ISnackBar;

/**
 * Clase que infla vista o actividad Menu ABM Producto.
 * Implementa la interfaz IMenuProductMVP.view, IGeneralMessage.
 * @version 21/11/22
 */
public class MenuProductView extends AppCompatActivity implements View.OnClickListener,
        IMenuProductMVP.view,
        IGeneralMessage {

    ProductRegisterViewFragment registerViewFragment;
    ProductFindViewFragment findViewFragment;
    ProductUpdateViewFragment updateViewFragment;


    private ActivityMenuProductViewBinding bindingMenuProduct;

    private IMenuProductMVP.presenter menuProductPresenter;

    private IFragmentManagement iFragmentManagement;

    private ISnackBar iSnackBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingMenuProduct = ActivityMenuProductViewBinding.inflate(getLayoutInflater());
        View view = bindingMenuProduct.getRoot();
        setContentView(view);

        menuProductPresenter = new MenuProductPresenter(this,
                this,
                this);

        registerViewFragment = new ProductRegisterViewFragment();
        updateViewFragment = new ProductUpdateViewFragment();
        findViewFragment = new ProductFindViewFragment();


        bindingMenuProduct.btnFindProduct.setOnClickListener(this);
        bindingMenuProduct.btnRegisterNewProduct.setOnClickListener(this);
        bindingMenuProduct.btnShowListProduct.setOnClickListener(this);
        bindingMenuProduct.btnUpdateProduct.setOnClickListener(this);

        iFragmentManagement = new FragmentManagement();

        iSnackBar = new SnackBarUtils();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_register_new_product:
                menuProductPresenter.buttonRegisterProductClicked();
                break;
            case R.id.btn_update_product:
                menuProductPresenter.buttonUpdateProductClicked();
                break;
            case R.id.btn_find_product:
                menuProductPresenter.buttonFindProductClicked();
                break;
            case R.id.btn_show_list_product:
                menuProductPresenter.buttonListProductClicked();
                break;
        }
    }


    /**
     * Metodo de interfaz.
     * @see IMenuProductMVP.view
     */
    @Override
    public void toActivityNewProductRegister() {
        iFragmentManagement.fragmentManager(
                this,
                this,
                R.id.product_manage_relative_layout,
                registerViewFragment
        );
    }

    /**
     * Metodo de interfaz.
     * @see IMenuProductMVP.view
     */
    @Override
    public void toActivityUpdateProduct() {
        iFragmentManagement.fragmentManager(
                this,
                this,
                R.id.product_manage_relative_layout,
                updateViewFragment
        );
    }

    /**
     * Metodo de interfaz.
     * @see IMenuProductMVP.view
     */
    @Override
    public void toActivityFindProduct() {
        iFragmentManagement.fragmentManager(
                this,
                this,
                R.id.product_manage_relative_layout,
                findViewFragment
        );
    }

    /**
     * Metodo de interfaz.
     * @see IMenuProductMVP.view
     */
    @Override
    public void toActivityListProduct() {
        Intent i = new Intent(this, ProductListView.class);
        startActivity(i);
    }


    /**
     * Metodo de interfaz.
     * @see IGeneralMessage
     */
    @Override
    public void showMsg(String msg) {
        iSnackBar.showSnackBar(this,
                bindingMenuProduct.constraintLayoutMenuProductView,
                msg
                );
    }
}
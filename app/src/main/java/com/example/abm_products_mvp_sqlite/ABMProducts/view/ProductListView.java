package com.example.abm_products_mvp_sqlite.ABMProducts.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces.IProductListMVP;
import com.example.abm_products_mvp_sqlite.ABMProducts.adapter.ListProductAdapter;
import com.example.abm_products_mvp_sqlite.ABMProducts.presenter.ProductListPresenter;
import com.example.abm_products_mvp_sqlite.R;
import com.example.abm_products_mvp_sqlite.databinding.ActivityProductListViewBinding;
import com.example.abm_products_mvp_sqlite.utils.SnackBarUtils;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.IGeneralMessage;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.IOperationState;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.ISnackBar;

/**
 * Clase que infla vista o actividad Listado de Productos.
 * Implementa la interfaz IProductListMVP.view,IGeneralMessage, IOperationState.
 * @version 21/11/22
 */
public class ProductListView extends AppCompatActivity implements
        IProductListMVP.view, IGeneralMessage, IOperationState {

    private IProductListMVP.presenter listPresenter;
    private ISnackBar iSnackBar;

    private ActivityProductListViewBinding listViewBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listViewBinding = ActivityProductListViewBinding.inflate(getLayoutInflater());

        View view = listViewBinding.getRoot();

        setContentView(view);

        iSnackBar = new SnackBarUtils();

        listPresenter = new ProductListPresenter(this,
                this, this);

        listPresenter.loadProducts();
    }

    /**
     * Metodo de interfaz.
     * @see IProductListMVP.view
     */
    @Override
    public void showProducts(ListProductAdapter listProductAdapter) {

        listViewBinding.recyclerViewListProduct.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        );
        listViewBinding.recyclerViewListProduct.setHasFixedSize(true);
        listViewBinding.recyclerViewListProduct.setLayoutManager(new LinearLayoutManager(this));
        listViewBinding.recyclerViewListProduct.setAdapter(listProductAdapter);
    }


    /**
     * Metodo de interfaz.
     * @see IGeneralMessage
     */
    @Override
    public void showMsg(String msg) {
        //Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        iSnackBar.showSnackBar(this,
                listViewBinding.constraintLayoutListProductView,
                msg);
    }

    /**
     * Metodo de interfaz.
     * @see IOperationState
     */
    @Override
    public void operationSuccess(String msg) {
        showMsg(msg);
    }

    @Override
    public void operationFailure(String msg) {
        showMsg(msg);
    }
}
package com.example.abm_products_mvp_sqlite.ABMProducts.view.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces.IProductUpdateMVP;
import com.example.abm_products_mvp_sqlite.ABMProducts.presenter.ProductUpdatePresenter;
import com.example.abm_products_mvp_sqlite.R;
import com.example.abm_products_mvp_sqlite.databinding.FragmentProductUpdateViewBinding;
import com.example.abm_products_mvp_sqlite.utils.SnackBarUtils;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.IGeneralMessage;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.IListenerGenericOperations;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.IOperationState;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.ISnackBar;


/**
 * Clase que infla vista o actividad Update Product.
 * Implementa la interfaz IProductUpdateMVP.view, IGeneralMessage, IOperationState, IListenerGenericOperations.
 * @version 21/11/22
 */
public class ProductUpdateViewFragment extends Fragment implements
        IProductUpdateMVP.view, IGeneralMessage, IOperationState, IListenerGenericOperations,
        View.OnClickListener {

    private FragmentProductUpdateViewBinding updateViewBinding;
    private ISnackBar iSnackBar;
    private IProductUpdateMVP.presenter presenterUpdateProduct;

    public ProductUpdateViewFragment() {
        // Required empty public constructor
    }


    public static ProductUpdateViewFragment newInstance(String param1, String param2) {
        ProductUpdateViewFragment fragment = new ProductUpdateViewFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }

        presenterUpdateProduct = new ProductUpdatePresenter(getContext(),
                this,
                this);
        iSnackBar = new SnackBarUtils();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        updateViewBinding = FragmentProductUpdateViewBinding.inflate(inflater,
                container,
                false);
        View view = updateViewBinding.getRoot();
        updateViewBinding.btnSearchProductUpdateView.setOnClickListener(this);
        updateViewBinding.btnUpdateProductViewUpdateProduct.setOnClickListener(this);
        return view;
    }

    /**
     * Metodo de interfaz.
     * @see IProductUpdateMVP.view
     */
    @Override
    public String getCodeProduct() {
        return updateViewBinding.editTextCodeArticleUpdateProduct.getText().toString().trim();
    }

    /**
     * Metodo de interfaz.
     * @see IProductUpdateMVP.view
     */
    @Override
    public String getDescriptionProduct() {
        return updateViewBinding.textViewDescriptionUpdateView.getText().toString();
    }

    /**
     * Metodo de interfaz.
     * @see IProductUpdateMVP.view
     */
    @Override
    public String getPackagePerBase() {
        return updateViewBinding.editTextPackagePerBaseUpdateProduct.getText().toString().trim();
    }

    /**
     * Metodo de interfaz.
     * @see IProductUpdateMVP.view
     */
    @Override
    public String getPackageHeight() {
        return updateViewBinding.editTextPackageHeightUpdateProduct.getText().toString().trim();
    }

    /**
     * Metodo de interfaz.
     * @see IProductUpdateMVP.view
     */
    @Override
    public String getBarCode() {
        return updateViewBinding.editTextProductBarCodeUpdateProduct.getText().toString().trim();
    }

    /**
     * Metodo de interfaz.
     * @see IProductUpdateMVP.view
     */
    @Override
    public void showProductBarCode(String productBarCode) {
        updateViewBinding.editTextProductBarCodeUpdateProduct.setText("");
        updateViewBinding.editTextProductBarCodeUpdateProduct.setText(productBarCode);
        updateViewBinding.editTextProductBarCodeUpdateProduct.requestFocus();
    }

    /**
     * Metodo de interfaz.
     * @see IProductUpdateMVP.view
     */
    @Override
    public void showProductDescription(String productDescription) {
        updateViewBinding.textViewDescriptionUpdateView.setText(productDescription);
    }

    /**
     * Metodo de interfaz.
     * @see IProductUpdateMVP.view
     */
    @Override
    public void showProductPackagePerBase(String productPerBase) {
        updateViewBinding.editTextPackagePerBaseUpdateProduct.setText("");
        updateViewBinding.editTextPackagePerBaseUpdateProduct.setText(productPerBase);
    }

    /**
     * Metodo de interfaz.
     * @see IProductUpdateMVP.view
     */
    @Override
    public void showProductPackageHeight(String productHeight) {
        updateViewBinding.editTextPackageHeightUpdateProduct.setText("");
        updateViewBinding.editTextPackageHeightUpdateProduct.setText(productHeight);
    }

    /**
     * Metodo de interfaz.
     * @see IProductUpdateMVP.view
     */
    @Override
    public void showErrorProductCodeEmptyField() {
        updateViewBinding.editTextCodeArticleUpdateProduct.setError("Ingrese codigo");
    }

    /**
     * Metodo de interfaz.
     * @see IGeneralMessage
     */
    @Override
    public void showMsg(String msg) {
        iSnackBar.showSnackBar(getContext(),
                updateViewBinding.frameLayoutProductUpdateView,
                msg);
    }

    /**
     * Metodo de interfaz.
     * @see IOperationState
     */
    @Override
    public void operationSuccess(String msg) {
        showMsg(msg);
        clearFields();
        focusField();
    }

    /**
     * Metodo de interfaz.
     * @see IOperationState
     */
    @Override
    public void operationFailure(String msg) {
        showMsg(msg);
        clearFields();
        focusField();
    }

    /**
     * Metodo de interfaz.
     * @see IListenerGenericOperations
     */
    @Override
    public void clearFields() {
        updateViewBinding.editTextCodeArticleUpdateProduct.setText("");
        updateViewBinding.textViewDescriptionUpdateView.setText("Data Description");
        updateViewBinding.editTextPackageHeightUpdateProduct.setText("");
        updateViewBinding.editTextProductBarCodeUpdateProduct.setText("");
        updateViewBinding.editTextPackagePerBaseUpdateProduct.setText("");

    }

    /**
     * Metodo de interfaz.
     * @see IListenerGenericOperations
     */
    @Override
    public void focusField() {
        updateViewBinding.editTextCodeArticleUpdateProduct.requestFocus();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_search_product_update_view:
                presenterUpdateProduct.buttonSearchViewClicked(updateViewBinding.editTextCodeArticleUpdateProduct.getText().toString());
                break;
            case R.id.btn_update_product_view_update_product:
                presenterUpdateProduct.buttonUpdateViewClicked();
                break;
        }
    }
}
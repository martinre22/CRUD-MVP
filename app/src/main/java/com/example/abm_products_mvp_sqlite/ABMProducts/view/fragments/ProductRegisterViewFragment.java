package com.example.abm_products_mvp_sqlite.ABMProducts.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces.IProductRegisterMVP;
import com.example.abm_products_mvp_sqlite.ABMProducts.presenter.ProductRegisterPresenter;
import com.example.abm_products_mvp_sqlite.R;
import com.example.abm_products_mvp_sqlite.databinding.FragmentProductRegisterViewBinding;
import com.example.abm_products_mvp_sqlite.utils.SnackBarUtils;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.IGeneralMessage;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.IListenerGenericOperations;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.IOperationState;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.ISnackBar;

/**
 * Clase que infla vista o actividad Registro Producto.
 * Implementa la interfaz IProductRegisterMVP.view, IListenerGenericOperations, IGeneralMessage, IOperationState.
 * @version 21/11/22
 */
public class ProductRegisterViewFragment extends Fragment implements IProductRegisterMVP.view,
        View.OnClickListener, IListenerGenericOperations, IGeneralMessage, IOperationState {

    private FragmentProductRegisterViewBinding binding;

    IProductRegisterMVP.presenter productRegisterPresenter;
    ISnackBar iSnackBar;

    public ProductRegisterViewFragment() {

    }

    // TODO: Rename and change types and number of parameters
    public static ProductRegisterViewFragment newInstance(String param1, String param2) {
        ProductRegisterViewFragment fragment = new ProductRegisterViewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        productRegisterPresenter = new ProductRegisterPresenter(getContext(),
                this,
                this);

        iSnackBar = new SnackBarUtils();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProductRegisterViewBinding.inflate(inflater,
                container,
                false);
        View view = binding.getRoot();

        binding.btnRegisterProductViewRegisterProduct.setOnClickListener(this);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    /**
     * Metodo de interfaz.
     * @see IProductRegisterMVP.view
     */
    @Override
    public String getProductDescription() {
        return binding.editTextDescriptionRegisterProduct.getText().toString();
    }

    /**
     * Metodo de interfaz.
     * @see IProductRegisterMVP.view
     */
    @Override
    public String getProductBarcode() {
        return binding.editTextProductBarCodeRegisterProduct.getText().toString();
    }

    /**
     * Metodo de interfaz.
     * @see IProductRegisterMVP.view
     */
    @Override
    public String getProductCode() {
        return binding.editTextCodeArticleRegisterProduct.getText().toString();
    }

    /**
     * Metodo de interfaz.
     * @see IProductRegisterMVP.view
     */
    @Override
    public String getProductHeight() {
        return binding.editTextPackageHeight.getText().toString();
    }

    /**
     * Metodo de interfaz.
     * @see IProductRegisterMVP.view
     */
    @Override
    public String getProductPackagePerBase() {
        return binding.editTextPackagePerBase.getText().toString();
    }

    /**
     * Metodo de interfaz.
     * @see IProductRegisterMVP.view
     */
    @Override
    public void showErrorProductDescriptionEmptyField() {
        binding.editTextDescriptionRegisterProduct.setError("Campo Obligatorio");
    }

    /**
     * Metodo de interfaz.
     * @see IProductRegisterMVP.view
     */
    @Override
    public void showErrorProductCodeEmptyField() {
        binding.editTextCodeArticleRegisterProduct.setError("Campo Oblligatorio");
    }

    /**
     * Metodo de interfaz.
     * @see IProductRegisterMVP.view
     */
    @Override
    public void showErrorProductBarCodeEmptyField() {
        binding.editTextProductBarCodeRegisterProduct.setError("Campo Obligatorio");
    }


    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btn_register_product_view_RegisterProduct:
                productRegisterPresenter.buttonRegisterProductViewClicked();
        }
    }

    /**
     * Metodo de interfaz.
     * @see IListenerGenericOperations
     */
    @Override
    public void clearFields() {
        binding.editTextCodeArticleRegisterProduct.setText("");
        binding.editTextDescriptionRegisterProduct.setText("");
        binding.editTextProductBarCodeRegisterProduct.setText("");
        binding.editTextPackagePerBase.setText("");
        binding.editTextPackageHeight.setText("");
    }


    /**
     * Metodo de interfaz.
     * @see IListenerGenericOperations
     */
    @Override
    public void focusField() {

        binding.editTextCodeArticleRegisterProduct.requestFocus();
    }


    /**
     * Metodo de interfaz.
     * @see IGeneralMessage
     */
    @Override
    public void showMsg(String msg) {
        iSnackBar.showSnackBar(getContext(),
                binding.frameLayoutProductRegisterView,
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
    }
}
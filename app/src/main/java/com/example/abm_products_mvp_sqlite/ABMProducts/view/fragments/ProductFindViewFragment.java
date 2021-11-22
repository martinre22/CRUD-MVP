package com.example.abm_products_mvp_sqlite.ABMProducts.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces.IProductFindMVP;
import com.example.abm_products_mvp_sqlite.ABMProducts.presenter.ProductFindPresenter;
import com.example.abm_products_mvp_sqlite.R;
import com.example.abm_products_mvp_sqlite.databinding.FragmentProductFindViewBinding;
import com.example.abm_products_mvp_sqlite.utils.SnackBarUtils;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.IGeneralMessage;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.IListenerGenericOperations;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.IOperationState;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.ISnackBar;


/**
 * Clase que infla vista o actividad Consulta Producto.
 * Implementa la interfaz IProductFindMVP.view, IListenerGenericOperations, IGeneralMessage, IOperationState.
 * @version 21/11/22
 */
public class ProductFindViewFragment extends Fragment implements
        IProductFindMVP.view,
        IListenerGenericOperations,
        View.OnClickListener, IGeneralMessage, IOperationState {

    private FragmentProductFindViewBinding binding;

    private IProductFindMVP.presenter presenterProductFind;
    private ISnackBar iSnackBar;

    public ProductFindViewFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ProductFindViewFragment newInstance(String param1, String param2) {
        ProductFindViewFragment fragment = new ProductFindViewFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenterProductFind = new ProductFindPresenter(getContext(),
                this,
                this);

        iSnackBar = new SnackBarUtils();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProductFindViewBinding.inflate(inflater,
                container,
                false);
        View view = binding.getRoot();

        binding.btnFindProductViewFindProduct.setOnClickListener(this);
        return view;

    }

    /**
     * Metodo de interfaz.
     * @see IProductFindMVP.view
     */
    @Override
    public String getCodeProduct() {
        return binding.editTextCodeArticleFindProduct.getText().toString().trim();
    }

    /**
     * Metodo de interfaz.
     * @see IProductFindMVP.view
     */
    @Override
    public void showProductInfo(String dataProduct) {
        binding.textViewProductDataFindProduct.setText(dataProduct);
    }

    /**
     * Metodo de interfaz.
     * @see IProductFindMVP.view
     */
    @Override
    public void showErrorCodeProductEmptyField() {
        binding.editTextCodeArticleFindProduct.setError("Introducir codigo");
    }

    /**
     * Metodo de interfaz.
     * @see IListenerGenericOperations
     */
    @Override
    public void clearFields() {
        binding.textViewProductDataFindProduct.setText("");
    }


    /**
     * Metodo de interfaz.
     * @see IListenerGenericOperations
     */
    @Override
    public void focusField() {
        binding.editTextCodeArticleFindProduct.requestFocus();
    }



    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_find_product_view_FindProduct:
                presenterProductFind.buttonFindProductViewClicked();
                break;
        }
    }

    /**
     * Metodo de interfaz.
     * @see IGeneralMessage
     */
    @Override
    public void showMsg(String msg) {
        iSnackBar.showSnackBar(getContext(),
                binding.frameViewProductFind,
                msg);
    }

    /**
     * Metodo de interfaz.
     * @see IOperationState
     */
    @Override
    public void operationSuccess(String msg) {
        showMsg(msg);
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
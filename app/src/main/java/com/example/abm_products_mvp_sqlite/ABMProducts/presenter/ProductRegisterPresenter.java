package com.example.abm_products_mvp_sqlite.ABMProducts.presenter;

import android.content.Context;

import com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces.IProductRegisterMVP;
import com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces.IProductUpdateMVP;
import com.example.abm_products_mvp_sqlite.ABMProducts.model.ProductRegisterModel;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.IGeneralMessage;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.IListenerGenericOperations;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.IOperationState;

/**
 * Clase presenter, conecta la vista (ProductRegisterViewFragment) y el modelo (ProductRegisterModel).
 * Implementa la interfaz IProductRegisterMVP.presenter.
 * @version 21/11/2021
 */
public class ProductRegisterPresenter implements IProductRegisterMVP.presenter {

    private IProductRegisterMVP.model modelRegisterProduct;
    private IProductRegisterMVP.view viewRegisterProduct;

    private IOperationState operationState;


    /**
     * Constructor de clase.
     * @param mContext parametro Context.
     * @param view parametro de tipo view.
     * @param listenerOperation parametro de tipo OperationState.
     */
    public ProductRegisterPresenter(Context mContext, IProductRegisterMVP.view view,
                                    IOperationState listenerOperation ){
        this.viewRegisterProduct = view;
        this.modelRegisterProduct = new ProductRegisterModel(mContext);
        this.operationState = listenerOperation;

    }

    /**
     * Metodo de interfaz.
     * @see IProductRegisterMVP.presenter
     */
    @Override
    public void buttonRegisterProductViewClicked() {
        if (viewRegisterProduct != null)
        {
            if (!viewRegisterProduct.getProductDescription().equals("") &&
            !viewRegisterProduct.getProductBarcode().equals("") &&
            !viewRegisterProduct.getProductCode().equals("")){

                if (modelRegisterProduct.registerProduct(viewRegisterProduct.getProductDescription(),
                        viewRegisterProduct.getProductCode(), viewRegisterProduct.getProductBarcode(),
                        viewRegisterProduct.getProductPackagePerBase(),
                        Integer.parseInt(viewRegisterProduct.getProductHeight())))
                {
                    operationState.operationSuccess("Producto Registrado");
                }else{
                    operationState.operationFailure("Error registro");
                }
            }else{
                if (viewRegisterProduct.getProductCode().equals(""))
                    viewRegisterProduct.showErrorProductCodeEmptyField();

                if (viewRegisterProduct.getProductBarcode().equals(""))
                    viewRegisterProduct.showErrorProductBarCodeEmptyField();

                if (viewRegisterProduct.getProductDescription().equals(""))
                    viewRegisterProduct.showErrorProductDescriptionEmptyField();

            }
        }
    }
}

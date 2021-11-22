package com.example.abm_products_mvp_sqlite.ABMProducts.presenter;

import android.content.Context;

import com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces.IProductFindMVP;
import com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces.IProductListMVP;
import com.example.abm_products_mvp_sqlite.ABMProducts.model.ProductFindModel;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.IListenerGenericOperations;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.IOperationState;

/**
 * Clase presenter, conecta la vista (ProductFindViewFragment) y el modelo (ProductFindModel).
 * Implementa la interfaz IProductFindMVP.presenter.
 * @version 21/11/2021
 */
public class ProductFindPresenter implements IProductFindMVP.presenter {

    private IProductFindMVP.view viewProductFind;
    private IProductFindMVP.model modelProductFind;
    private IOperationState operationState;

    /**
     * Constructor de clase.
     * @param context parametro Context.
     * @param view parametro de tipo view.
     * @param listenerOperation parametro de tipo OperationState.
     */
    public ProductFindPresenter(Context context,
                                IProductFindMVP.view view, IOperationState listenerOperation ) {
        this.viewProductFind = view;
        this.operationState = listenerOperation;
        this.modelProductFind = new ProductFindModel(context);
    }

    /**
     * Metodo de interfaz.
     * @see IProductFindMVP.presenter
     */
    @Override
    public void buttonFindProductViewClicked() {
        if (viewProductFind != null)
        {
            if (!viewProductFind.getCodeProduct().equals(""))
            {
                String dataProduct = modelProductFind.existsProduct(
                        viewProductFind.getCodeProduct().toString());
                if (!dataProduct.equals(""))
                {
                    viewProductFind.showProductInfo(dataProduct);
                    operationState.operationSuccess("Consulta completada");
                }else{
                    operationState.operationFailure("Producto no existe");
                }
            }else{
                viewProductFind.showErrorCodeProductEmptyField();
            }
        }else{
            operationState.operationFailure("Error ejecucion");
        }
    }
}

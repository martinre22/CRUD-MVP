package com.example.abm_products_mvp_sqlite.ABMProducts.presenter;

import android.content.Context;

import com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces.IProductUpdateMVP;
import com.example.abm_products_mvp_sqlite.ABMProducts.model.ProductUpdateModel;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.IOperationState;

/**
 * Clase presenter, conecta la vista (ProductUpdateViewFragment) y el modelo (ProductUpdateModel).
 * Implementa la interfaz IProductUpdateMVP.presenter.
 * @version 21/11/2021
 */
public class ProductUpdatePresenter implements IProductUpdateMVP.presenter {

    private IProductUpdateMVP.view productUpdateView;
    private IOperationState operationState;
    private IProductUpdateMVP.model productUpdateModel;

    /**
     * Constructor de clase.
     * @param context parametro Context.
     * @param productUpdateView parametro de tipo view.
     * @param operationState parametro de tipo OperationState.
     */
    public ProductUpdatePresenter(Context context, IProductUpdateMVP.view productUpdateView, IOperationState operationState) {
        this.productUpdateView = productUpdateView;
        this.operationState = operationState;
        this.productUpdateModel = new ProductUpdateModel(context);
    }

    /**
     * Metodo de interfaz.
     * @see IProductUpdateMVP.presenter
     */
    @Override
    public void buttonUpdateViewClicked() {
        int packageHeight;
        if (productUpdateView != null){
            if (!productUpdateView.getDescriptionProduct().equals(""))
            {
                if (!productUpdateView.getPackageHeight().equals("")){
                    packageHeight = Integer.parseInt(productUpdateView.getPackageHeight());
                }else {
                    packageHeight = 0;
                }
                if (productUpdateModel.updateProduct(
                        productUpdateView.getCodeProduct(),
                        productUpdateView.getBarCode(),
                        productUpdateView.getPackagePerBase(),
                        packageHeight
                )){
                    operationState.operationSuccess("Actualizacion exitosa");
                }else{
                    operationState.operationFailure("Error actualizacion");
                }
            }else{
                operationState.operationFailure("Debe seleccionar un producto");
            }
        }else{
            operationState.operationFailure("Error ejecucion");
        }
    }

    /**
     * Metodo de interfaz.
     * @see IProductUpdateMVP.presenter
     */
    @Override
    public void buttonSearchViewClicked(String codeProduct) {

        if (productUpdateView != null){
            if (!productUpdateView.getCodeProduct().equals("")){
                   productUpdateModel.getProduct(codeProduct);
                   if (productUpdateModel.getProduct() != null){
                       productUpdateView.showProductBarCode(productUpdateModel.getProduct().getProductBarCode());
                       productUpdateView.showProductDescription(productUpdateModel.getProduct().getDescription());
                       productUpdateView.showProductPackagePerBase(productUpdateModel.getProduct().getPackagesPerBase());
                       productUpdateView.showProductPackageHeight(String.valueOf(productUpdateModel.getProduct().getPackageHeight()));
                   }else{
                       operationState.operationFailure("No existe Producto");
                   }
            }else{
                productUpdateView.showErrorProductCodeEmptyField();
            }
        }else{
            operationState.operationFailure("Error ejecucion");
        }
    }

}

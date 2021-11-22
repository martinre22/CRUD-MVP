package com.example.abm_products_mvp_sqlite.ABMProducts.presenter;

import android.content.Context;
import android.util.Log;


import com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces.IProductListMVP;
import com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces.IProductRegisterMVP;
import com.example.abm_products_mvp_sqlite.ABMProducts.adapter.ListProductAdapter;
import com.example.abm_products_mvp_sqlite.ABMProducts.model.ProductListModel;
import com.example.abm_products_mvp_sqlite.pojo.Product;

import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.IOperationState;


import java.util.List;

/**
 * Clase presenter, conecta la vista (ProductListView) y el modelo (ProductListModel).
 * Implementa la interfaz IProductListMVP.presenter.
 * @version 21/11/2021
 */
public class ProductListPresenter implements IProductListMVP.presenter {

    private IProductListMVP.model modelProductList;
    private IProductListMVP.view viewProductList;
    private IOperationState  listener;
    private Context context;
    static final String TAG = "info";

    /**
     * Constructor de clase.
     * @param context parametro Context.
     * @param viewProductList parametro de tipo view.
     * @param listener parametro de tipo OperationState.
     */
    public ProductListPresenter(Context context, IProductListMVP.view viewProductList, IOperationState listener) {
        this.viewProductList = viewProductList;
        this.modelProductList = new ProductListModel(context);
        this.listener = listener;
        this.context = context;
    }

    /**
     * Metodo de interfaz.
     * @see IProductListMVP.presenter
     */
    @Override
    public void loadProducts() {
        ListProductAdapter listProductAdapter = null;
        if (viewProductList != null){
            if (modelProductList.getProducts() != null) {

                String prod = "e";
                for (Product p: modelProductList.getProducts()
                     ) {
                    prod += p.getDescription() + "\n";
                }
                Log.d(TAG, prod);
                listProductAdapter = new ListProductAdapter(
                        modelProductList.getProducts()
                );

                viewProductList.showProducts(listProductAdapter);
                listener.operationSuccess("Completado");

            }else{
                listener.operationFailure("Error carga de datos");
            }
        }else{
            listener.operationFailure("Error ejecucion");
        }


    }
}

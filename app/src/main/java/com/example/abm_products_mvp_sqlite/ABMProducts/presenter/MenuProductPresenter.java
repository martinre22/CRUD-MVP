package com.example.abm_products_mvp_sqlite.ABMProducts.presenter;

import android.content.Context;

import com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces.IMenuProductMVP;
import com.example.abm_products_mvp_sqlite.ABMProducts.Interfaces.IProductFindMVP;
import com.example.abm_products_mvp_sqlite.utils.interfacesUtils.IGeneralMessage;

/**
 * Clase presenter, conecta con la vista (MenuProductview).
 * Implementa la interfaz IMenuProductMVP.presenter.
 * @version 21/11/2021
 */
public class MenuProductPresenter implements IMenuProductMVP.presenter {

    private IMenuProductMVP.view viewMenuProduct;
    private IGeneralMessage generalMessage;

    /**
     * Constructor de clase.
     * @param context parametro Context.
     * @param view parametro de tipo view.
     * @param generalMessage parametro de tipo GeneralMessage.
     */
    public MenuProductPresenter(Context context, IMenuProductMVP.view view, IGeneralMessage generalMessage)
    {
        this.viewMenuProduct = view;
        this.generalMessage = generalMessage;
    }

    /**
     * Metodo de interfaz.
     * @see IMenuProductMVP.presenter
     */
    @Override
    public void buttonRegisterProductClicked() {
        if (viewMenuProduct != null)
        {
            viewMenuProduct.toActivityNewProductRegister();
        }else{
            generalMessage.showMsg("Error ejecucion");
        }
    }

    /**
     * Metodo de interfaz.
     * @see IMenuProductMVP.presenter
     */
    @Override
    public void buttonUpdateProductClicked() {
        if (viewMenuProduct != null)
        {
            viewMenuProduct.toActivityUpdateProduct();
        }else{
            generalMessage.showMsg("Error ejecucion");
        }
    }

    /**
     * Metodo de interfaz.
     * @see IMenuProductMVP.presenter
     */
    @Override
    public void buttonFindProductClicked() {
        if (viewMenuProduct != null)
        {
            viewMenuProduct.toActivityFindProduct();
        }else{
            generalMessage.showMsg("Error ejecucion");
        }
    }

    /**
     * Metodo de interfaz.
     * @see IMenuProductMVP.presenter
     */
    @Override
    public void buttonListProductClicked() {
        if (viewMenuProduct != null)
        {
            viewMenuProduct.toActivityListProduct();
        }else{
            generalMessage.showMsg("Error ejecucion");
        }
    }
}

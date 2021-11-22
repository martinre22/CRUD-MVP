package com.example.abm_products_mvp_sqlite.utils.interfacesUtils;

/**
 * Interface que muestra mensajes de error generales.
 * @version 21/11/2021
 */
public interface IGeneralMessage {

    /**
     * Metodo que muestra el mensaje recibido en la vista.
     * @param msg parametro de tipo string, mensaje a mostrar.
     */
    void showMsg(String msg);
}

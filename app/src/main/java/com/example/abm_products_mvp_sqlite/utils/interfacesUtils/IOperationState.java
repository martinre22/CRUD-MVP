package com.example.abm_products_mvp_sqlite.utils.interfacesUtils;

/**
 * Interface donde se desarrollan operaciones en base al exito o fallo de las mismas.
 * @version 21/11/2021
 */
public interface IOperationState {

    /**
     * Metodo que se activa cuando una operacion si concluye satisfactoriamente.
     * @param msg parametro de tipo string, mensaje a mostrar.
     */
    void operationSuccess(String msg);

    /**
     * Metodo que se activa cuando una operacion no concluye satisfactoriamente.
     * @param msg parametro de tipo string, mensaje a mostrar.
     */
    void operationFailure(String msg);
}

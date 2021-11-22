package com.example.abm_products_mvp_sqlite.pojo;

/**
 * Pojo.
 * Clase ProductType.
 * Clase que almacena informacion sobre el tipo de producto de un objeto de la clase Product.
 * @version 21/11/2021
 */
public class ProductType {
    int id;
    private String description;
    private long stackLevel;

    /**
     * Constructor vacio de la clase.
     */
    public ProductType() {
    }

    /**
     * Constructor de clase.
     * @param id parametro id de ProductType.
     * @param description parametro description de ProductType.
     * @param stackLevel parametro stackLevel (Nivel de apilado) de ProductType.
     */
    public ProductType(int id, String description, long stackLevel) {
        this.id = id;
        this.description = description;
        this.stackLevel = stackLevel;
    }

    /**
     * Constructor de clase.
     * @param description parametro description de ProductType.
     * @param stackLevel parametro stackLevel (Nivel de apilado) de ProductType.
     */
    public ProductType(String description, long stackLevel) {
        this.description = description;
        this.stackLevel = stackLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getStackLevel() {
        return stackLevel;
    }

    public void setStackLevel(long stackLevel) {
        this.stackLevel = stackLevel;
    }
}

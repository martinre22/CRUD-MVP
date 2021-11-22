package com.example.abm_products_mvp_sqlite.pojo;

/**
 * Pojo.
 * Clase Um.
 * Clase que almacena informacion sobre la unidad de medida de un objeto de la clase Product.
 * @version 21/11/2021
 */
public class Um {
    private int id;
    private String umNameAbreviation;
    private String description;

    /**
     * Constructor vacio de clase.
     */
    public Um() {
    }

    /**
     * Constructor de clase.
     * @param id parametro id de Um.
     * @param umNameAbreviation parametro umNameAbreviation de Um.
     * @param description parametro description de Um.
     */
    public Um(int id, String umNameAbreviation, String description) {
        this.id = id;
        this.umNameAbreviation = umNameAbreviation;
        this.description = description;
    }

    public Um(String umNameAbreviation, String description) {
        this.umNameAbreviation = umNameAbreviation;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUmNameAbreviation() {
        return umNameAbreviation;
    }

    public void setUmNameAbreviation(String umNameAbreviation) {
        this.umNameAbreviation = umNameAbreviation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

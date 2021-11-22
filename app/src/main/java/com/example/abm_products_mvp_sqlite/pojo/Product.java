package com.example.abm_products_mvp_sqlite.pojo;

/**
 * Pojo
 * Clase Product
 * Clase que almacena informacion sobre un objeto de la clase Product.
 * @version 21/11/2021
 */
public class Product {

    private int id;
    private String productCode;
    private String description;
    private String productBarCode;
    private int stock;
    private String numberLote;
    private int packageHeight;
    private String packagesPerBase;
    private String productWeight;
    private Um um;
    private ProductType productType;

    /**
     * Constructor vacio de la clase
     */
    public Product() {
    }

    /**
     * Constructor de clase.
     * @param productCode parametro productCode de Product.
     * @param description parametro description de Product.
     * @param productBarCode parametro productBarCode de Product.
     * @param packageHeight parametro packageHeight de Product.
     * @param packagesPerBase parametro packagesPerBase de Product.
     */
    public Product(String productCode, String description, String productBarCode,
                   int packageHeight, String packagesPerBase) {
        this.productCode = productCode;
        this.description = description;
        this.productBarCode = productBarCode;
        this.packageHeight = packageHeight;
        this.packagesPerBase = packagesPerBase;
    }

    /**
     * Constructor de clase.
     *  @param description parametro description de Product.
     * @param productBarCode parametro productBarCode de Product.
     * @param packageHeight parametro packageHeight de Product.
     * @param packagesPerBase parametro packagesPerBase de Product.
     */
    public Product(String description, String productBarCode,
                   int packageHeight, String packagesPerBase) {
        this.description = description;
        this.productBarCode = productBarCode;
        this.packageHeight = packageHeight;
        this.packagesPerBase = packagesPerBase;
    }

    /**
     * Constructor de clase.
     * @param productBarCode parametro productBarCode de Product.
     * @param packageHeight parametro packageHeight de Product.
     * @param packagesPerBase parametro packagesPerBase de Product.
     */
    public Product(String productBarCode,
                   int packageHeight, String packagesPerBase) {
        this.productBarCode = productBarCode;
        this.packageHeight = packageHeight;
        this.packagesPerBase = packagesPerBase;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductBarCode() {
        return productBarCode;
    }

    public void setProductBarCode(String productBarCode) {
        this.productBarCode = productBarCode;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNumberLote() {
        return numberLote;
    }

    public void setNumberLote(String numberLote) {
        this.numberLote = numberLote;
    }

    public int getPackageHeight() {
        return packageHeight;
    }

    public void setPackageHeight(int packageHeight) {
        this.packageHeight = packageHeight;
    }

    public String getPackagesPerBase() {
        return packagesPerBase;
    }

    public void setPackagesPerBase(String packagesPerBase) {
        this.packagesPerBase = packagesPerBase;
    }

    public String getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(String productWeight) {
        this.productWeight = productWeight;
    }

    public Um getUm() {
        return um;
    }

    public void setUm(Um um) {
        this.um = um;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    /**
     * Metodo que devuelve un string formateado con datos de un objeto de la clase.
     * @return dato de tipo string con datos de un objeto de la clase.
     */
    @Override
    public String toString() {
        return "Codigo=" + productCode +
                "\nDescripcion=" + description +
                "\nDun=" + productBarCode +
                "\nBU/BASE=" + packagesPerBase +
                "\nBU/ALTURA=" + packageHeight;
    }
}

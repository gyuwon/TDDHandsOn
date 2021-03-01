package productimporter;

public final class Product {
    private final String supplierName;
    private final String productCode;
    private final String productName;
    private final Pricing pricing;

    public Product(String supplierName, String productCode, String productName, Pricing pricing) {
        this.supplierName = supplierName;
        this.productCode = productCode;
        this.productName = productName;
        this.pricing = pricing;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public Pricing getPricing() {
        return pricing;
    }
}

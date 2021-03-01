package productimporter;

public final class ProductSynchronizer {
    private final ProductImporter importer;
    private final ProductValidator validator;
    private final ProductInventory inventory;

    public ProductSynchronizer(ProductImporter importer, ProductValidator validator, ProductInventory inventory) {
        this.importer = importer;
        this.validator = validator;
        this.inventory = inventory;
    }

    public void run() {
        for (Product product : importer.fetchProducts()) {
            if (validator.isValid(product)) {
                inventory.upsertProduct(product);
            }
        }
    }
}

package productimporter;

import java.util.ArrayList;
import java.util.List;

public final class ProductInventorySpy implements ProductInventory {

    private final List<Product> log = new ArrayList<Product>();

    @Override
    public void upsertProduct(Product product) {
        log.add(product);
    }

    public List<Product> getLog() {
        return log;
    }

}

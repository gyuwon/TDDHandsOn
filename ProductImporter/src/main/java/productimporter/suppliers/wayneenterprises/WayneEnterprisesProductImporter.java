package productimporter.suppliers.wayneenterprises;

import java.util.ArrayList;

import productimporter.Product;
import productimporter.ProductImporter;

public final class WayneEnterprisesProductImporter implements ProductImporter {

    public WayneEnterprisesProductImporter(WayneEnterprisesProductSource dataSource) {
    }

    @Override
    public Iterable<Product> fetchProducts() {
        return new ArrayList<Product>();
    }

}

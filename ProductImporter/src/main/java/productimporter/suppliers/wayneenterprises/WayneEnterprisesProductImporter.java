package productimporter.suppliers.wayneenterprises;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import productimporter.Product;
import productimporter.ProductImporter;

public final class WayneEnterprisesProductImporter implements ProductImporter {

    private final WayneEnterprisesProductSource dataSource;
    private final WayneEnterprisesProductTranslator translator;

    public WayneEnterprisesProductImporter(WayneEnterprisesProductSource dataSource) {
        this.dataSource = dataSource;
        translator = new WayneEnterprisesProductTranslator();
    }

    @Override
    public Iterable<Product> fetchProducts() {
        return StreamSupport.stream(dataSource.fetchProducts().spliterator(), false).map(translator::translateProduct)
                .collect(Collectors.toList());
    }

}

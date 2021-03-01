package productimporter.suppliers.starkindustries;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import productimporter.Product;
import productimporter.ProductImporter;

public final class StarkIndustriesProductImporter implements ProductImporter {

    private final StarkIndustriesProductSource dataSource;
    private final StarkIndustriesProductTranslator translator;

    public StarkIndustriesProductImporter(StarkIndustriesProductSource dataSource,
            StarkIndustriesProductTranslator translator) {
        this.dataSource = dataSource;
        this.translator = translator;
    }

    @Override
    public Iterable<Product> fetchProducts() {
        return StreamSupport.stream(dataSource.getAllProducts().spliterator(), false).map(translator::translate)
                .collect(Collectors.toList());
    }

}

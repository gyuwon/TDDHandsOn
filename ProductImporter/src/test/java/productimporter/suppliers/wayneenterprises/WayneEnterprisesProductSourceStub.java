package productimporter.suppliers.wayneenterprises;

import java.util.Arrays;

public class WayneEnterprisesProductSourceStub implements WayneEnterprisesProductSource {

    private final WayneEnterprisesProduct[] products;

    public WayneEnterprisesProductSourceStub(WayneEnterprisesProduct... products) {
        this.products = products;
    }

    @Override
    public Iterable<WayneEnterprisesProduct> fetchProducts() {
        return Arrays.asList(products);
    }

}

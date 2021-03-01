package productimporter.suppliers.wayneenterprises;

public interface WayneEnterprisesProductSource {
    Iterable<WayneEnterprisesProduct> fetchProducts();
}

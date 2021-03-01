package productimporter;

import java.math.BigDecimal;
import org.junit.jupiter.params.ParameterizedTest;

import productimporter.suppliers.wayneenterprises.WayneEnterprisesProduct;
import productimporter.suppliers.wayneenterprises.WayneEnterprisesProductImporter;
import productimporter.suppliers.wayneenterprises.WayneEnterprisesProductSourceStub;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductSynchronizer_specs {
    @ParameterizedTest
    @DomainArgumentsSource
    void sut_correctly_saves_products(WayneEnterprisesProduct[] products) {
        var stub = new WayneEnterprisesProductSourceStub(products);
        var importer = new WayneEnterprisesProductImporter(stub);
        var validator = new ListPriceFilter(BigDecimal.ZERO);
        var spy = new ProductInventorySpy();
        var sut = new ProductSynchronizer(importer, validator, spy);

        sut.run();

        Iterable<Product> expected = importer.fetchProducts();
        assertThat(spy.getLog()).usingRecursiveFieldByFieldElementComparator().containsAll(expected);
    }

    @ParameterizedTest
    @DomainArgumentsSource
    void sut_does_not_save_invalid_product(WayneEnterprisesProduct product) {
        // Arrange
        var lowerBound = new BigDecimal(product.getListPrice() + 10000);
        var validator = new ListPriceFilter(lowerBound);

        var stub = new WayneEnterprisesProductSourceStub(product);
        var importer = new WayneEnterprisesProductImporter(stub);
        var spy = new ProductInventorySpy();
        var sut = new ProductSynchronizer(importer, validator, spy);

        // Act
        sut.run();

        // Assert
        assertThat(spy.getLog()).isEmpty();
    }
}

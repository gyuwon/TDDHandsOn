package productimporter.suppliers.wayneenterprises;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;

import productimporter.DomainArgumentsSource;
import productimporter.Product;

public class WayneEnterprisesProductImporter_specs {
    @ParameterizedTest
    @DomainArgumentsSource
    void sut_projects_all_products(WayneEnterprisesProduct[] source) {
        var stub = new WayneEnterprisesProductSourceStub(source);
        var sut = new WayneEnterprisesProductImporter(stub);

        Iterable<Product> actual = sut.fetchProducts();

        assertThat(actual).hasSize(source.length);
    }

    @ParameterizedTest
    @DomainArgumentsSource
    void sut_correctly_sets_supplier_name(WayneEnterprisesProduct[] source) {
        var stub = new WayneEnterprisesProductSourceStub(source);
        var sut = new WayneEnterprisesProductImporter(stub);

        Iterable<Product> actual = sut.fetchProducts();

        assertThat(actual).allMatch(x -> x.getSupplierName().equals("WAYNE"));
    }

    @ParameterizedTest
    @DomainArgumentsSource
    void sut_correctly_projects_source_properties(WayneEnterprisesProduct source) {
        var stub = new WayneEnterprisesProductSourceStub(source);
        var sut = new WayneEnterprisesProductImporter(stub);

        List<Product> products = new ArrayList<Product>();
        sut.fetchProducts().forEach(products::add);
        Product actual = products.get(0);

        assertThat(actual.getProductCode()).isEqualTo(source.getId());
        assertThat(actual.getProductName()).isEqualTo(source.getTitle());
        assertThat(actual.getPricing().getListPrice()).isEqualByComparingTo(Integer.toString(source.getListPrice()));
        assertThat(actual.getPricing().getDiscount())
                .isEqualByComparingTo(Integer.toString(source.getListPrice() - source.getSellingPrice()));
    }
}

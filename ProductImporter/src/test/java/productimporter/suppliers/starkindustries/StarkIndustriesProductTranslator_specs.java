package productimporter.suppliers.starkindustries;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;

import productimporter.DomainArgumentsSource;
import productimporter.Product;

import static org.assertj.core.api.Assertions.assertThat;

public class StarkIndustriesProductTranslator_specs {

    @ParameterizedTest
    @DomainArgumentsSource
    void sut_correctly_sets_supplier_name(StarkIndustriesProduct source) {
        var sut = new StarkIndustriesProductTranslator();

        Product actual = sut.translate(source);

        assertNotNull(actual);
        assertThat(actual.getSupplierName()).isEqualTo("STARK");
    }

    @ParameterizedTest
    @DomainArgumentsSource
    void sut_correctly_projects_source_properties(StarkIndustriesProduct source) {
        var sut = new StarkIndustriesProductTranslator();

        Product actual = sut.translate(source);

        assertThat(actual.getProductCode()).isEqualTo(source.getCode());
        assertThat(actual.getProductName()).isEqualTo(source.getName());
        assertThat(actual.getPricing().getListPrice()).isEqualByComparingTo(Integer.toString(source.getListPrice()));
        assertThat(actual.getPricing().getDiscount())
                .isEqualByComparingTo(Integer.toString(source.getDiscountAmount()));
    }

}

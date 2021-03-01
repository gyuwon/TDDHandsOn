package productimporter;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ListPriceFilter_specs {
    @Test
    void sut_implements_ProductValidator() {
        assertThat(ListPriceFilter.class.getInterfaces()).contains(ProductValidator.class);
    }

    @ParameterizedTest
    @CsvSource(value = { "100000,90000,false", "100000,100000,true", "100000,110000,true" })
    void sut_correctly_works(int lowerBound, int listPrice, boolean expected) {
        Pricing pricing = new Pricing(new BigDecimal(listPrice), new BigDecimal(0));
        Product product = new Product("supplierName", "productCode", "productName", pricing);
        var sut = new ListPriceFilter(new BigDecimal(lowerBound));

        boolean actual = sut.isValid(product);

        assertThat(actual).isEqualTo(expected);
    }
}

package productimporter.suppliers.starkindustries;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.assertj.core.groups.Tuple;
import org.junit.jupiter.params.ParameterizedTest;

import productimporter.DomainArgumentsSource;
import productimporter.Product;

public class StarkIndustriesProductImporter_specs {
    @ParameterizedTest
    @DomainArgumentsSource
    void sut_projects_all_products(StarkIndustriesProduct[] sourceProducts, Product[] products) {
        StarkIndustriesProductSource dataSource = mock(StarkIndustriesProductSource.class);
        when(dataSource.getAllProducts()).thenReturn(Arrays.asList(sourceProducts));

        StarkIndustriesProductTranslator translator = mock(StarkIndustriesProductTranslator.class);

        List<Tuple> tuples = IntStream.range(0, Math.min(sourceProducts.length, products.length))
                .mapToObj(i -> Tuple.tuple(sourceProducts[i], products[i])).collect(Collectors.toList());

        for (Tuple tuple : tuples) {
            Object[] values = tuple.toArray();
            when(translator.translate((StarkIndustriesProduct) values[0])).thenReturn((Product) values[1]);
        }

        var sut = new StarkIndustriesProductImporter(dataSource, translator);

        Iterable<Product> actual = sut.fetchProducts();

        assertThat(actual).hasSize(sourceProducts.length);
    }

    @ParameterizedTest
    @DomainArgumentsSource
    void sut_correctly_translates_source_products(StarkIndustriesProduct[] sourceProducts, Product[] products) {
        StarkIndustriesProductSource dataSource = mock(StarkIndustriesProductSource.class);
        when(dataSource.getAllProducts()).thenReturn(Arrays.asList(sourceProducts));

        StarkIndustriesProductTranslator translator = mock(StarkIndustriesProductTranslator.class);

        List<Tuple> tuples = IntStream.range(0, Math.min(sourceProducts.length, products.length))
                .mapToObj(i -> Tuple.tuple(sourceProducts[i], products[i])).collect(Collectors.toList());

        for (Tuple tuple : tuples) {
            Object[] values = tuple.toArray();
            when(translator.translate((StarkIndustriesProduct) values[0])).thenReturn((Product) values[1]);
        }

        var sut = new StarkIndustriesProductImporter(dataSource, translator);

        Iterable<Product> actual = sut.fetchProducts();

        assertThat(actual).containsExactly(products);
    }
}

package productimporter;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public class ProductArgumentResolver implements DomainArgumentResolver {

    @Override
    public Optional<Object> tryResolve(Class<?> parameterType) {
        if (parameterType.equals(Product[].class)) {
            return Optional.of(new Product[] { generate(), generate(), generate() });
        }

        return Optional.empty();
    }

    private static Product generate() {
        String supplierName = "supplierName" + UUID.randomUUID().toString();
        String productCode = "productCode" + UUID.randomUUID().toString();
        String productName = "productName" + UUID.randomUUID().toString();
        var listPrice = new BigDecimal(random.nextInt(100000) + 100000);
        var discount = new BigDecimal(random.nextInt(100000) + 10000);
        var pricing = new Pricing(listPrice, discount);
        return new Product(supplierName, productCode, productName, pricing);
    }

}

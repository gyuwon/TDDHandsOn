package productimporter.suppliers.wayneenterprises;

import java.math.BigDecimal;

import productimporter.Pricing;
import productimporter.Product;

final class WayneEnterprisesProductTranslator {
    public Product translateProduct(WayneEnterprisesProduct source) {
        Pricing pricing = getPricing(source);
        return new Product("WAYNE", source.getId(), source.getTitle(), pricing);
    }

    private Pricing getPricing(WayneEnterprisesProduct source) {
        BigDecimal listPrice = new BigDecimal(source.getListPrice());
        BigDecimal discount = new BigDecimal(source.getListPrice() - source.getSellingPrice());
        return new Pricing(listPrice, discount);
    }
}

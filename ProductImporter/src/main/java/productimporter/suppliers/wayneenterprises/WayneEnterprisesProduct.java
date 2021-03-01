package productimporter.suppliers.wayneenterprises;

public final class WayneEnterprisesProduct {
    private final String id;
    private final String title;
    private final int listPrice;
    private final int sellingPrice;

    public WayneEnterprisesProduct(String id, String title, int listPrice, int sellingPrice) {
        this.id = id;
        this.title = title;
        this.listPrice = listPrice;
        this.sellingPrice = sellingPrice;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getListPrice() {
        return listPrice;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }
}

namespace Inventory.QueryModel
{
    public sealed record ProductView(
        string Id,
        string SupplierName,
        string ProductCode,
        string ProductName,
        decimal ListPrice,
        decimal Discount,
        decimal SellingPrice);
}

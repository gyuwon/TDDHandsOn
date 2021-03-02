namespace Inventory
{
    public sealed class Product
    {
        public Product(
            string supplierName,
            string productCode,
            string productName,
            Pricing pricing)
        {
            SupplierName = supplierName;
            ProductCode = productCode;
            ProductName = productName;
            Pricing = pricing;
        }

        public string Id => $"{SupplierName}:{ProductCode}";

        public string SupplierName { get; }

        public string ProductCode { get; }

        public string ProductName { get; }

        public Pricing Pricing { get; }
    }
}

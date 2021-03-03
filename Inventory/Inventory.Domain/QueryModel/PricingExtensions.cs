namespace Inventory.QueryModel
{
    internal static class PricingExtensions
    {
        public static decimal CalculateSellingPrice(this Pricing pricing)
            => pricing.ListPrice - pricing.Discount;
    }
}

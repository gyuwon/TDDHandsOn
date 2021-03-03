using Inventory.Queries;
using System.Collections.Immutable;
using System.Threading;
using System.Threading.Tasks;

namespace Inventory.QueryModel
{
    public sealed class GetAllProductQueryProcessor
    {
        private readonly IProductReader _reader;

        public GetAllProductQueryProcessor(IProductReader reader) => _reader = reader;

        public async Task<ImmutableArray<ProductView>> ProcessQuery(
            GetAllProducts query,
            CancellationToken cancellationToken = default)
        {
            return ImmutableArray.CreateRange(
                items: await _reader.GetAllProducts(cancellationToken),
                selector: Transform);
        }

        private ProductView Transform(Product source) =>
            new ProductView(
                source.Id,
                source.SupplierName,
                source.ProductCode,
                source.ProductName,
                source.Pricing.ListPrice,
                source.Pricing.Discount,
                source.Pricing.CalculateSellingPrice());
    }
}

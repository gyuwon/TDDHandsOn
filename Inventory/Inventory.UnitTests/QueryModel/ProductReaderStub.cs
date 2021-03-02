using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading;
using System.Threading.Tasks;

namespace Inventory.QueryModel
{
    public class ProductReaderStub : IProductReader
    {
        private readonly ImmutableArray<Product> _products;

        public ProductReaderStub(ImmutableArray<Product> products)
            => _products = products;

        public static IProductReader Create(IEnumerable<Product> products)
            => new ProductReaderStub(products.ToImmutableArray());

        public Task<ImmutableArray<Product>> GetAllProducts(CancellationToken cancellationToken)
            => Task.FromResult(_products);
    }
}

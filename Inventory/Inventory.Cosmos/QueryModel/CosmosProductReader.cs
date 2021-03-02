using Microsoft.Azure.Cosmos;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading;
using System.Threading.Tasks;

namespace Inventory.QueryModel
{
    public sealed class CosmosProductReader : IProductReader
    {
        private readonly Container _container;

        public CosmosProductReader(Container container) => _container = container;

        public async Task<ImmutableArray<Product>> GetAllProducts(CancellationToken cancellationToken = default)
        {
            var query = new QueryDefinition("SELECT * FROM c");
            FeedIterator<Product> iterator = _container.GetItemQueryIterator<Product>(query);

            var items = new List<Product>();

            while (iterator.HasMoreResults)
            {
                items.AddRange(await iterator.ReadNextAsync(cancellationToken));
            }

            return ImmutableArray.CreateRange(items);
        }
    }
}

using Microsoft.Azure.Cosmos;
using System.Net;
using System.Threading;
using System.Threading.Tasks;

namespace Inventory.CommandModel
{
    public sealed class CosmosProductRepository : IProductRepository
    {
        private readonly Container _container;

        public CosmosProductRepository(Container container) => _container = container;
        public Task CreateOrReplaceProduct(
            Product product,
            CancellationToken cancellationToken = default)
        {
            return _container.UpsertItemAsync(product);
        }

        public async Task<Product?> FindProduct(
            string supplierName,
            string productCode,
            CancellationToken cancellationToken = default)
        {
            try
            {
                return await GetProduct(supplierName, productCode, cancellationToken);
            }
            catch (CosmosException exception) when (exception.StatusCode == HttpStatusCode.NotFound)
            {
                return null;
            }
        }

        private async Task<Product> GetProduct(
            string supplierName,
            string productCode,
            CancellationToken cancellationToken)
        {
            string id = $"{supplierName}:{productCode}";
            var partitionKey = new PartitionKey(id);
            return await _container.ReadItemAsync<Product>(id, partitionKey, cancellationToken: cancellationToken);
        }
    }
}

using AutoFixture.Xunit2;
using FluentAssertions;
using Microsoft.Azure.Cosmos;
using Microsoft.Azure.Cosmos.Fluent;
using System;
using System.Threading.Tasks;
using Xunit;

namespace Inventory.CommandModel
{
    public class CosmosProductRepository_specs
    {
        private static readonly Lazy<Container> _container = new Lazy<Container>(() => CosmosContainerFactory().GetAwaiter().GetResult());

        private static async Task<Container> CosmosContainerFactory()
        {
            string connectionString = "AccountEndpoint=https://localhost:8081/;AccountKey=C2y6yDjf5/R+ob0N8A7Cgv30VRDJIWEHLM+4QDU5DE2nQ9nDuVTqobD4b8mGGyPMbIZnqyMsEcaGQy67XIw/Jw==";
            var serializerOptions = new CosmosSerializationOptions { PropertyNamingPolicy = CosmosPropertyNamingPolicy.CamelCase };
            CosmosClient client = new CosmosClientBuilder(connectionString).WithSerializerOptions(serializerOptions).Build();

            await client.CreateDatabaseIfNotExistsAsync("UnitTesting");
            Database database = client.GetDatabase("UnitTesting");

            var containerProperties = new ContainerProperties(id: "Default", partitionKeyPath: "/id");
            await database.CreateContainerIfNotExistsAsync(containerProperties);
            return database.GetContainer("Default");
        }

        private static Container GetCosmosContainer() => _container.Value;

        [Theory, AutoData]
        public async Task FindProduct_correctly_returns_entity(Product product)
        {
            Container container = GetCosmosContainer();
            await container.CreateItemAsync(product);
            var sut = new CosmosProductRepository(container);

            Product? actual = await sut.FindProduct(product.SupplierName, product.ProductCode);

            actual.Should().BeEquivalentTo(product);
        }

        [Theory, AutoData]
        public async Task FindProduct_returns_null_if_product_not_exists(
            string supplierName, string productCode)
        {
            Container container = GetCosmosContainer();
            var sut = new CosmosProductRepository(container);

            Product? actual = await sut.FindProduct(supplierName, productCode);

            actual.Should().BeNull();
        }

        [Theory, AutoData]
        public async Task CreateOrReplaceProduct_correctly_creates_new_product(Product product)
        {
            Container container = GetCosmosContainer();
            var sut = new CosmosProductRepository(container);

            await sut.CreateOrReplaceProduct(product);

            Product? actual = await sut.FindProduct(product.SupplierName, product.ProductCode);
            actual.Should().BeEquivalentTo(product);
        }

        [Theory, AutoData]
        public async Task CreateOrReplaceProduct_correctly_updates_existing_product(
            Product source, string productName, Pricing pricing)
        {
            Container container = GetCosmosContainer();
            await container.CreateItemAsync(source);
            var sut = new CosmosProductRepository(container);
            var product = new Product(source.SupplierName, source.ProductCode, productName, pricing);

            await sut.CreateOrReplaceProduct(product);

            Product? actual = await sut.FindProduct(source.SupplierName, source.ProductCode);
            actual.Should().BeEquivalentTo(product);
        }
    }
}

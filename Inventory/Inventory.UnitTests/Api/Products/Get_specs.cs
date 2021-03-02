using AutoFixture.Xunit2;
using FluentAssertions;
using Inventory.QueryModel;
using Microsoft.Extensions.DependencyInjection;
using System.Collections.Immutable;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using Xunit;

namespace Inventory.Api.Products
{
    public class Get_specs
    {
        private const string Path = "/api/products";

        private static HttpClient BuildClient(params Product[] products)
        {
            var factory = new AppFactory();
            factory.ConfigureTestServices += services => services.AddSingleton(ProductReaderStub.Create(products));
            return factory.CreateClient();
        }

        [Theory, AutoData]
        public async Task sut_returns_ok_status_code(Product[] products)
        {
            HttpClient client = BuildClient(products);
            HttpResponseMessage response = await client.GetAsync(Path);
            response.StatusCode.Should().Be(HttpStatusCode.OK);
        }

        [Theory, AutoData]
        public async Task sut_returns_all_product_views(Product[] products)
        {
            HttpClient client = BuildClient(products);

            HttpResponseMessage response = await client.GetAsync(Path);

            ImmutableArray<ProductView> actual = await response.Content.ReadAsAsync<ImmutableArray<ProductView>>();
            actual.Should().BeEquivalentTo(products, c => c.Including(x => x.SupplierName).Including(x => x.ProductCode));
        }
    }
}

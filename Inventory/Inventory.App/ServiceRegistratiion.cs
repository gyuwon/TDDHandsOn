using Inventory.QueryModel;
using Microsoft.Azure.Cosmos;
using Microsoft.Azure.Cosmos.Fluent;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using System;

namespace Inventory.App
{
    public static class ServiceRegistratiion
    {
        public static void AddDomainServices(this IServiceCollection services)
        {
            services.AddSingleton(ResolveCosmosContainer);
            services.AddSingleton<IProductReader, CosmosProductReader>();
            services.AddSingleton<GetAllProductQueryProcessor>();
        }

        private static Container ResolveCosmosContainer(IServiceProvider serviceProvider)
        {
            IConfiguration config = serviceProvider.GetRequiredService<IConfiguration>();

            string connectionString = config["Cosmos:ConnectionString"];
            string databaseId = config["Cosmos:DatabaseId"];
            string containerId = config["Cosmos:Containers:Products"];

            return new CosmosClientBuilder(connectionString)
                .Build()
                .GetDatabase(databaseId)
                .GetContainer(containerId);
        }
    }
}

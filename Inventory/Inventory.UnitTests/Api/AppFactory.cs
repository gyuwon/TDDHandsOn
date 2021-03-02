using Inventory.App;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Mvc.Testing;
using Microsoft.AspNetCore.TestHost;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using System;
using System.Collections.Generic;

namespace Inventory.Api
{
    public class AppFactory : WebApplicationFactory<Startup>
    {
        public event Action<IServiceCollection>? ConfigureTestServices;

        public Dictionary<string, string> Settings { get; } = new Dictionary<string, string>
        {
            ["Cosmos:ConnectionString"] = "AccountEndpoint=https://localhost:8081/;AccountKey=C2y6yDjf5/R+ob0N8A7Cgv30VRDJIWEHLM+4QDU5DE2nQ9nDuVTqobD4b8mGGyPMbIZnqyMsEcaGQy67XIw/Jw==",
            ["Cosmos:DatabaseId"] = "UnitTesting",
            ["Cosmos:Containers:Products"] = "Products",
        };

        protected override void ConfigureWebHost(IWebHostBuilder builder)
        {
            Action<IServiceCollection>? configure = ConfigureTestServices;
            if (configure != null)
            {
                builder.ConfigureTestServices(configure);
            }

            builder.ConfigureAppConfiguration(c => c.AddInMemoryCollection(Settings));
        }
    }
}

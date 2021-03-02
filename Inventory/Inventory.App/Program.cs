using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Hosting;

namespace Inventory.App
{
    public class Program
    {
        public static void Main(string[] args)
            => CreateHostBuilder(args).Build().Run();

        public static IHostBuilder CreateHostBuilder(string[] args)
            => Host.CreateDefaultBuilder(args).ConfigureWebHostDefaults(ConfigureHost);

        private static void ConfigureHost(IWebHostBuilder webBuilder)
            => webBuilder.UseStartup<Startup>();
    }
}

using Inventory.Queries;
using Inventory.QueryModel;
using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Threading;
using System.Threading.Tasks;

namespace Inventory.App.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ProductsController : ControllerBase
    {
        [HttpGet]
        public async Task<IEnumerable<ProductView>> Get(
            [FromServices] GetAllProductQueryProcessor queryProcessor,
            CancellationToken cancellationToken)
        {
            var query = new GetAllProducts();
            return await queryProcessor.ProcessQuery(query, cancellationToken);
        }
    }
}

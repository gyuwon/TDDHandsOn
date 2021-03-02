using System.Collections.Immutable;
using System.Threading;
using System.Threading.Tasks;

namespace Inventory.QueryModel
{
    public interface IProductReader
    {
        Task<ImmutableArray<Product>> GetAllProducts(CancellationToken cancellationToken);
    }
}

using System.Threading;
using System.Threading.Tasks;

namespace Inventory.CommandModel
{
    public interface IProductRepository
    {
        Task CreateOrReplaceProduct(
            Product product,
            CancellationToken cancellationToken);

        Task<Product?> FindProduct(
            string supplierName,
            string productCode,
            CancellationToken cancellationToken);
    }
}

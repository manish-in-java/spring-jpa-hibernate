package org.example.data.inventory;

import org.example.data.ModelRepository;
import org.example.domain.inventory.Stock;

import java.util.List;

/**
 * Contract for data access operations on {@link Stock}.
 */
public interface StockRepository extends ModelRepository<Stock>
{
  /**
   * Finds the number of stock items for a specific product.
   *
   * @param product The name of the product for which stock item count is required.
   * @return The number number of stock items for the specific product.
   */
  Long countByProduct(String product);

  /**
   * Finds all stock for a specified product with a given
   * batch and lot number and quantity greater than a
   * specified value.
   *
   * @param product  The product for which the stock is
   *                 required.
   * @param batch    The batch number for the required stock.
   * @param lot      The lot number for the required stock.
   * @param quantity The minimum stock quantity to search.
   * @return A {@link List} of {@link Stock}s.
   */
  List<Stock> findAllByProductAndBatchAndLotAndQuantityGreaterThan(String product, String batch, String lot, int quantity);
}

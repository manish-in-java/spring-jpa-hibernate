package org.example.domain.inventory;

import org.example.domain.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Represents stock for a product.
 */
@Entity
@Table(name = "stock")
public class Stock extends Model
{
  @Column(name = "batch", updatable = false)
  private String batch;

  @Column(name = "lot", updatable = false)
  private String lot;

  @Column(name = "product", updatable = false)
  @NotNull
  private String product;

  @Column(name = "quantity")
  @NotNull
  private int quantity = 0;

  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  Stock()
  {
    super();
  }

  /**
   * Creates stock for a product with specified information.
   *
   * @param product  The product for the stock.
   * @param batch    An optional manufacturing batch number for
   *                 the stock.
   * @param lot      An optional shipping lot number for the
   *                 stock.
   * @param quantity The stock quantity.
   */
  public Stock(final String product, final String batch, final String lot, final int quantity)
  {
    this();

    this.batch = batch;
    this.lot = lot;
    this.product = product;
    this.quantity = quantity;
  }

  /**
   * Gets an optional manufacturing batch number for the stock.
   *
   * @return An optional manufacturing batch number for the stock.
   */
  public String getBatch()
  {
    return batch;
  }

  /**
   * Gets an optional shipping lot number for the stock.
   *
   * @return An optional shipping lot number for the stock.
   */
  public String getLot()
  {
    return lot;
  }

  /**
   * Gets the product for the stock.
   *
   * @return The product for the stock.
   */
  public String getProduct()
  {
    return product;
  }

  /**
   * Gets the current stock quantity.
   *
   * @return The current stock quantity.
   */
  public int getQuantity()
  {
    return quantity;
  }
}

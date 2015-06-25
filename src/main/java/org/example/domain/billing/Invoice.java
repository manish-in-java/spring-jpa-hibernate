package org.example.domain.billing;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Represents an invoice (a bill).
 */
@Entity
@Table(name = "invoice")
public class Invoice
{
  @Column(name = "id")
  @Id
  private Long id;

  @Column(name = "date")
  @NotNull
  private Date date;

  @Column(name = "total")
  @NotNull
  private BigDecimal total;

  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  Invoice()
  {
    super();
  }

  /**
   * Creates an invoice with a specified identifier, date and total amount.
   *
   * @param id    The unique identifier for the invoice.
   * @param date  The invoice date.
   * @param total The total amount for the invoice.
   */
  public Invoice(final Long id, final Date date, final BigDecimal total)
  {
    this();

    this.date = date;
    this.id = id;
    this.total = total;
  }

  /**
   * Gets the invoice date.
   *
   * @return The invoice date.
   */
  public Date getDate()
  {
    return date;
  }

  /**
   * Gets the unique identifier for the invoice.
   *
   * @return The unique identifier for the invoice.
   */
  public Long getID()
  {
    return id;
  }

  /**
   * Gets total amount for the invoice.
   *
   * @return The total amount for the invoice.
   */
  public BigDecimal getTotal()
  {
    return total;
  }
}

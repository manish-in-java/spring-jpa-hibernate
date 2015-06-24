package org.example.domain.billing;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

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

  Invoice()
  {
    super();
  }

  public Invoice(final Long id, final Date date, final BigDecimal total)
  {
    this.date = date;
    this.id = id;
    this.total = total;
  }

  public Date getDate()
  {
    return date;
  }

  public Long getID()
  {
    return id;
  }

  public BigDecimal getTotal()
  {
    return total;
  }
}

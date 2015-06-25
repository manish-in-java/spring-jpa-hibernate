package org.example.data.billing;

import org.example.data.DataTest;
import org.example.domain.billing.Invoice;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Integration tests for {@link InvoiceRepository}.
 */
@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class InvoiceRepositoryTest extends DataTest
{
  @Autowired
  private InvoiceRepository invoiceRepository;

  /**
   * Adds some invoices for the tests to run.
   */
  @Before
  public void setup()
  {
    for (int i = 0; i < getInt(); ++i)
    {
      invoiceRepository.saveAndFlush(new Invoice(new Long(i + 1), new Date(), BigDecimal.TEN));
    }
  }

  /**
   * Tests that invoices can be loaded successfully.
   */
  @Test
  public void testFindAll()
  {
    final List<Invoice> invoices = invoiceRepository.findAll();

    Assert.assertFalse(invoices.isEmpty());

    for (final Invoice invoice : invoices)
    {
      Assert.assertNotNull(invoice.getDate());
      Assert.assertNotNull(invoice.getID());
      Assert.assertNotNull(invoice.getTotal());
    }
  }
}

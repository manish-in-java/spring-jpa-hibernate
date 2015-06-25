package org.example.data.inventory;

import org.example.data.DataTest;
import org.example.domain.inventory.Stock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Integration tests for {@link StockRepository}.
 */
@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class StockRepositoryTest extends DataTest
{
  private static final String BATCH   = "Batch 1";
  private static final String LOT     = "Lot 1";
  private static final String PRODUCT = "Product";

  @Autowired
  private StockRepository stockRepository;

  /**
   * Adds some stock
   */
  @Before
  public void setup()
  {
    IntStream.range(0, getInt()).forEach(i -> {
      stockRepository.saveAndFlush(new Stock(PRODUCT, BATCH, LOT, 100));
    });
  }

  /**
   * Tests that stock can be detached from the persistence context if required.
   */
  @Test
  public void testDetach()
  {
    final List<Stock> stocks = stockRepository.findAllByExample(new Stock(PRODUCT, BATCH, LOT, 100));

    Assert.assertNotNull(stocks);
    Assert.assertNotEquals(0, stocks.size());

    stocks.forEach(stock -> {
      Assert.assertEquals(stock, stockRepository.detach(stock));
    });
  }

  /**
   * Tests that stock can be loaded by providing other stock as example.
   */
  @Test
  public void testFindAllByExample()
  {
    final List<Stock> stocks = stockRepository.findAllByExample(new Stock(PRODUCT, BATCH, LOT, 100));

    Assert.assertNotNull(stocks);
    Assert.assertNotEquals(0, stocks.size());

    stocks.forEach(stock -> {
      Assert.assertNotNull(stock.getBatch());
      Assert.assertNotNull(stock.getLot());
      Assert.assertNotNull(stock.getProduct());
      Assert.assertNotEquals(0, stock.getQuantity());
    });
  }

  /**
   * Tests that stock can be found using Spring Data JPA query methods.
   */
  @Test
  public void testFindAllByProductAndBatchAndLotAndQuantityGreaterThan()
  {
    final List<Stock> stocks = stockRepository.findAllByProductAndBatchAndLotAndQuantityGreaterThan(PRODUCT, BATCH, LOT, 0);

    Assert.assertNotNull(stocks);
    Assert.assertNotEquals(0, stocks.size());

    stocks.forEach(stock -> {
      Assert.assertNotNull(stock.getBatch());
      Assert.assertNotNull(stock.getLot());
      Assert.assertNotNull(stock.getProduct());
      Assert.assertNotEquals(0, stock.getQuantity());
    });
  }

  /**
   * Tests that stock can be refreshed from the database if required.
   */
  @Test
  public void testRefresh()
  {
    final List<Stock> stocks = stockRepository.findAllByExample(new Stock(PRODUCT, BATCH, LOT, 100));

    Assert.assertNotNull(stocks);
    Assert.assertNotEquals(0, stocks.size());

    stocks.forEach(stock -> {
      Assert.assertEquals(stock, stockRepository.refresh(stock));
    });
  }
}

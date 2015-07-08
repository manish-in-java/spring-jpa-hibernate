package org.example.data.game;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for {@link PlayerRepository}.
 */
@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class PlayerRepositoryTest
{
  @Autowired
  private PlayerRepository repository;

  /**
   * Finds a player with a specified identifier.
   */
  @Test
  public void testFindOne()
  {
    repository.findAll().forEach(player -> {
      Assert.assertNotNull(player);
      Assert.assertNotNull(player.getHandle());
      Assert.assertNotNull(player.getID());

      player.getCards().forEach(card -> {
        Assert.assertNotNull(card);
        Assert.assertNotNull(card.getCard());
        Assert.assertNotNull(card.getCard().getID());
        Assert.assertNotNull(card.getCard().getType());
        Assert.assertNotNull(card.getID());
        Assert.assertNotNull(card.getPlayer());
        Assert.assertNotNull(card.getType());

        System.out.println(String.format("%3d %10s %3d %10s %20s %3d %10s %15s %3d"
            , player.getID()
            , player.getHandle()
            , card.getID()
            , card.getType()
            , card.getClass().getSimpleName()
            , card.getCard().getID()
            , card.getCard().getType()
            , card.getCard().getClass().getSimpleName()
            , card.getCard().getDuration()));
      });
    });
  }
}

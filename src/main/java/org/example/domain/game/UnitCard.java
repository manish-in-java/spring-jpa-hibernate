package org.example.domain.game;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Represents a card for a playing unit within a game.
 */
@Entity
@DiscriminatorValue("unit")
public class UnitCard extends Card
{
  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  UnitCard()
  {
    super();
  }

  /**
   * {@inheritDoc}
   */
  public int getDuration()
  {
    return 10;
  }
}

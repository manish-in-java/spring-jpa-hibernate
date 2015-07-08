package org.example.domain.game;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Represents a card for a hero unit within a game.
 */
@Entity
@DiscriminatorValue("hero")
public class HeroCard extends UnitCard
{
  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  HeroCard()
  {
    super();
  }

  /**
   * {@inheritDoc}
   */
  public int getDuration()
  {
    return 60;
  }
}

package org.example.domain.game;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Represents a card that grants a particular ability to a player
 * within a game.
 */
@Entity
@DiscriminatorValue("ability")
public class AbilityCard extends Card
{
  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  AbilityCard()
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

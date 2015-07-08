package org.example.domain.game;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Represents a card that grants leadership ability to a player
 * within a game.
 */
@Entity
@DiscriminatorValue("leader")
public class LeaderCard extends AbilityCard
{
  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  LeaderCard()
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

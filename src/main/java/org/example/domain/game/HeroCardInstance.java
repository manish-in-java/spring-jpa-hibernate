package org.example.domain.game;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Represents a hero card assigned to a player
 * within a game.
 */
@Entity
@DiscriminatorValue("hero")
public class HeroCardInstance extends CardInstance<HeroCard>
{
  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  HeroCardInstance()
  {
    super();
  }
}

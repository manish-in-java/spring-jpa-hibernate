package org.example.domain.game;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Represents an ability card assigned to a player
 * within a game.
 */
@Entity
@DiscriminatorValue("ability")
public class AbilityCardInstance extends CardInstance<AbilityCard>
{
  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  AbilityCardInstance()
  {
    super();
  }
}

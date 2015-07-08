package org.example.domain.game;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Represents a playing unit card assigned to a player
 * within a game.
 */
@Entity
@DiscriminatorValue("unit")
public class UnitCardInstance extends CardInstance<UnitCard>
{
  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  UnitCardInstance()
  {
    super();
  }
}

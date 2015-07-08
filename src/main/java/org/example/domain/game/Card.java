package org.example.domain.game;

import org.example.domain.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Represents a card that can be used in a game.
 */
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Entity
@Inheritance
@Table(name = "card")
public abstract class Card extends Model
{
  @Column(insertable = false, name = "type", updatable = false)
  @NotNull
  private String type;

  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  Card()
  {
    super();
  }

  /**
   * Gets the type of card.
   *
   * @return The type of card.
   */
  public String getType()
  {
    return type;
  }

  /**
   * Gets the duration for which the card is valid, in minutes.
   *
   * @return The duration for which the card is valid.
   */
  public abstract int getDuration();
}

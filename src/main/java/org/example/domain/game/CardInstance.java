package org.example.domain.game;

import org.example.domain.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Represents a card held by a player within a game.
 */
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Entity
@Inheritance
@Table(name = "card_instance")
public abstract class CardInstance<C extends Card> extends Model
{
  @JoinColumn(name = "card_id", updatable = false)
  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Card.class)
  @NotNull
  private C card;

  @JoinColumn(name = "player_id", updatable = false)
  @ManyToOne
  @NotNull
  private Player player;

  @Column(insertable = false, name = "type", updatable = false)
  @NotNull
  private String type;

  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  CardInstance()
  {
    super();
  }

  /**
   * Gets the card assigned to the player.
   *
   * @return The card assigned to the player.
   */
  public C getCard()
  {
    return card;
  }

  /**
   * Gets the player to whom the card has been assigned.
   *
   * @return The player to whom the card has been assigned.
   */
  public Player getPlayer()
  {
    return player;
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
}

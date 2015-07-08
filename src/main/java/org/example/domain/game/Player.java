package org.example.domain.game;

import org.example.domain.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Represents a player in a game.
 */
@Entity
@Table(name = "player")
public class Player extends Model
{
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "player", fetch = FetchType.LAZY, orphanRemoval = true)
  private List<CardInstance> cards;

  @Column(name = "handle")
  @NotNull
  @Size(max = 100)
  private String handle;

  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  Player()
  {
    super();
  }

  /**
   * Gets the cards held by the player.
   *
   * @return A {@link List} of {@link CardInstance}s.
   */
  public List<CardInstance> getCards()
  {
    return cards;
  }

  /**
   * Gets the player handle.
   *
   * @return The player handle.
   */
  public String getHandle()
  {
    return handle;
  }
}

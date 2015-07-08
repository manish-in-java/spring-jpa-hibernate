package org.example.data.game;

import org.example.data.ModelRepository;
import org.example.domain.game.Player;

/**
 * Contract for data access operations on {@link Player}.
 */
public interface PlayerRepository extends ModelRepository<Player>
{
  /**
   * Finds a player with a specified handle.
   *
   * @param handle The player handle to find.
   * @return A {@link Player}.
   */
  Player findByHandle(String handle);
}

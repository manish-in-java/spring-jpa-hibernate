package org.example.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * Contract for extended functionality on JPA entities.
 */
@NoRepositoryBean
public interface IExtendedJpaRepository<T, ID extends Serializable>
    extends JpaRepository<T, ID>
{
  /**
   * Removes an entity from the persistence context, causing
   * a managed entity to become detached.  Unflushed changes made
   * to the entity, if any (including removal of the entity),
   * will not be synchronized to the database.  Entities which
   * previously referenced the detached entity will continue to
   * reference it.
   *
   * @param entity The entity to detach.
   * @return The detached entity.
   * @throws IllegalArgumentException if the instance is not an
   *                                  entity.
   */
  T detach(T entity);

  /**
   * Finds an entity instance using another instance as an example.
   *
   * @param example The entity instance to use as an example.
   * @return A {@link List} of entities with property values matching
   * those in the example.
   */
  List<T> findAllByExample(T example);

  /**
   * Refreshes the state of an entity instance from the database,
   * overwriting changes made to the entity, if any.
   *
   * @param entity The entity instance to refresh.
   * @return The refreshed entity.
   * @throws IllegalArgumentException                       if the instance is
   *                                                        not an entity or the entity is not managed.
   * @throws javax.persistence.TransactionRequiredException if invoked on a container-managed entity manager
   *                                                        of type <code>PersistenceContextType.TRANSACTION</code>
   *                                                        and there is no transaction.
   * @throws javax.persistence.EntityNotFoundException      if the entity no longer exists in the database.
   */
  T refresh(T entity);
}

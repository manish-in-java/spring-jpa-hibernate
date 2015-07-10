package org.example.data;

import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

/**
 * Offers extended functionality on JPA entities in addition to
 * that already offered by {@link SimpleJpaRepository}.
 */
public class ExtendedJpaRepository<T, ID extends Serializable>
    extends SimpleJpaRepository<T, ID>
    implements IExtendedJpaRepository<T, ID>
{
  private EntityManager entityManager;

  /**
   * Creates a new {@link SimpleJpaRepository} to manage objects of the given domain type.
   *
   * @param entityClass   must not be {@literal null}.
   * @param entityManager must not be {@literal null}.
   */
  public ExtendedJpaRepository(final Class<T> entityClass, final EntityManager entityManager)
  {
    super(entityClass, entityManager);

    this.entityManager = entityManager;
  }

  /**
   * {@inheritDoc}
   */
  public <S extends T> S detach(final S entity)
  {
    entityManager.detach(entity);

    return entity;
  }

  /**
   * {@inheritDoc}
   */
  public List<T> findAllByExample(final T example)
  {
    return ((Session) entityManager.getDelegate())
        .createCriteria(getDomainClass())
        .add(Example.create(example))
        .list();
  }

  /**
   * {@inheritDoc}
   */
  public <S extends T> S refresh(final S entity)
  {
    entityManager.refresh(entity);

    return entity;
  }

  /*
   * {@inheritDoc}
   */
  @Transactional
  public <S extends T> S saveAndFlushAndDetach(final S entity)
  {
    saveAndFlush(entity);

    return detach(entity);
  }
}

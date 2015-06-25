package org.example.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Creates instances of {@link ExtendedJpaRepository}.
 */
public class ExtendedJpaRepositoryFactoryBean<R extends JpaRepository<T, ID>, T, ID extends Serializable>
    extends JpaRepositoryFactoryBean<R, T, ID>
{
  /**
   * {@inheritDoc}
   */
  @Override
  protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager)
  {
    return new ExtendedJpaRepositoryFactory(entityManager);
  }

  /**
   * Extends JPA repository factory.
   *
   * @param <T>  The type of entities managed by the repository
   *             created by the factory.
   * @param <ID> The type of primary key of the entities managed
   *             by the repository created by the factory.
   */
  private static class ExtendedJpaRepositoryFactory<T, ID extends Serializable>
      extends JpaRepositoryFactory
  {
    private EntityManager entityManager;

    /**
     * Creates a new {@link ExtendedJpaRepositoryFactory}.
     *
     * @param entityManager must not be {@literal null}
     */
    public ExtendedJpaRepositoryFactory(final EntityManager entityManager)
    {
      super(entityManager);

      this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    protected Object getTargetRepository(final RepositoryMetadata metadata)
    {
      return new ExtendedJpaRepository<T, ID>((Class<T>) metadata.getDomainType(), entityManager);
    }

    /**
     * {@inheritDoc}
     */
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata)
    {
      return IExtendedJpaRepository.class;
    }
  }
}

package org.example.data;

import org.example.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Contract for data access operations on a domain entity.
 *
 * @param <T> The type of domain entity.
 */
@NoRepositoryBean
public interface ModelRepository<T extends Model> extends JpaRepository<T, Long>
{
}

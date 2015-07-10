package org.example.data.hiring;

import org.example.data.IExtendedJpaRepository;
import org.example.domain.hiring.Language;

/**
 * Contract for data access operations on {@link Language}.
 */
public interface LanguageRepository extends IExtendedJpaRepository<Language, String>
{
  /**
   * Finds a language by its code.
   *
   * @param code The language code to find.
   * @return A {@link Language}.
   */
  Language findByCode(String code);
}

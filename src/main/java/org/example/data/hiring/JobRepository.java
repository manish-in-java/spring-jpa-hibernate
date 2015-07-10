package org.example.data.hiring;

import org.example.data.ModelRepository;
import org.example.domain.hiring.Job;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Contract for data access operations on {@link Job}.
 */
public interface JobRepository extends ModelRepository<Job>
{
  /**
   * Finds all jobs for which the only languages required have the specified codes.
   * Matches only those jobs where the required languages exactly match the specified
   * codes.
   *
   * @param languageCodes The language codes to find.
   * @return A {@link List} of {@link Job}s with language requirement matching the
   * specified codes.
   */
  @Query(nativeQuery = true
      , value = "SELECT "
      + "  * "
      + "FROM"
      + "  job "
      + "WHERE "
      + "  id IN "
      + "  ( "
      + "  SELECT "
      + "    jl1.job_id "
      + "  FROM "
      + "    job_language jl1 "
      + "  LEFT JOIN "
      + "    job_language jl2 "
      + "  ON "
      + "    jl1.job_id = jl2.job_id "
      + "  AND jl1.language_code = jl2.language_code "
      + "  AND jl2.language_code IN ?1 "
      + "  GROUP BY "
      + "    jl1.job_id "
      + "  HAVING "
      + "    COUNT(jl1.language_code) = COUNT(jl2.language_code) "
      + "  )")
  List<Job> findAllByLanguageCodes(String... languageCodes);
}

package org.example.domain.hiring;

import org.example.domain.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a job.
 */
@Entity
@Table(name = "job")
public class Job extends Model
{
  @JoinTable(inverseJoinColumns = @JoinColumn(name = "language_code")
      , joinColumns = @JoinColumn(name = "job_id")
      , name = "job_language")
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Language> languages;

  @Column(name = "title")
  @NotNull
  @Size(max = 50)
  private String title;

  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  Job()
  {
    super();
  }

  /**
   * Creates a job with a specified title.
   *
   * @param title The job title.
   */
  public Job(final String title)
  {
    this();

    this.title = title;
  }

  /**
   * Adds a language required for this job.
   *
   * @param language The language to add.
   */
  public void addLanguage(final Language language)
  {
    if (languages == null)
    {
      languages = new LinkedList<>();
    }

    languages.add(language);
  }

  /**
   * Gets the languages required for this job.
   *
   * @return The languages required for this job.
   */
  public List<Language> getLanguages()
  {
    return languages;
  }

  /**
   * Gets the job title.
   *
   * @return The job title.
   */
  public String getTitle()
  {
    return title;
  }
}

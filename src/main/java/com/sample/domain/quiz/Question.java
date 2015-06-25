package com.sample.domain.quiz;

import com.sample.domain.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Represents a question.
 */
@Entity
@Table(name = "question")
public class Question extends Model
{
  @Column(name = "title")
  @NotNull
  @Size(max = 100)
  private String title;

  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  Question()
  {
    super();
  }

  /**
   * Creates a question with a specified title.
   *
   * @param title The question title.
   */
  public Question(final String title)
  {
    this();

    this.title = title.trim();
  }

  /**
   * Gets the question title.
   *
   * @return The question title.
   */
  public String getTitle()
  {
    return title;
  }
}

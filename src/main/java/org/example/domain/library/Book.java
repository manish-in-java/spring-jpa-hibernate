package org.example.domain.library;

import org.example.domain.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Represents a book in a library.
 */
@Entity
@Table(name = "book")
public class Book extends Model
{
  @Column(name = "title")
  @NotNull
  @Size(max = 100)
  private String title;

  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  Book()
  {
    super();
  }

  /**
   * Creates a book with a specified title.
   *
   * @param title The book title.
   */
  public Book(final String title)
  {
    this();

    this.title = title.trim();
  }

  /**
   * Gets the book title.
   *
   * @return The book title.
   */
  public String getTitle()
  {
    return title;
  }
}

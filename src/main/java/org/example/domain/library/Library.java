package org.example.domain.library;

import org.example.domain.Model;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a library.
 */
@Entity
@Table(name = "library")
public class Library extends Model
{
  @JoinTable(inverseJoinColumns = @JoinColumn(name = "book_id"), joinColumns = @JoinColumn(name = "library_id"), name = "library_book")
  @LazyCollection(LazyCollectionOption.EXTRA)
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Book> books;

  @Column(name = "name")
  @NotNull
  @Size(max = 100)
  private String name;

  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  Library()
  {
    super();
  }

  /**
   * Creates a library with a specified name.
   *
   * @param name The library name.
   */
  public Library(final String name)
  {
    this();

    this.name = name.trim();
  }

  /**
   * Adds a book to this library.
   *
   * @param book The book to add.
   */
  public void addBook(final Book book)
  {
    if (books == null)
    {
      books = new ArrayList<>();
    }

    books.add(book);
  }

  /**
   * Gets the library name.
   *
   * @return
   */
  public String getName()
  {
    return name;
  }

  /**
   * Gets the books in the library.
   *
   * @return A {@link List} of {@link Book}s.
   */
  public List<Book> getBooks()
  {
    return books;
  }
}

package org.example.domain.library;

import org.example.domain.Model;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "library")
public class Library extends Model
{
  @Column(name = "name")
  @NotNull
  @Size(max = 100)
  private String name;

  @JoinTable(inverseJoinColumns = @JoinColumn(name = "book_id"), joinColumns = @JoinColumn(name = "library_id"), name = "library_book")
  @LazyCollection(LazyCollectionOption.EXTRA)
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Book> books;

  Library()
  {
    super();
  }

  public Library(final String name)
  {
    this();

    this.name = name;
  }

  public void addBook(final Book book)
  {
    if (books == null)
    {
      books = new ArrayList<>();
    }

    books.add(book);
  }

  public String getName()
  {
    return name;
  }

  public List<Book> getBooks()
  {
    return books;
  }
}

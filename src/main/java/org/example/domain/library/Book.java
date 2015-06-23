package org.example.domain.library;

import org.example.domain.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book")
public class Book extends Model
{
  @Column(name = "title")
  @NotNull
  @Size(max = 100)
  private String title;

  Book()
  {
    super();
  }

  public Book(final String title)
  {
    this.title = title;
  }

  public String getTitle()
  {
    return title;
  }
}

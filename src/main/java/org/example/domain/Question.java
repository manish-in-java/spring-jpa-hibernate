package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "question")
public class Question extends Model
{
  @Column(name = "title")
  @NotNull
  @Size(max = 100)
  private String title;

  Question()
  {
    super();
  }

  public Question(final String title)
  {
    this();

    this.title = title;
  }

  public String getTitle()
  {
    return title;
  }
}

package org.example.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "quiz")
public class Quiz extends Model
{
  @Column(name = "name")
  @NotNull
  @Size(max = 100)
  private String name;

  @JoinTable(inverseJoinColumns = @JoinColumn(name = "question_id"), joinColumns = @JoinColumn(name = "quiz_id"), name = "quiz_question")
  @LazyCollection(LazyCollectionOption.EXTRA)
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Question> questions;

  Quiz()
  {
    super();
  }

  public Quiz(final String name)
  {
    this();

    this.name = name;
  }

  public void addQuestion(final Question question)
  {
    if (questions == null)
    {
      questions = new ArrayList<>();
    }

    questions.add(question);
  }

  public String getName()
  {
    return name;
  }

  public List<Question> getQuestions()
  {
    return questions;
  }
}

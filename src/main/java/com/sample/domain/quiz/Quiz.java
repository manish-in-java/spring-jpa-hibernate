package com.sample.domain.quiz;

import org.example.domain.Model;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a quiz.
 */
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

  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  Quiz()
  {
    super();
  }

  /**
   * Creates a quiz with a specified name.
   *
   * @param name quiz name.
   */
  public Quiz(final String name)
  {
    this();

    this.name = name.trim();
  }

  /**
   * Adds a question to this quiz.
   *
   * @param question The question to add.
   */
  public void addQuestion(final Question question)
  {
    if (questions == null)
    {
      questions = new ArrayList<>();
    }

    questions.add(question);
  }

  /**
   * Gets the quiz name.
   *
   * @return The quiz name.
   */
  public String getName()
  {
    return name;
  }

  /**
   * Gets the questions in the quiz.
   *
   * @return A {@link List} of {@link Question}s.
   */
  public List<Question> getQuestions()
  {
    return questions;
  }
}

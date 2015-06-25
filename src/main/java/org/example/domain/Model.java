package org.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Represents a domain entity having its own unique identity.
 */
@MappedSuperclass
public abstract class Model implements Serializable
{
  @Column(name = "id")
  @Generated(GenerationTime.INSERT)
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;

  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  protected Model()
  {
    super();
  }

  /**
   * Gets the unique identifier for this entity instance.
   *
   * @return The unique identifier for this entity instance.
   */
  public Long getID()
  {
    return this.id;
  }
}

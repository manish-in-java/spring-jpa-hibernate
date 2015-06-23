package org.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

@MappedSuperclass
public abstract class Model
{
  @Column(name = "id")
  @Generated(GenerationTime.INSERT)
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;

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

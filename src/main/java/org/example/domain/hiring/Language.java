package org.example.domain.hiring;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Represents a language.
 */
@Entity
@Table(name = "language")
public class Language implements Serializable
{
  @Column(columnDefinition = "CHAR(3)", name = "code")
  @Id
  @NotNull
  @Size(max = 3, min = 3)
  private String code;

  @Column(name = "name")
  @NotNull
  @Size(max = 50)
  private String name;

  /**
   * Deliberately hidden to prevent direct instantiation.
   */
  Language()
  {
    super();
  }

  /**
   * Creates a language with a specified code and name.
   *
   * @param code The language code.
   * @param name The language name.
   */
  public Language(final String code, final String name)
  {
    this();

    this.code = code;
    this.name = name;
  }

  /**
   * Gets the language code.
   *
   * @return The language code.
   */
  public String getCode()
  {
    return code;
  }

  /**
   * Gets the language name.
   *
   * @return The language name.
   */
  public String getName()
  {
    return name;
  }
}

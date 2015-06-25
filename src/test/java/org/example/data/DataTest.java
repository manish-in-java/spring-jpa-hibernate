package org.example.data;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

/**
 * A unit or integration test for the data access layer.
 */
public abstract class DataTest
{
  private static final Random RANDOM = new SecureRandom();

  /**
   * Gets an integer between {@code 1} (inclusive) and {@code 10} (not inclusive).
   *
   * @return An integer between {@code 1} and {@code 10}.
   */
  protected int getInt()
  {
    return getInt(10);
  }

  /**
   * Gets an integer between {@code 1} (inclusive) and a specified maximum value
   * (not inclusive).
   *
   * @param maximum The maximum value of the integer to generate.
   * @return An integer between {@code 1} and {@code maximum}.
   */
  protected int getInt(final int maximum)
  {
    return getInt(1, maximum);
  }

  /**
   * Gets an integer between a specified minimum value (inclusive) and maximum value
   * (not inclusive).
   *
   * @param minimum The minimum value of the integer to generate.
   * @param maximum The maximum value of the integer to generate.
   * @return An integer between {@code minimum} and {@code maximum}.
   */
  protected int getInt(final int minimum, final int maximum)
  {
    return minimum < maximum
        ? minimum + RANDOM.nextInt(maximum)
        : maximum + RANDOM.nextInt(minimum);
  }

  /**
   * Gets a random text string to assign to text fields during tests.
   *
   * @return A random text string.
   */
  protected String getString()
  {
    return UUID.randomUUID().toString();
  }
}

package org.example.data;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

public abstract class DataTest
{
  private static final Random RANDOM = new SecureRandom();

  protected int getInt()
  {
    return getInt(10);
  }

  protected int getInt(final int maximum)
  {
    return getInt(1, maximum);
  }

  protected int getInt(final int minimum, final int maximum)
  {
    return minimum < maximum
        ? minimum + RANDOM.nextInt(maximum)
        : maximum + RANDOM.nextInt(minimum);
  }

  protected String getString()
  {
    return UUID.randomUUID().toString();
  }
}

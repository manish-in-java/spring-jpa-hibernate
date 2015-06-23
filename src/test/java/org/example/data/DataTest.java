package org.example.data;

import java.util.UUID;

public abstract class DataTest
{
  protected String getString()
  {
    return UUID.randomUUID().toString();
  }
}

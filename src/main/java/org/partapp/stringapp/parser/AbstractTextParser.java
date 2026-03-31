package org.partapp.stringapp.parser;

import org.partapp.stringapp.composite.impl.TextComposite;

public abstract class AbstractTextParser {
  protected AbstractTextParser nextParser;

  public void setNextParser(AbstractTextParser nextParser ) {
    this.nextParser = nextParser;
  }

  public abstract TextComposite parse(String text);
}
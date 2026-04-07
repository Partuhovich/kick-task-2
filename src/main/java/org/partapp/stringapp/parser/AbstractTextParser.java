package org.partapp.stringapp.parser;

import org.partapp.stringapp.composite.TextComponent;
import org.partapp.stringapp.composite.impl.TextComposite;
import org.partapp.stringapp.exeption.CustomException;

public abstract class AbstractTextParser {
  private AbstractTextParser nextParser;

  public void setNextSuccessor(AbstractTextParser nextSuccessor) {
    this.nextParser = nextSuccessor;
  }

  public AbstractTextParser getNextSuccessor() {
    return nextParser;
  }

  public abstract void parse(String content, TextComposite parent) throws CustomException;
}
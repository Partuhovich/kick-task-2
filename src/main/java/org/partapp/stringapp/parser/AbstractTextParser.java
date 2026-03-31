package org.partapp.stringapp.parser;

import org.partapp.stringapp.composite.TextComponent;
import org.partapp.stringapp.composite.impl.TextComposite;
import org.partapp.stringapp.exeption.CustomException;
import org.partapp.stringapp.type.TextElementType;

public abstract class AbstractTextParser {
  protected AbstractTextParser nextParser;
  protected final TextElementType type;

  public AbstractTextParser(TextElementType type) {
    this.type = type;
  }

  public void setNextParser(AbstractTextParser nextParser) {
    this.nextParser = nextParser;
  }

  public abstract TextComponent parse(String text) throws CustomException;

  protected TextComponent createComposite() {
    return new TextComposite(type);
  }
}
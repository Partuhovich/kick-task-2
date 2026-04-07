package org.partapp.stringapp.composite.impl;

import org.partapp.stringapp.composite.TextComponent;
import org.partapp.stringapp.type.TextElementType;

public class TextLeaf implements TextComponent {
  TextElementType type;
  private final char content;

  public TextLeaf(TextElementType type, char content) {
    this.type = type;
    this.content = content;
  }

  @Override
  public TextElementType getType() {
    return type;
  }

  @Override
  public int count() {
    return 1;
  }

  @Override
  public String toString() {
    return String.valueOf(content);
  }

  @Override
  public int size() {
    return 0;
  }
}

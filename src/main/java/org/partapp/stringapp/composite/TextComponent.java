package org.partapp.stringapp.composite;

import org.partapp.stringapp.exeption.CustomException;
import org.partapp.stringapp.type.TextElementType;

import java.util.List;

public interface TextComponent {

  TextElementType getType();

  int count();

  String toString();

  default void add(TextComponent component) throws CustomException {
    throw new CustomException("незя");
  }

  default List<TextComponent> getChildren() throws CustomException {
    throw new CustomException("незя");
  }

  default void setChildren(List<TextComponent> children) throws CustomException {
    throw new CustomException("незя");
  }
}

package org.partapp.stringapp.composite.impl;

import org.partapp.stringapp.composite.TextComponent;
import org.partapp.stringapp.exeption.CustomException;
import org.partapp.stringapp.type.TextElementType;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
  private final TextElementType type;
  private final List<TextComponent> components = new ArrayList<>();

  public TextComposite(TextElementType type) {
    this.type = type;
  }

  @Override
  public TextElementType getType() {
    return type;
  }

  @Override
  public int count() {
    return components.stream()
            .mapToInt(TextComponent::count)
            .sum();
  }

  @Override
  public void add(TextComponent component) throws CustomException {
    if (component == null) {
      throw new CustomException("Component cannot be null");
    }
    components.add(component);
  }

  @Override
  public List<TextComponent> getChildren() throws CustomException {
    return new ArrayList<>(components);
  }

  @Override
  public void setChildren(List<TextComponent> children) throws CustomException {
    if (children == null) {
      throw new CustomException("List of children cannot be null");
    }
    this.components.clear();
    this.components.addAll(children);
  }

  @Override
  public String toString(){
    StringBuilder result = new StringBuilder();
    for (TextComponent component : components) {
      result.append(component.toString());
    }
    return result.toString();
  }
}

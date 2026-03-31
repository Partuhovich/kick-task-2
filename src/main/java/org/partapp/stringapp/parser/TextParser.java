package org.partapp.stringapp.parser;

import org.partapp.stringapp.composite.TextComponent;
import org.partapp.stringapp.exeption.CustomException;
import org.partapp.stringapp.type.TextElementType;

public class TextParser extends AbstractTextParser {

  public TextParser() {
    super(TextElementType.TEXT);
  }

  @Override
  public TextComponent parse(String text) throws CustomException {
    if (text == null || text.isEmpty()) {
      throw new CustomException("Text is empty or null");
    }

    TextComponent textComposite = createComposite();

    String[] paragraphs = text.split("\\n\\s*\\n|\\r\\n\\s*\\r\\n");

    for (String paragraph : paragraphs) {
      if (!paragraph.trim().isEmpty()) {
        if (nextParser != null) {
          textComposite.add(nextParser.parse(paragraph.trim()));
        }
      }
    }

    return textComposite;
  }
}
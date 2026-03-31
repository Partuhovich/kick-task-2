package org.partapp.stringapp.parser;

import org.partapp.stringapp.composite.TextComponent;
import org.partapp.stringapp.exeption.CustomException;
import org.partapp.stringapp.type.TextElementType;

public class TextParser extends AbstractTextParser {
  private static final String PARAGRAPH_SPLIT_REGEX = "\\n\\s*\\n|\\r\\n\\s*\\r\\n";

  public TextParser() {
    super(TextElementType.TEXT);
  }

  @Override
  public TextComponent parse(String text) throws CustomException {
    if (text == null || text.isEmpty()) {
      throw new CustomException("Text is empty or null");
    }

    TextComponent textComposite = createComposite();
    String[] paragraphs = text.split(PARAGRAPH_SPLIT_REGEX);

    for (String paragraph : paragraphs) {
      String trimmedParagraph = paragraph.trim();
      if (!trimmedParagraph.isEmpty()) {
        if (nextParser != null) {
          textComposite.add(nextParser.parse(trimmedParagraph));
        }
      }
    }

    return textComposite;
  }
}
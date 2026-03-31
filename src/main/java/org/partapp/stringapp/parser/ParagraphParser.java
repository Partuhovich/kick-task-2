package org.partapp.stringapp.parser;

import org.partapp.stringapp.composite.TextComponent;
import org.partapp.stringapp.exeption.CustomException;
import org.partapp.stringapp.type.TextElementType;

public class ParagraphParser extends AbstractTextParser {

  public ParagraphParser() {
    super(TextElementType.PARAGRAPH);
  }

  @Override
  public TextComponent parse(String text) throws CustomException {
    TextComponent paragraphComposite = createComposite();

    String[] sentences = text.split("(?<=[.!?])\\s+(?=[A-ZА-Я])");

    if (sentences.length == 0) {
      sentences = new String[]{text};
    }

    for (String sentence : sentences) {
      if (!sentence.trim().isEmpty()) {
        if (nextParser != null) {
          paragraphComposite.add(nextParser.parse(sentence.trim()));
        }
      }
    }

    return paragraphComposite;
  }
}
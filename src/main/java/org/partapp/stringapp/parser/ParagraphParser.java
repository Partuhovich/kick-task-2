package org.partapp.stringapp.parser;

import org.partapp.stringapp.composite.TextComponent;
import org.partapp.stringapp.exeption.CustomException;
import org.partapp.stringapp.type.TextElementType;

public class ParagraphParser extends AbstractTextParser {
  private static final String SENTENCE_SPLIT_REGEX = "(?<=[.!?])\\s+(?=[A-ZА-Я])";

  public ParagraphParser() {
    super(TextElementType.PARAGRAPH);
  }

  @Override
  public TextComponent parse(String text) throws CustomException {
    TextComponent paragraphComposite = createComposite();
    String[] sentences = text.split(SENTENCE_SPLIT_REGEX);

    for (String sentence : sentences) {
      String trimmedSentence = sentence.trim();
      if (!trimmedSentence.isEmpty()) {
        if (nextParser != null) {
          paragraphComposite.add(nextParser.parse(trimmedSentence));
        }
      }
    }

    return paragraphComposite;
  }
}
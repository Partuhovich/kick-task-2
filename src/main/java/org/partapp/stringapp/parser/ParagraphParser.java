package org.partapp.stringapp.parser;

import org.partapp.stringapp.composite.impl.TextComposite;
import org.partapp.stringapp.exeption.CustomException;

import static org.partapp.stringapp.type.TextElementType.PARAGRAPH;

public class ParagraphParser extends AbstractTextParser {
  private final String PARAGRAPH_DELIMITER = "\\n\\s+";

  public ParagraphParser() {
    super.setNextSuccessor(new SentenceParser());
  }

  @Override
  public void parse(String content, TextComposite parent) throws CustomException {
    String[] paragraphs = content.split(PARAGRAPH_DELIMITER);

    for (String paragraph : paragraphs) {
      TextComposite paragraphComposite = new TextComposite(PARAGRAPH);

      parent.add(paragraphComposite);

      AbstractTextParser nextSuccessor = getNextSuccessor();

      nextSuccessor.parse(paragraph, paragraphComposite);
    }
  }
}
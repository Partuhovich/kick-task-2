package org.partapp.stringapp.parser;

import org.partapp.stringapp.composite.impl.TextComposite;
import org.partapp.stringapp.exeption.CustomException;

import static org.partapp.stringapp.type.TextElementType.PARAGRAPH;
import static org.partapp.stringapp.type.TextElementType.SENTENCE;

public class SentenceParser extends AbstractTextParser {
  private final String SENTENCE_DELIMITER = "(?<=[.!?])\\s+";

  public SentenceParser() {
    super.setNextSuccessor(new LexemeParser());
  }

  @Override
  public void parse(String content, TextComposite parent) throws CustomException {
    String[] sentences = content.split(SENTENCE_DELIMITER);

    for (String sentence : sentences) {
      TextComposite sentenceComposite = new TextComposite(SENTENCE);

      parent.add(sentenceComposite);

      AbstractTextParser nextSuccessor = getNextSuccessor();

      nextSuccessor.parse(sentence, sentenceComposite);
    }
  }
}
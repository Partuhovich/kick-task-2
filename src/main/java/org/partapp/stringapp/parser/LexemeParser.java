package org.partapp.stringapp.parser;

import org.partapp.stringapp.composite.impl.TextComposite;
import org.partapp.stringapp.exeption.CustomException;

import static org.partapp.stringapp.type.TextElementType.LEXEME;

public class LexemeParser extends AbstractTextParser {
  private final String LEXEMES_DELIMITER = "\\s";

  public LexemeParser() {
    super.setNextSuccessor(new WordParser());
  }

  @Override
  public void parse(String content, TextComposite parent) throws CustomException {
    String[] lexemes = content.split(LEXEMES_DELIMITER);

    for (String lexeme : lexemes) {
      TextComposite lexemeComposite = new TextComposite(LEXEME);

      parent.add(lexemeComposite);

      AbstractTextParser nextSuccessor = getNextSuccessor();

      nextSuccessor.parse(lexeme, lexemeComposite);
    }
  }
}
package org.partapp.stringapp.parser;

import org.partapp.stringapp.composite.TextComponent;
import org.partapp.stringapp.composite.impl.TextComposite;
import org.partapp.stringapp.composite.impl.TextLeaf;
import org.partapp.stringapp.exeption.CustomException;
import org.partapp.stringapp.type.TextElementType;

public class SentenceParser extends AbstractTextParser {

  public SentenceParser() {
    super(TextElementType.SENTENCE);
  }

  @Override
  public TextComponent parse(String text) throws CustomException {
    TextComponent sentenceComposite = createComposite();

    String[] lexemes = text.split("(?<=\\s)|(?=\\s)");

    StringBuilder currentLexeme = new StringBuilder();

    for (String token : lexemes) {
      if (token.trim().isEmpty()) {
        if (!currentLexeme.isEmpty()) {
          if (nextParser != null) {
            sentenceComposite.add(nextParser.parse(currentLexeme.toString()));
          }
          currentLexeme = new StringBuilder();
        }
        TextComposite spaceComposite = new TextComposite(TextElementType.LEXEME);
        spaceComposite.add(new TextLeaf(TextElementType.SYMBOL, ' '));
        sentenceComposite.add(spaceComposite);
      } else {
        currentLexeme.append(token);
      }
    }

    if (!currentLexeme.isEmpty()) {
      if (nextParser != null) {
        sentenceComposite.add(nextParser.parse(currentLexeme.toString()));
      }
    }

    return sentenceComposite;
  }
}
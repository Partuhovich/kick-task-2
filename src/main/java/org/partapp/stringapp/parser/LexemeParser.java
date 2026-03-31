package org.partapp.stringapp.parser;

import org.partapp.stringapp.composite.TextComponent;
import org.partapp.stringapp.composite.impl.TextComposite;
import org.partapp.stringapp.composite.impl.TextLeaf;
import org.partapp.stringapp.exeption.CustomException;
import org.partapp.stringapp.type.TextElementType;

import java.util.regex.Pattern;

public class LexemeParser extends AbstractTextParser {
  private static final Pattern WORD_PATTERN = Pattern.compile("^[a-zA-Z]+$");
  private static final Pattern PUNCTUATION_PATTERN = Pattern.compile("^[.!?;:,\\-'\"()]+$");

  public LexemeParser() {
    super(TextElementType.LEXEME);
  }

  @Override
  public TextComponent parse(String text) throws CustomException {
    TextComponent lexemeComposite = createComposite();

    char[] chars = text.toCharArray();
    for (char c : chars) {
      if (WORD_PATTERN.matcher(String.valueOf(c)).matches()) {
        lexemeComposite.add(new TextLeaf(TextElementType.SYMBOL, c));
      } else if (PUNCTUATION_PATTERN.matcher(String.valueOf(c)).matches()) {
        lexemeComposite.add(new TextLeaf(TextElementType.PUNCTUATION, c));
      } else {
        lexemeComposite.add(new TextLeaf(TextElementType.SYMBOL, c));
      }
    }

    return lexemeComposite;
  }
}
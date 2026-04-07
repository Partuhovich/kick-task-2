package org.partapp.stringapp.parser;

import org.partapp.stringapp.composite.impl.TextComposite;
import org.partapp.stringapp.exeption.CustomException;

import java.util.regex.Pattern;

import static org.partapp.stringapp.type.TextElementType.WORD;

public class WordParser extends AbstractTextParser {
  private final String WORD_DELIMITER = "(?=[\\p{Punct}])|(?<=[\\p{Punct}])";
  private static final Pattern WORD_PATTERN = Pattern.compile("\\p{L}+");

  public WordParser() {
    super.setNextSuccessor(new SymbolParser());
  }

  @Override
  public void parse(String content, TextComposite parent) throws CustomException {
    AbstractTextParser nextSuccessor = getNextSuccessor();
    String[] words = content.split(WORD_DELIMITER);

    for (String word : words) {
      if(WORD_PATTERN.matcher(word).matches()) {
        TextComposite wordComposite = new TextComposite(WORD);
        parent.add(wordComposite);
        nextSuccessor.parse(word, wordComposite);
      } else {
        nextSuccessor.parse(word, parent);
      }
    }
  }
}

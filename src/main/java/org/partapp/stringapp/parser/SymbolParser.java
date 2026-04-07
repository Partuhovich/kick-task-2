package org.partapp.stringapp.parser;

import org.partapp.stringapp.composite.impl.TextComposite;
import org.partapp.stringapp.composite.impl.TextLeaf;
import org.partapp.stringapp.exeption.CustomException;

import static org.partapp.stringapp.type.TextElementType.LETTER;
import static org.partapp.stringapp.type.TextElementType.SYMBOL;

public class SymbolParser extends AbstractTextParser{

  @Override
  public void parse(String content, TextComposite parent) throws CustomException {
    char[] symbols = content.toCharArray();

    for (char symbol : symbols) {
      TextLeaf symbolLeaf;
      if(Character.isLetter(symbol)){
        symbolLeaf = new TextLeaf(LETTER, symbol);
      }
      else{
        symbolLeaf = new TextLeaf(SYMBOL, symbol);
      }
      parent.add(symbolLeaf);
    }
  }
}

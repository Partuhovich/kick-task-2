package org.partapp.stringapp.service.impl;

import org.partapp.stringapp.composite.TextComponent;
import org.partapp.stringapp.composite.impl.TextComposite;
import org.partapp.stringapp.exeption.CustomException;
import org.partapp.stringapp.parser.ParagraphParser;
import org.partapp.stringapp.service.SwapLexemsService;

import java.util.ArrayList;
import java.util.List;

import static org.partapp.stringapp.type.TextElementType.TEXT;

public class SwapLexemsServiceImpl implements SwapLexemsService {

  @Override
  public TextComposite swapLexems(String text) throws CustomException {
    TextComposite root = new TextComposite(TEXT);
    ParagraphParser paragraphParser = new ParagraphParser();
    paragraphParser.parse(text, root);
    List<TextComponent> paragraphs = root.getChildren();

    List<TextComponent> allSentences = new ArrayList<>();

    for(TextComponent paragraph : paragraphs) {
      for(TextComponent sentence : paragraph.getChildren()) {
        List<TextComponent> lexems = sentence.getChildren();
        TextComponent firstLexem = lexems.getFirst();
        TextComponent lastLexem = lexems.getLast();
        lexems.set(0, lastLexem);
        lexems.set(lexems.size() - 1, firstLexem);
      }
    }
    return root;
  }
}

package org.partapp.stringapp.service.impl;

import org.partapp.stringapp.composite.TextComponent;
import org.partapp.stringapp.composite.impl.TextComposite;
import org.partapp.stringapp.exeption.CustomException;
import org.partapp.stringapp.parser.ParagraphParser;
import org.partapp.stringapp.service.SortByLexemsService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.partapp.stringapp.type.TextElementType.TEXT;

public class SortByLexemsServiceImpl implements SortByLexemsService {
  @Override
  public TextComposite sortSentences(String text) throws CustomException {
    Comparator<TextComponent> comparator = (sentence1, sentence2) -> {
      int size1 = sentence1.size();
      int size2 = sentence2.size();
      return size1 - size2;
    };
    TextComposite root = new TextComposite(TEXT);
    ParagraphParser paragraphParser = new ParagraphParser();
    paragraphParser.parse(text, root);
    List<TextComponent> paragraphs = root.getChildren();

    List<TextComponent> allSentences = new ArrayList<>();

    for(TextComponent paragraph : paragraphs) {
      allSentences.addAll(paragraph.getChildren());
    }
    allSentences.sort(comparator);

    TextComposite sortedRoot = new TextComposite(TEXT);
    for(TextComponent sentence : allSentences) {
      sortedRoot.add(sentence);
    }
    return sortedRoot;
  }
}

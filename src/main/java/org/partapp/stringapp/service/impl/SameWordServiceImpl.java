package org.partapp.stringapp.service.impl;

import org.partapp.stringapp.composite.TextComponent;
import org.partapp.stringapp.composite.impl.TextComposite;
import org.partapp.stringapp.exeption.CustomException;
import org.partapp.stringapp.parser.ParagraphParser;
import org.partapp.stringapp.service.SameWordSevice;

import java.util.*;

import static org.partapp.stringapp.type.TextElementType.TEXT;

public class SameWordServiceImpl implements SameWordSevice {
  @Override
  public Integer amountOfSameWordSentences(String text) throws CustomException {
    TextComposite root = new TextComposite(TEXT);
    ParagraphParser paragraphParser = new ParagraphParser();
    paragraphParser.parse(text, root);
    List<TextComponent> paragraphs = root.getChildren();

    List<TextComponent> allSentences = new ArrayList<>();

    for(TextComponent paragraph : paragraphs) {
      allSentences.addAll(paragraph.getChildren());
    }

    Map<String, Set<Integer>> wordToSentences = new HashMap<>();

    for (int i = 0; i < allSentences.size(); i++) {
      TextComponent sentence = allSentences.get(i);
      Set<String> uniqueWordsInSentence = new HashSet<>();

      for (TextComponent lexem : sentence.getChildren()) {
        String word = lexem.toString().toLowerCase();
        word = word.replaceAll("[^a-zA-Zа-яА-Я0-9]", "");

        if (!word.isEmpty()) {
          uniqueWordsInSentence.add(word);
        }
      }
      for (String word : uniqueWordsInSentence) {
        wordToSentences.computeIfAbsent(word, k -> new HashSet<>()).add(i);
      }
    }

    int maxSentencesCount = 0;
    for (Set<Integer> sentences : wordToSentences.values()) {
      maxSentencesCount = Math.max(maxSentencesCount, sentences.size());
    }

    return maxSentencesCount;
  }
}

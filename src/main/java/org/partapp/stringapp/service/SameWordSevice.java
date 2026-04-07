package org.partapp.stringapp.service;

import org.partapp.stringapp.composite.impl.TextComposite;
import org.partapp.stringapp.exeption.CustomException;

public interface SameWordSevice {
  public Integer amountOfSameWordSentences(String text) throws CustomException;
}

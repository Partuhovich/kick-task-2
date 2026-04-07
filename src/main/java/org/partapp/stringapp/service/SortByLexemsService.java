package org.partapp.stringapp.service;

import org.partapp.stringapp.composite.impl.TextComposite;
import org.partapp.stringapp.exeption.CustomException;

public interface SortByLexemsService {
    TextComposite sortSentences(String text) throws CustomException;
}

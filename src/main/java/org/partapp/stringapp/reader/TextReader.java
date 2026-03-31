package org.partapp.stringapp.reader;

import org.partapp.stringapp.exeption.CustomException;

public interface TextReader {
  String readLines(String filePath) throws CustomException;
}

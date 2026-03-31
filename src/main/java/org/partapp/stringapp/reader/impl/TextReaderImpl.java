package org.partapp.stringapp.reader.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.partapp.stringapp.exeption.CustomException;
import org.partapp.stringapp.reader.TextReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextReaderImpl implements TextReader {
  private static final Logger logger = LogManager.getLogger(TextReaderImpl.class);

  @Override
  public String readLines(String filePath) throws CustomException {
    if (filePath == null || filePath.isEmpty()) {
      logger.error("Path is null or blank");
      throw new CustomException("Path is null or blank");
    }

    String content;
    try {
      Path path = Paths.get(filePath);
      content = Files.readString(path);
    } catch (IOException e) {
      throw new CustomException("Failed to read file: " + filePath);
    }

    return content.strip();
  }
}

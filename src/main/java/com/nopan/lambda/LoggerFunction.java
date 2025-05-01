package com.nopan.lambda;

import java.util.function.Function;
import java.util.logging.Logger;

public class LoggerFunction implements Function<String, Void> {
  private static final Logger logger = Logger.getLogger(LoggerFunction.class.getName());

  @Override
  public Void apply(String input) {
    logger.info(String.format("Input received -> %s", input));
    return null;
  }

}

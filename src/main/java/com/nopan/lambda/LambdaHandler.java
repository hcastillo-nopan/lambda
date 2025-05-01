package com.nopan.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.util.Map;
import java.util.logging.Logger;

public class LambdaHandler implements RequestHandler<Map<String, Object>, Void> {

  private static final Logger logger = Logger.getLogger(LambdaHandler.class.getName());

  @Override
  public Void handleRequest(Map<String, Object> input, Context context) {
    logger.info(String.format("Event received -> %s", input));
    return null;
  }
}

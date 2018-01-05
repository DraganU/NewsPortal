package com.news.controller.exceptions;

public class EntityNotFoundException extends RuntimeException {

  public EntityNotFoundException(String entityName, long id) {
    this(entityName, "id", String.valueOf(id));
  }

  public EntityNotFoundException(String entityName, String propertyName, String propertyValue) {
    super("Entity '" + entityName + "' with '" + propertyName + "' = '" + propertyValue + "' not found.");
  }

  public EntityNotFoundException() {
    super();
  }

}

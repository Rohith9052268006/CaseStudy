package com.hexaware.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class for reading properties.
 */
public final class PropertyUtil {
  private PropertyUtil() {
    
  }

  /**
   * Gets the database connection string from properties file.
   *
   * @return The database connection string.
   */
  public static String getPropertyString() {
    Properties properties = new Properties();
    try (FileInputStream fis = new FileInputStream("db.properties")) {
      properties.load(fis);
      return properties.getProperty("db.url") + "-" 
        + properties.getProperty("db.username") + "-" 
        + properties.getProperty("db.password");
    
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}

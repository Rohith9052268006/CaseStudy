package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for database connection.
 */
public final class ConnUtil {
  private static Connection connection;

  private ConnUtil() {
    // Private constructor to prevent instantiation
  }

  /**
   * Gets the database connection.
   *
   * @return The database connection.
   */
  public static Connection getConnection() {
    if (connection == null) {
      try {
        String[] conString = PropertyUtil.getPropertyString().split("-");
        connection = DriverManager.getConnection(conString[0], conString[1], conString[2]);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return connection;
  }
}

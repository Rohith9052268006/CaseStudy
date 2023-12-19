package com.hexaware.exception;

/**
 * Custom exception class for Crime Analysis.
 */
@SuppressWarnings("serial")
public class IncidentNotFoundException extends Exception {
  /**
   * Constructs a CrimeAnalysisException with the specified message.
   *
   * @param message The detail message.
   */
  public IncidentNotFoundException(String message) {
    super(message);
  }
}

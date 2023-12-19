package com.hexaware.entity;

/**
 * Represents the type of an incident.
 *
 * @author ROHITH
 */
public class IncidentType {
  private String type;

  /**
   * Constructs an IncidentType with the specified type.
   *
   * @param type The type of the incident.
   */
  public IncidentType(String type) {
    this.type = type;
  }

  public IncidentType() {
    // TODO Auto-generated constructor stub
  }

  /**
   * Gets the type of the incident.
   *
   * @return The type of the incident.
   */
  public String getType() {
    return type;
  }

  /**
   * Sets the type of the incident.
   *
   * @param type The new type of the incident.
   */
  public void setType(String type) {
    this.type = type;
  }
}

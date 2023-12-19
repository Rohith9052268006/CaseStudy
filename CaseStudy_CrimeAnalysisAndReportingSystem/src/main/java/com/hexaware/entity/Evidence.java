package com.hexaware.entity;

/**
 * Represents evidence in an investigation.
 *
 * @author ROHITH
 */
public class Evidence {
  private int evidenceId;
  private String description;
  private String locationFound;
  private int incidentId;

  // Getters and setters

  /**
   * Gets the unique identifier for the evidence.
   *
   * @return The evidence Id.
   */
  public int getEvidenceId() {
    return evidenceId;
  }

  /**
   * Sets the evidence Id.
   *
   * @param evidenceId The evidence Id to set.
   */
  public void setEvidenceId(int evidenceId) {
    this.evidenceId = evidenceId;
  }

  /**
   * Gets the description of the evidence.
   *
   * @return The evidence description.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the evidence description.
   *
   * @param description The evidence description to set.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Gets the location where the evidence was found.
   *
   * @return The location where the evidence was found.
   */
  public String getLocationFound() {
    return locationFound;
  }

  /**
   * Sets the location where the evidence was found.
   *
   * @param locationFound The location where the evidence was found to set.
   */
  public void setLocationFound(String locationFound) {
    this.locationFound = locationFound;
  }

  /**
   * Gets the Id of the incident associated with the evidence.
   *
   * @return The incident Id.
   */
  public int getIncidentId() {
    return incidentId;
  }

  /**
   * Sets the incident Id associated with the evidence.
   *
   * @param incidentId The incident Id to set.
   */
  public void setIncidentId(int incidentId) {
    this.incidentId = incidentId;
  }
}

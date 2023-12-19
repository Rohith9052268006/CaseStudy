package com.hexaware.entity;

import java.util.Date;

/**
 * Represents an incident in an investigation.
 *
 * @author ROHITH
 */
public class Incident {
  private int incidentId;
  private String incidentType;
  private Date incidentDate;
  private GeoPoint location; 
  private String description;
  private String status;
  private int victimId;
  private int suspectId;

  public Incident() {
	  
  }
  public Incident(int incidentId, String incidentType, 
      Date incidentDate, GeoPoint location, String description,
	  String status, int victimId, int suspectId) {
    super();
    this.incidentId = incidentId;
	this.incidentType = incidentType;
	this.incidentDate = incidentDate;
	this.location = location;
	this.description = description;
	this.status = status;
	this.victimId = victimId;
	this.suspectId = suspectId;
  }
  // Getters and setters

  /**
   * Gets the unique identifier for the incident.
   *
   * @return The incident Id.
   */
  public int getIncidentId() {
    return incidentId;
  }

  /**
   * Sets the incident Id.
   *
   * @param incidentId The incident Id to set.
   */
  public void setIncidentId(int incidentId) {
    this.incidentId = incidentId;
  }

  /**
   * Gets the type of the incident (e.g., Robbery, Homicide, Theft).
   *
   * @return The incident type.
   */
  public String getIncidentType() {
    return incidentType;
  }

  /**
   * Sets the incident type.
   *
   * @param incidentType The incident type to set.
   */
  public void setIncidentType(String incidentType) {
    this.incidentType = incidentType;
  }

  /**
   * Gets the date of the incident.
   *
   * @return The incident date.
   */
  public Date getIncidentDate() {
    return incidentDate;
  }

  /**
   * Sets the incident date.
   *
   * @param date The incident date to set.
   */
  public void setIncidentDate(Date date) {
    this.incidentDate = date;
  }

  /**
   * Gets the location of the incident (Geospatial Data: Latitude and Longitude).
   *
   * @return The incident location.
   */
  public GeoPoint getLocation() {
    return location;
  }

  /**
   * Sets the incident location.
   *
   * @param location The incident location to set.
   */
  public void setLocation(GeoPoint location) {
    this.location = location;
  }

  /**
   * Gets the description of the incident.
   *
   * @return The incident description.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets the incident description.
   *
   * @param description The incident description to set.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Gets the status of the incident (e.g., Open, Closed, Under Investigation).
   *
   * @return The incident status.
   */
  public String getStatus() {
    return status;
  }

  /**
   * Sets the incident status.
   *
   * @param status The incident status to set.
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * Gets the Id of the victim associated with the incident.
   *
   * @return The victim Id.
   */
  public int getVictimId() {
    return victimId;
  }

  /**
   * Sets the victim Id associated with the incident.
   *
   * @param victimId The victim Id to set.
   */
  public void setVictimId(int victimId) {
    this.victimId = victimId;
  }

  /**
   * Gets the Id of the suspect associated with the incident.
   *
   * @return The suspect Id.
   */
  public int getSuspectId() {
    return suspectId;
  }

  /**
   * Sets the suspect Id associated with the incident.
   *
   * @param suspectId The suspect Id to set.
   */
  public void setSuspectId(int suspectId) {
    this.suspectId = suspectId;
  }
  
  @Override
  public String toString() {
    return "Incident [incidentId=" + incidentId + ", incidentType=" 
      + incidentType + ", incidentDate=" + incidentDate
      + ", location=" + location + ", description=" + description + ", "
      + "status=" + status + ", victimId=" + victimId
      + ", suspectId=" + suspectId + "]";
  }
}

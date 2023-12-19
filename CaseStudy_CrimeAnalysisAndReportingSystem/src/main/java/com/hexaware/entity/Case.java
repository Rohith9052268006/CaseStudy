package com.hexaware.entity;

import java.util.Collection;

/**
 * Represents a case associated with incidents in an investigation.
 *
 * @author ROHITH
 */

public class Case {
  private int caseId;
  private String caseDescription;
  private Collection<Incident> incidents;

  /**
   * Constructs a Case with the specified ID, description, and incidents.
   *
   * @param caseId          The unique identifier for the case.
   * @param caseDescription A brief description of the case.
   * @param incidents       A collection of incidents
   */
  public Case(int caseId, String caseDescription, Collection<Incident> incidents) {
    this.caseId = caseId;
    this.caseDescription = caseDescription;
    this.incidents = incidents;
  }

  public Case() {
    // TODO Auto-generated constructor stub
  }

  /**
   * Gets the unique identifier for the case.
   *
   * @return The case ID.
   */
  public int getCaseId() {
    return caseId;
  }

  /**
   * Sets the case ID.
   *
   * @param caseId The case ID to set.
   */
  public void setCaseId(int caseId) {
    this.caseId = caseId;
  }

  /**
   * Gets the description of the case.
   *
   * @return The case description.
   */
  public String getCaseDescription() {
    return caseDescription;
  }

  /**
   * Sets the case description.
   *
   * @param caseDescription The case description to set.
   */
  public void setCaseDescription(String caseDescription) {
    this.caseDescription = caseDescription;
  }

  /**
   * Gets the collection of incidents associated with the case.
   *
   * @return The collection of incidents.
   */
  public Collection<Incident> getIncidents() {
    return incidents;
  }

  /**
   * Sets the collection of incidents associated with the case.
   *
   * @param incidents A collection of incidents
   */
  public void setIncidents(Collection<Incident> incidents) {
    this.incidents = incidents;
  }
  
  @Override
  public String toString() {
    return "Case [caseId=" + caseId + ", caseDescription=" 
      + caseDescription + ", incidents=" + incidents + "]";
  }

}

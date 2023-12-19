package com.hexaware.entity;

import java.util.List;

/**
 * Represents a law enforcement agency involved in investigations.
 *
 * @author ROHITH
 */
public class LawEnforcementAgency {
  private int agencyId;
  private String agencyName;
  private String jurisdiction;
  private String contactInformation;
  private List<Officer> officers;

  // Getters and setters

  /**
   * Gets the unique identifier for the law enforcement agency.
   *
   * @return The agency Id.
   */
  public int getAgencyId() {
    return agencyId;
  }

  /**
   * Sets the agency Id.
   *
   * @param agencyId The agency Id to set.
   */
  public void setAgencyId(int agencyId) {
    this.agencyId = agencyId;
  }

  /**
   * Gets the name of the law enforcement agency.
   *
   * @return The agency name.
   */
  public String getAgencyName() {
    return agencyName;
  }

  /**
   * Sets the agency name.
   *
   * @param agencyName The agency name to set.
   */
  public void setAgencyName(String agencyName) {
    this.agencyName = agencyName;
  }

  /**
   * Gets the jurisdiction of the law enforcement agency.
   *
   * @return The agency jurisdiction.
   */
  public String getJurisdiction() {
    return jurisdiction;
  }

  /**
   * Sets the agency jurisdiction.
   *
   * @param jurisdiction The agency jurisdiction to set.
   */
  public void setJurisdiction(String jurisdiction) {
    this.jurisdiction = jurisdiction;
  }

  /**
   * Gets the contact information for the law enforcement agency.
   *
   * @return The agency contact information.
   */
  public String getContactInformation() {
    return contactInformation;
  }

  /**
   * Sets the agency contact information.
   *
   * @param contactInformation The agency contact information to set.
   */
  public void setContactInformation(String contactInformation) {
    this.contactInformation = contactInformation;
  }

  /**
   * Gets the list of officers working for the law enforcement agency.
   *
   * @return The list of officers.
   */
  public List<Officer> getOfficers() {
    return officers;
  }

  /**
   * Sets the list of officers working for the law enforcement agency.
   *
   * @param officers The list of officers to set.
   */
  public void setOfficers(List<Officer> officers) {
    this.officers = officers;
  }
}

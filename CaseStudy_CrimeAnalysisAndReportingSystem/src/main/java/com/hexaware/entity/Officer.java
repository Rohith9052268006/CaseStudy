package com.hexaware.entity;

/**
 * Represents an officer involved in investigations.
 *
 * @author ROHITH
 */
public class Officer {
  private int officerId;
  private String firstName;
  private String lastName;
  private String badgeNumber;
  private String rank;
  private String contactInformation;
  private int agencyId;

  // Getters and setters

  /**
   * Gets the unique identifier for the officer.
   *
   * @return The officer Id.
   */
  public int getOfficerId() {
    return officerId;
  }

  /**
   * Sets the officer Id.
   *
   * @param officerId The officer Id to set.
   */
  public void setOfficerId(int officerId) {
    this.officerId = officerId;
  }

  /**
   * Gets the first name of the officer.
   *
   * @return The officer's first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets the officer's first name.
   *
   * @param firstName The officer's first name to set.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Gets the last name of the officer.
   *
   * @return The officer's last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets the officer's last name.
   *
   * @param lastName The officer's last name to set.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Gets the badge number of the officer.
   *
   * @return The officer's badge number.
   */
  public String getBadgeNumber() {
    return badgeNumber;
  }

  /**
   * Sets the officer's badge number.
   *
   * @param badgeNumber The officer's badge number to set.
   */
  public void setBadgeNumber(String badgeNumber) {
    this.badgeNumber = badgeNumber;
  }

  /**
   * Gets the rank of the officer.
   *
   * @return The officer's rank.
   */
  public String getRank() {
    return rank;
  }

  /**
   * Sets the officer's rank.
   *
   * @param rank The officer's rank to set.
   */
  public void setRank(String rank) {
    this.rank = rank;
  }

  /**
   * Gets the contact information for the officer.
   *
   * @return The officer's contact information.
   */
  public String getContactInformation() {
    return contactInformation;
  }

  /**
   * Sets the officer's contact information.
   *
   * @param contactInformation The officer's contact information to set.
   */
  public void setContactInformation(String contactInformation) {
    this.contactInformation = contactInformation;
  }

  /**
   * Gets the ID of the law enforcement agency the officer works for.
   *
   * @return The agency Id.
   */
  public int getAgencyId() {
    return agencyId;
  }

  /**
   * Sets the agency Id associated with the officer.
   *
   * @param agencyId The agency Id to set.
   */
  public void setAgencyId(int agencyId) {
    this.agencyId = agencyId;
  }
}


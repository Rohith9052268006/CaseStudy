package com.hexaware.entity;

/**
 * Represents a victim in an investigation.
 *
 * @author ROHITH
 */
public class Victim {
  private int victimId;
  private String firstName;
  private String lastName;
  private String dateOfBirth;
  private String gender;
  private String contactInformation;

  // Getters and setters

  /**
   * Gets the unique identifier for the victim.
   *
   * @return The victim Id.
   */
  public int getVictimId() {
    return victimId;
  }

  /**
   * Sets the victim Id.
   *
   * @param victimId The victim Id to set.
   */
  public void setVictimId(int victimId) {
    this.victimId = victimId;
  }

  /**
   * Gets the first name of the victim.
   *
   * @return The victim's first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets the victim's first name.
   *
   * @param firstName The victim's first name to set.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Gets the last name of the victim.
   *
   * @return The victim's last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets the victim's last name.
   *
   * @param lastName The victim's last name to set.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Gets the date of birth of the victim.
   *
   * @return The victim's date of birth.
   */
  public String getDateOfBirth() {
    return dateOfBirth;
  }

  /**
   * Sets the victim's date of birth.
   *
   * @param dateOfBirth The victim's date of birth to set.
   */
  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  /**
   * Gets the gender of the victim.
   *
   * @return The victim's gender.
   */
  public String getGender() {
    return gender;
  }

  /**
   * Sets the victim's gender.
   *
   * @param gender The victim's gender to set.
   */
  public void setGender(String gender) {
    this.gender = gender;
  }

  /**
   * Gets the contact information for the victim.
   *
   * @return The victim's contact information.
   */
  public String getContactInformation() {
    return contactInformation;
  }

  /**
   * Sets the victim's contact information.
   *
   * @param contactInformation The victim's contact information to set.
   */
  public void setContactInformation(String contactInformation) {
    this.contactInformation = contactInformation;
  }
}

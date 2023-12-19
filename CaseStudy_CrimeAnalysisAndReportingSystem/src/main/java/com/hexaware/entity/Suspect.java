package com.hexaware.entity;

/**
 * Represents a suspect involved in an investigation.
 *
 * @author ROHITH
 */
public class Suspect {
  private int suspectId;
  private String firstName;
  private String lastName;
  private String dateOfBirth;
  private String gender;
  private String contactInformation;

  // Getters and setters

  /**
   * Gets the unique identifier for the suspect.
   *
   * @return The suspect Id.
   */
  public int getSuspectId() {
    return suspectId;
  }

  /**
   * Sets the suspect Id.
   *
   * @param suspectId The suspect Id to set.
   */
  public void setSuspectId(int suspectId) {
    this.suspectId = suspectId;
  }

  /**
   * Gets the first name of the suspect.
   *
   * @return The suspect's first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets the suspect's first name.
   *
   * @param firstName The suspect's first name to set.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Gets the last name of the suspect.
   *
   * @return The suspect's last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets the suspect's last name.
   *
   * @param lastName The suspect's last name to set.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Gets the date of birth of the suspect.
   *
   * @return The suspect's date of birth.
   */
  public String getDateOfBirth() {
    return dateOfBirth;
  }

  /**
   * Sets the suspect's date of birth.
   *
   * @param dateOfBirth The suspect's date of birth to set.
   */
  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  /**
   * Gets the gender of the suspect.
   *
   * @return The suspect's gender.
   */
  public String getGender() {
    return gender;
  }

  /**
   * Sets the suspect's gender.
   *
   * @param gender The suspect's gender to set.
   */
  public void setGender(String gender) {
    this.gender = gender;
  }

  /**
   * Gets the contact information for the suspect.
   *
   * @return The suspect's contact information.
   */
  public String getContactInformation() {
    return contactInformation;
  }

  /**
   * Sets the suspect's contact information.
   *
   * @param contactInformation The suspect's contact information to set.
   */
  public void setContactInformation(String contactInformation) {
    this.contactInformation = contactInformation;
  }
}

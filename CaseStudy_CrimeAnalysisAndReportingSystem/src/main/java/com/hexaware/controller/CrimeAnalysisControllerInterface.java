package com.hexaware.controller;

import com.hexaware.entity.Case;
import com.hexaware.entity.Incident;
import com.hexaware.entity.Report;
import java.util.Collection;
import java.util.List;

/**
 * Controller interface for Crime Analysis.
 * This interface defines methods for handling user input 
 * and interacting with the CrimeAnalysisService.
 * It provides methods for creating incidents, 
 * updating incident status, getting incidents within a date range,
 * searching for incidents, generating incident reports, 
 * creating cases, and performing case-related operations.
 * All implementing classes should provide the actual implementation of these methods.
 *
 * @author ROHITH
 */
public interface CrimeAnalysisControllerInterface {

  /**
   * Method to take input for creating a new incident.
   *
   * @return True if the incident is successfully created; otherwise, false.
   */
  boolean createIncident();

  /**
   * Method to take input for updating the status of an incident.
   *
   * @return True if the incident status is successfully updated; otherwise, false.
   */
  boolean updateIncidentStatus();

  /**
   * Method to get incidents within a specified date range.
   *
   * @return A collection of incidents within the specified date range.
   */
  Collection<Incident> getIncidentsInDateRange();

  /**
   * Method to search for incidents based on various criteria.
   *
   * @return A collection of incidents matching the specified criteria.
   */
  Collection<Incident> searchIncidents();

  /**
   * Method to generate an incident report.
   *
   * @return The generated incident report.
   */
  Report generateIncidentReport();

  /**
   * Method to create a new case and associate it with incidents.
   *
   * @return The created case.
   */
  boolean createCase();

  /**
   * Method to get details of a specific case.
   *
   * @return The details of the specified case.
   */
  Case getCaseDetails();

  /**
   * Method to update case details.
   *
   * @return True if the case details are successfully updated; otherwise, false.
   */
  boolean updateCaseDetails();

  /**
   * Method to get a list of all cases.
   *
   * @return A list containing details of all cases.
   */
  List<Case> getAllCases();
}

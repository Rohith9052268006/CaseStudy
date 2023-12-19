package com.hexaware.dao;

import com.hexaware.entity.Case;
import com.hexaware.entity.Incident;
import com.hexaware.entity.IncidentType;
import com.hexaware.entity.Report;
import com.hexaware.exception.IncidentNotFoundException;
import java.util.Collection;
import java.util.List;


/**
 * Service Interface for Crime Analysis.
 *
 * @author ROHITH
 */

public interface CrimeAnalysisService {
  /**
   * Creates a new incident.
   *
   * @param incident The incident to be created.
   * @return True if the incident is successfully created; otherwise, false.
   */
  public boolean createIncident(Incident incident);

  /**
   * Updates the status of an incident.
   *
   * @param status     The new status to be set.
   * @param incidentId The ID of the incident to be updated.
   * @return True if the incident status is successfully updated; otherwise, false.
 * @throws IncidentNotFoundException 
   */
  public boolean updateIncidentStatus(String status, int incidentId) throws IncidentNotFoundException;

  /**
   * Gets a list of incidents within a specified date range.
   *
   * @param startDate The start date of the range.
   * @param endDate   The end date of the range.
   * @return A collection of incidents within the specified date range.
   */
  public Collection<Incident> getIncidentsInDateRange(String startDate, String endDate);

  /**
   * Searches for incidents based on various criteria.
   *
   * @param criteria The criteria for searching incidents.
   * @return A collection of incidents matching the specified criteria.
   * @throws IncidentNotFoundException 
   *                                  This exception is thrown if no report is found for the 
   *                                  specified incident.
   */
  public Collection<Incident> searchIncidents(IncidentType criteria)throws IncidentNotFoundException;

  /**
   * Generates an incident report.
   *
   * @param incident The incident for which the report is to be generated.
   * @return The generated incident report
   * @throws IncidentNotFoundException .
   */
  public Report generateIncidentReport(Incident incident) throws IncidentNotFoundException;

  /**
   * Creates a new case and associates it with incidents.
   *
   * @param caseDescription A brief description of the case.
   * @param incidents       A collection of incidents to be associated with the case.
   * @return The created case.
   */
  public boolean createCase(String caseDescription, Collection<Incident> incidents);

  /**
   * Gets details of a specific case.
   *
   * @param caseId The ID of the case to retrieve details for.
   * @return The details of the specified case.
   */
  public Case getCaseDetails(int caseId);

  /**
   * Updates case details.
   *
   * @param updatedCase The updated case details.
   * @return True if the case details are successfully updated; otherwise, false.
   */
  public boolean updateCaseDetails(Case updatedCase);

  /**
   * Gets a list of all cases.
   *
   * @return A list containing details of all cases.
   */
  public List<Case> getAllCases();
}

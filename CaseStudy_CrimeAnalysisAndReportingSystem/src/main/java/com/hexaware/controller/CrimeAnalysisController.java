package com.hexaware.controller;

import com.hexaware.dao.CrimeAnalysisService;
import com.hexaware.dao.CrimeAnalysisServiceImpl;
import com.hexaware.entity.Case;
import com.hexaware.entity.GeoPoint;
import com.hexaware.entity.Incident;
import com.hexaware.entity.IncidentType;
import com.hexaware.entity.Report;
import com.hexaware.exception.IncidentNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Controller class for Crime Analysis.
 
 * This class handles user input and interacts with the CrimeAnalysisService.
 * It provides methods for creating incidents, updating incident status, getting
 * incidents within a date range, searching for incidents, generating incident reports,
 * creating cases, and performing case-related operations.
 *
 * @author ROHITH
 */
public class CrimeAnalysisController implements CrimeAnalysisControllerInterface {
  private CrimeAnalysisService crimeAnalysisService;
  private BufferedReader reader;

  /**
   * Constructor to inject the CrimeAnalysisService implementation.
   *
   * @param crimeAnalysisService The CrimeAnalysisService implementation.
   */
  public CrimeAnalysisController(CrimeAnalysisService crimeAnalysisService) {
    this.crimeAnalysisService = crimeAnalysisService;
    this.reader = new BufferedReader(new InputStreamReader(System.in));
  }

  /**
   * Method to take input for creating a new incident.
   *
   * @return True if the incident is successfully created; otherwise, false.
   */
  public boolean createIncident() {
    try {
      Incident incident = new Incident();

      System.out.print("Enter incident ID: ");
      incident.setIncidentId(Integer.parseInt(reader.readLine()));

      System.out.print("Enter incident type: ");
      incident.setIncidentType(reader.readLine());

      System.out.print("Enter incident status: ");
      incident.setStatus(reader.readLine());
      
      System.out.println("Enter date (YYYY-MM-DD): ");
      String dateString = reader.readLine();

      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      try {
        Date date = dateFormat.parse(dateString);
        incident.setIncidentDate(date);
      } catch (ParseException e) {
        System.out.println("Invalid date format. Please enter date in the format YYYY-MM-DD.");
      }

      System.out.print("Enter victim ID: ");
      incident.setVictimId(Integer.parseInt(reader.readLine()));

      System.out.print("Enter suspect ID: ");
      incident.setSuspectId(Integer.parseInt(reader.readLine()));

      System.out.println("Enter description: ");
      incident.setDescription(reader.readLine());
      
      System.out.print("Enter latitude: ");
      double latitude = Double.parseDouble(reader.readLine());

      System.out.print("Enter longitude: ");
      double longitude = Double.parseDouble(reader.readLine());

      incident.setLocation(new GeoPoint(latitude, longitude));

      return crimeAnalysisService.createIncident(incident);
    } catch (IOException | NumberFormatException e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
  * Method to take input for updating the status of an incident.
  *
  * @return True if the incident status is successfully updated; otherwise, false.
  */
  public boolean updateIncidentStatus() {
    try {
      System.out.print("Enter incident ID: ");
      int incidentId = Integer.parseInt(reader.readLine());

      System.out.print("Enter new status: ");
      String status = reader.readLine();

      return crimeAnalysisService.updateIncidentStatus(status, incidentId);
    } catch (IOException | NumberFormatException e) {
      System.err.println("Error");
    } catch (IncidentNotFoundException e) {
		System.out.println(e.getMessage());
	} return false;
  }

  /**
  * Method to get incidents within a specified date range.
  *
  * @return A collection of incidents within the specified date range.
  */
  public Collection<Incident> getIncidentsInDateRange() {
    try {
      System.out.print("Enter start date (YYYY-MM-DD): ");
      String startDate = reader.readLine();

      System.out.print("Enter end date (YYYY-MM-DD): ");
      String endDate = reader.readLine();

      return crimeAnalysisService.getIncidentsInDateRange(startDate, endDate);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
  * Method to search for incidents based on various criteria.
  *
  * @return A collection of incidents matching the specified criteria.
  */
  public Collection<Incident> searchIncidents() {
    try {
      System.out.print("Enter incident type for search: ");
      String incidentType = reader.readLine();
 
      IncidentType criteria = new IncidentType();
      criteria.setType(incidentType);
 
      return crimeAnalysisService.searchIncidents(criteria);
    } catch (IOException | IncidentNotFoundException | NullPointerException e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

  /**
  * Method to generate an incident report.
  *
  * @return The generated incident report.
  */
  public Report generateIncidentReport() {
    int incidentId = 0;
    CrimeAnalysisServiceImpl crimeAnalysisServiceimpl = null;
    Incident incident = null;
    try {
      System.out.print("Enter incident ID for report generation: ");
      incidentId = Integer.parseInt(reader.readLine());
      crimeAnalysisServiceimpl = new CrimeAnalysisServiceImpl();
      incident = crimeAnalysisServiceimpl.getIncidentById(incidentId);
      return crimeAnalysisService.generateIncidentReport(incident);
    } catch (IOException | NumberFormatException e) {
      e.printStackTrace();
    } catch (IncidentNotFoundException e) {
      System.out.println(e.getMessage());
    }
    return null;
    
  }

  /**
  * Method to create a new case and associate it with incidents.
  *
  * @return The created case.
  */
  public boolean createCase() {
    try {
      System.out.print("Enter case description: ");
      String caseDescription = reader.readLine();

      // Input for incidents associated with the case
      List<Incident> incidents = new ArrayList<>();
      System.out.print("Enter the number of incidents to associate with the case: ");
      int numIncidents = Integer.parseInt(reader.readLine());
      for (int i = 0; i < numIncidents; i++) {
        System.out.print("Enter incident ID for association: ");
        int incidentId = Integer.parseInt(reader.readLine());
        Incident incident = new Incident();
        incident.setIncidentId(incidentId);
        incidents.add(incident);
      }

      return crimeAnalysisService.createCase(caseDescription, incidents);
    } catch (IOException | NumberFormatException e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
  * Method to get details of a specific case.
  *
  * @return The details of the specified case.
  */
  public Case getCaseDetails() {
    try {
      System.out.print("Enter case ID for details: ");
      int caseId = Integer.parseInt(reader.readLine());

      return crimeAnalysisService.getCaseDetails(caseId);
    } catch (IOException | NumberFormatException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
  * Method to update case details.
  *
  * @return True if the case details are successfully updated; otherwise, false.
  */
  public boolean updateCaseDetails() {
    try {
      System.out.print("Enter case ID for update: ");
      int caseId = Integer.parseInt(reader.readLine());
 
      System.out.print("Enter new case description: ");
      String newDescription = reader.readLine();
 
      Case updatedCase = new Case();
      updatedCase.setCaseId(caseId);
      updatedCase.setCaseDescription(newDescription);
 
      return crimeAnalysisService.updateCaseDetails(updatedCase);
    } catch (IOException | NumberFormatException e) {
      e.printStackTrace();
      return false;
    } 
  }

  /**
  * Method to get a list of all cases.
  *
  * @return A list containing details of all cases.
  */
  public List<Case> getAllCases() {
    return crimeAnalysisService.getAllCases();
  }
}


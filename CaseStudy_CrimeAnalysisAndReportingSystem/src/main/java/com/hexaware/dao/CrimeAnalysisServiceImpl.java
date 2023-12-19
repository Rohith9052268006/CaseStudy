package com.hexaware.dao;

import com.hexaware.entity.Case;
import com.hexaware.entity.GeoPoint;
import com.hexaware.entity.Incident;
import com.hexaware.entity.IncidentType;
import com.hexaware.entity.Report;
import com.hexaware.exception.IncidentNotFoundException;
import com.hexaware.util.ConnUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Implementation class for Crime Analysis Interface.
 *
 * @author ROHITH
 */
public class CrimeAnalysisServiceImpl implements CrimeAnalysisService {
  private Connection connection;

  /**
   * Constructor to initialize the connection.
   */
  public CrimeAnalysisServiceImpl() {
    this.connection = ConnUtil.getConnection();
  }

  /**
   * Creates a new incident in the database.
   *
   * @param incident The Incident object to be created.
   * @return true if the creation is successful, false otherwise.
   */
  @Override
  public boolean createIncident(Incident incident) {
    try {
      String query = "INSERT INTO incident (incidentID, incidentType, "
          + "incidentDate, location, description, status, "
          + "victimID, suspectID) VALUES (?, ?, ?, POINT(?,?), ?, ?, ?, ?)";

      java.util.Date utilDate = incident.getIncidentDate();
      java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, incident.getIncidentId());
        preparedStatement.setString(2, incident.getIncidentType());
        preparedStatement.setDate(3, sqlDate);
        preparedStatement.setDouble(4, incident.getLocation().getLatitude());
        preparedStatement.setDouble(5, incident.getLocation().getLongitude());
        preparedStatement.setString(6, incident.getDescription());
        preparedStatement.setString(7, incident.getStatus());
        preparedStatement.setInt(8, incident.getVictimId());
        preparedStatement.setInt(9, incident.getSuspectId());

        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
  /**
   * Updates the status of an existing incident in the database.
   *
   * @param status     The new status of the incident.
   * @param incidentId The unique identifier of the incident.
   * @return true if the update is successful, false otherwise.
 * @throws IncidentNotFoundException 
   */
  
  @Override
  public boolean updateIncidentStatus(String status, int incidentId) throws IncidentNotFoundException {
    try {
      String query = "UPDATE incident SET status = ? WHERE incidentID = ?";
      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, status);
        preparedStatement.setInt(2, incidentId);

        int rowsAffected = preparedStatement.executeUpdate();
        
		if (rowsAffected == 0) {
		  System.err.println("Incident Not Found");
		  throw new IncidentNotFoundException("Invalid status update");
		}
        return rowsAffected > 0;
      }
    } catch (SQLException e) {
      System.err.println("Error in sql command");
      return false;
    } 
  }

  /**
   * Retrieves a collection of incidents within a specified date range.
   *
   * @param startDate The start date of the range.
   * @param endDate   The end date of the range.
   * @return Collection of Incident objects within the specified date range.
   */
  @Override
  public Collection<Incident> getIncidentsInDateRange(String startDate, String endDate) {
    try {
      String query = "SELECT incidentId,incidentType,"
          + "incidentDate,ST_X(location),ST_Y(location),"
          + "description,status,victimId,suspectId FROM incident "
          + "WHERE incidentDate BETWEEN ? AND ?";
      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, startDate);
        preparedStatement.setString(2, endDate);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
          List<Incident> incidents = new ArrayList<>();
          while (resultSet.next()) {
            Incident incident = new Incident();
            incident.setIncidentId(resultSet.getInt("incidentID"));
            incident.setIncidentType(resultSet.getString("incidentType"));
            incident.setIncidentDate(resultSet.getDate("incidentDate"));
     
            GeoPoint geoPoint = new GeoPoint(resultSet.getDouble(4), resultSet.getDouble(5));
            incident.setLocation(geoPoint);
            
            incident.setDescription(resultSet.getString("description"));
            incident.setStatus(resultSet.getString("status"));
            incident.setVictimId(resultSet.getInt("victimID"));
            incident.setSuspectId(resultSet.getInt("suspectID"));
            incidents.add(incident);
          }
          return incidents;
        }
      }
    } catch (SQLException e) {
      System.err.println("Error in sql command");
      return Collections.emptyList();
    }
  }
  
  /**
   * Searches for incidents based on the specified criteria.
   *
   * @param criteria The criteria for searching incidents.
   * @return Collection of Incident objects that match the criteria.
   * @throws IncidentNotFoundException 
   *                                   This exception is thrown if no report is found for the 
   *                                   specified incident.
   */
  
  @Override
  public Collection<Incident> searchIncidents(IncidentType criteria) throws IncidentNotFoundException {
    try {
      String searchIncidentsSql = "SELECT incidentId,incidentType,incidentDate,"
           + "ST_X(location),ST_Y(location),description,status,victimId,suspectId "
           + "FROM incident WHERE incidentType = ?";

      try (PreparedStatement statement = connection.prepareStatement(searchIncidentsSql)) {
        statement.setString(1, criteria.getType());

        ResultSet resultSet = statement.executeQuery();
        List<Incident> matchingIncidents = new ArrayList<>();
        while (resultSet.next()) {
          Incident incident = new Incident();
          incident.setIncidentId(resultSet.getInt("incidentID"));
          incident.setIncidentType(resultSet.getString("incidentType"));
          incident.setIncidentDate(resultSet.getDate("incidentDate"));
          
          GeoPoint geoPoint = new GeoPoint(resultSet.getDouble(4), resultSet.getDouble(5));
          incident.setLocation(geoPoint);
          
          incident.setDescription(resultSet.getString("description"));
          incident.setStatus(resultSet.getString("status"));
          incident.setVictimId(resultSet.getInt("victimID"));
          incident.setSuspectId(resultSet.getInt("suspectID"));

          matchingIncidents.add(incident);
        }
        if (matchingIncidents.isEmpty()) {
          throw new IncidentNotFoundException("No incidents found with type:" + criteria.getType());
        }
        return matchingIncidents;
      }
    } catch (SQLException e) {
      System.err.println("Error in sql command");
      return null;
    }
  }

  
  /**
   * Generates a report for a given incident.
   *
   * @param incident The incident for which the report is generated.
   * @return The generated report.
   * @throws IncidentNotFoundException.
   *                                   This exception is thrown if no report is found for the 
   *                                   specified incident.
   */
  public Report generateIncidentReport(Incident incident) throws IncidentNotFoundException {
    try {
      String query = "SELECT * FROM report WHERE incidentID = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, incident.getIncidentId());

      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        Report report = new Report();
        report.setReportId(resultSet.getInt("reportID"));
        report.setIncidentId(resultSet.getInt("incidentID"));
        report.setReportingOfficerId(resultSet.getInt("reportingOfficer"));
        report.setReportDate(resultSet.getString("reportDate"));
        report.setReportDetails(resultSet.getString("reportDetails"));
        report.setStatus(resultSet.getString("status"));
        return report;
      
      } else {
        throw new IncidentNotFoundException("Incident Not found in the database");
      }
      
    } catch (SQLException e) {
      System.err.println("Error in sql command");
    }
    return null;
  }

  /**
   * Creates a new case in the database with the given case description and associates it
   * with a collection of incidents in the case_incidents table.
   *
   * @param caseDescription The description of the case.
   * @param incidents       A collection of Incident objects associated with the case.
   * @return The created Case object with its associated incidents, or null if creation fails.
   */
  public boolean createCase(String caseDescription, Collection<Incident> incidents) {
    int caseId = 0;
    try {
      // Insert the new case into the cases table
      String insertCaseSql = "INSERT INTO cases (caseDescription) VALUES (?)";
      PreparedStatement statement = null;
      
      statement = connection.prepareStatement(insertCaseSql, Statement.RETURN_GENERATED_KEYS);
      statement.setString(1, caseDescription);

      int affectedRows = statement.executeUpdate();

      if (affectedRows == 0) {
        System.err.println("Creating case failed, no rows affected.");
      }
      ResultSet generatedKeys = statement.getGeneratedKeys();
      if (generatedKeys.next()) {
        caseId = generatedKeys.getInt(1);

        // Associate incidents with the case in the case_incidents table
        associateIncidentsWithCase(caseId, incidents);

      } else {
        System.err.println("Creating case failed, no ID obtained.");
      }
      statement.close();
    } catch (SQLException e) {
      System.err.println("Error in sql command");
      return false;
    }
    return true;
  }

  private void associateIncidentsWithCase(int caseId, Collection<Incident> incidents) {
    // Insert records into the case_incidents table to associate incidents with the case
    String insertCaseIncidentSql = "INSERT INTO case_incidents (caseId, incidentId) VALUES (?, ?)";
    try (PreparedStatement statement = connection.prepareStatement(insertCaseIncidentSql)) {
      for (Incident incident : incidents) {
        statement.setInt(1, caseId);
        statement.setInt(2, incident.getIncidentId());
        statement.addBatch();
      }
      statement.executeBatch();
    } catch (SQLException e) {
      System.err.println("Error in sql command");
    }
  }

  /**
   * Updates case details in the database.
   *
   * @param updatedCase The Case object with updated details.
   * @return true if the update is successful, false otherwise.
   */
  public boolean updateCaseDetails(Case updatedCase) {
    try {
      // Update case details in the cases table
      String updateCaseSql = "UPDATE cases SET caseDescription = ? WHERE caseId = ?";
      try (PreparedStatement statement = connection.prepareStatement(updateCaseSql)) {
        statement.setString(1, updatedCase.getCaseDescription());
        statement.setInt(2, updatedCase.getCaseId());

        int affectedRows = statement.executeUpdate();

        return affectedRows > 0;
      }
    } catch (SQLException e) {
      System.err.println("Error in sql command");
      return false;
    }
  }

  /**
   * Gets details of a specific case by caseId using SQL JOINs.
   *
   * @param caseId The unique identifier of the case.
   * @return The Case object with details.
   */
  public Case getCaseDetails(int caseId) {
    try {
      String selectCaseSql = "SELECT cases.caseId, cases.caseDescription, incident.incidentId " 
          + "FROM cases "
          + "JOIN case_incidents ON cases.caseId = case_incidents.caseId " 
          + "JOIN incident ON case_incidents.incidentId = incident.incidentId " 
          + "WHERE cases.caseId = ?";

      try (PreparedStatement statement = connection.prepareStatement(selectCaseSql)) {
        statement.setInt(1, caseId);
        ResultSet resultSet = statement.executeQuery();

        Case resultCase = null;
        List<Incident> incidents = new ArrayList<>();

        while (resultSet.next()) {
          if (resultCase == null) {
            int fetchedCaseId = resultSet.getInt("caseId");
            String caseDescription = resultSet.getString("caseDescription");
            resultCase = new Case(fetchedCaseId, caseDescription, incidents);
          }

          int incidentId = resultSet.getInt("incidentId");
          try {
            incidents.add(getIncidentById(incidentId));
          } catch (IncidentNotFoundException e) {
            System.out.println(e.getMessage());
          }
        }
        if (resultCase == null) {
          System.err.println("No case found with case Id : " + caseId);
        }
        return resultCase;
      }
    } catch (SQLException e) {
      System.err.println("Error in sql command");
      return null;
    }
  }

  /**
   * Gets details of an incident by incidentId.
   *
   * @param incidentId The unique identifier of the incident.
   * @return The Incident object with details.
   * @throws IncidentNotFoundException
   *                                  This exception is thrown if no report is found for the 
   *                                  specified incident.
   */
  public Incident getIncidentById(int incidentId) throws IncidentNotFoundException {
    Incident incident = new Incident();
    try {
      String selectIncidentSql = "SELECT incidentId,incidentType,incident"
          + "Date,ST_X(location),ST_Y(location),description,status,"
          + "victimId,suspectId FROM incident WHERE incidentId = ?";

      try (PreparedStatement statement = connection.prepareStatement(selectIncidentSql)) {
        statement.setInt(1, incidentId);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
          incident.setIncidentId(resultSet.getInt("incidentID"));
          incident.setIncidentType(resultSet.getString("incidentType"));
          incident.setIncidentDate(resultSet.getDate("incidentDate"));
          
          GeoPoint geoPoint = new GeoPoint(resultSet.getDouble(4), resultSet.getDouble(5));
          incident.setLocation(geoPoint);
          
          incident.setDescription(resultSet.getString("description"));
          incident.setStatus(resultSet.getString("status"));
          incident.setVictimId(resultSet.getInt("victimID"));
          incident.setSuspectId(resultSet.getInt("suspectID"));
          
        } else {
          throw new IncidentNotFoundException("Incident Not Found Exception");
        }
      }
    } catch (SQLException e) {
      System.err.println("Error in sql command");
      return null;
    }
    return incident;
  }

  @Override
  public List<Case> getAllCases() {
    List<Case> allCases = new ArrayList<>();

    try {
      String selectAllCasesSql = "SELECT DISTINCT caseId FROM cases";

      try (Statement statement = connection.createStatement()) {
        ResultSet resultSet = statement.executeQuery(selectAllCasesSql);

        while (resultSet.next()) {
          int caseId = resultSet.getInt("caseId");
          Case caseDetails = getCaseDetails(caseId);

          if (caseDetails != null) {
            allCases.add(caseDetails);
          }
        }
      }
    } catch (SQLException e) {
      System.err.println("Error in sql command");
    }

    return allCases;
  }
}

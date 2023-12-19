package com.hexaware.entity;

/**
 * Represents a report generated for an incident in an investigation.
 *
 * @author ROHITH
 */
public class Report {
  private int reportId;
  private int incidentId;
  private int reportingOfficerId;
  private String reportDate;
  private String reportDetails;
  private String status;

  // Getters and setters

  /**
   * Gets the unique identifier for the report.
   *
   * @return The report Id.
   */
  public int getReportId() {
    return reportId;
  }

  /**
   * Sets the report Id.
   *
   * @param reportId The report Id to set.
   */
  public void setReportId(int reportId) {
    this.reportId = reportId;
  }

  /**
   * Gets the ID of the incident associated with the report.
   *
   * @return The incident Id.
   */
  public int getIncidentId() {
    return incidentId;
  }

  /**
   * Sets the incident Id associated with the report.
   *
   * @param incidentId The incident Id to set.
   */
  public void setIncidentId(int incidentId) {
    this.incidentId = incidentId;
  }

  /**
   * Gets the ID of the reporting officer associated with the report.
   *
   * @return The reporting officer Id.
   */
  public int getReportingOfficerId() {
    return reportingOfficerId;
  }

  /**
   * Sets the reporting officer Id associated with the report.
   *
   * @param reportingOfficerId The reporting officer Id to set.
   */
  public void setReportingOfficerId(int reportingOfficerId) {
    this.reportingOfficerId = reportingOfficerId;
  }

  /**
   * Gets the date of the report.
   *
   * @return The report date.
   */
  public String getReportDate() {
    return reportDate;
  }

  /**
   * Sets the report date.
   *
   * @param reportDate The report date to set.
   */
  public void setReportDate(String reportDate) {
    this.reportDate = reportDate;
  }

  /**
   * Gets the details of the report.
   *
   * @return The report details.
   */
  public String getReportDetails() {
    return reportDetails;
  }

  /**
   * Sets the report details.
   *
   * @param reportDetails The report details to set.
   */
  public void setReportDetails(String reportDetails) {
    this.reportDetails = reportDetails;
  }

  /**
   * Gets the status of the report (e.g., Draft, Finalized).
   *
   * @return The report status.
   */
  public String getStatus() {
    return status;
  }

  /**
   * Sets the report status.
   *
   * @param status The report status to set.
   */
  public void setStatus(String status) {
    this.status = status;
  }
  
  @Override
  public String toString() {
    return "Report [reportId=" + reportId + ", incidentId=" + incidentId + ", "
        + "reportingOfficerId=" + reportingOfficerId
        + ", reportDate=" + reportDate + ", reportDetails=" 
        + reportDetails + ", status=" + status + "]";
  }
}

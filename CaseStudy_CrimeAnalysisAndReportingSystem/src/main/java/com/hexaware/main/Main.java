package com.hexaware.main;

import com.hexaware.controller.CrimeAnalysisController;
import com.hexaware.controller.CrimeAnalysisControllerInterface;
import com.hexaware.dao.CrimeAnalysisService;
import com.hexaware.dao.CrimeAnalysisServiceImpl;
import com.hexaware.entity.Case;
import com.hexaware.entity.Incident;
import com.hexaware.entity.Report;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

/**
 * Main class to run the Crime Analysis application.
 *
 * @author Rohith
 * @version 1.0
 */
public class Main {
  /**
   * Main method to simulate the Crime Analysis system.
   * Allow the user to interact with the system by entering choices from the menu.
   *
   * @param args The command-line arguments.
   */
  public static void main(String[] args) throws IOException {
    CrimeAnalysisService crimeAnalysisService = new CrimeAnalysisServiceImpl();
    CrimeAnalysisControllerInterface controller = new CrimeAnalysisController(crimeAnalysisService);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int choice = 0;

    String ch = "";
    do {
      System.out.println("Crime Analysis System Menu:");
      System.out.println("1. Create Incident");
      System.out.println("2. Update Incident Status");
      System.out.println("3. Get Incidents in Date Range");
      System.out.println("4. Search Incidents");
      System.out.println("5. Generate Incident Report");
      System.out.println("6. Create Case");
      System.out.println("7. Get Case Details");
      System.out.println("8. Update Case Details");
      System.out.println("9. Get All Cases");
      System.out.println("0. Exit");

      System.out.print("Enter your choice: ");

      try {
        choice = Integer.parseInt(reader.readLine());

        switch (choice) {
          case 1:
            if (controller.createIncident()) {
              System.out.println("Incident added successfully");
            } else {
              System.err.println("Cannot add Incident");
            }
            break;
          case 2:
            if (controller.updateIncidentStatus()) {
              System.out.println("Incident details updated successfully");
            } else {
              System.err.println("Cannot update Incident");
            }
            break;
          case 3:
            Collection<Incident> incidents = controller.getIncidentsInDateRange();
            for (Incident incident : incidents) {
              System.out.println(incident);
            }
            break;
          case 4:
            Collection<Incident> incidents1 = controller.searchIncidents();
            if (incidents1 != null) {
              for (Incident incident : incidents1) {
                System.out.println(incident);
              }
            }
            break;
          case 5:
            Report report = controller.generateIncidentReport();
            System.out.println(report);
            break;
          case 6:
            if (controller.createCase()) {
              System.out.println("Case created successfully");
            } else {
              System.out.println("Cannot create case");
            }
            break;
          case 7:
            Case cases = controller.getCaseDetails();
            System.out.println(cases);
            break;
          case 8:
            if (controller.updateCaseDetails()) {
              System.out.println("Case details Updated Successfully");
            } else {
              System.err.println("Cannot update case details");
            }
            break;
          case 9:
            Collection<Case> cases1 = controller.getAllCases();
            for (Case cases2 : cases1) {
              System.out.println(cases2);
            }
            break;
          case 0:
            System.out.println("Exiting Crime Analysis System. Goodbye!");
            break;
          default:
            System.out.println("Invalid choice. Please enter a valid option.");
            break;
        }
      } catch (IOException | NumberFormatException e) {
        e.printStackTrace();
      }
      System.out.println("Do you want to continue Y / y");
      ch = reader.readLine().toLowerCase();
    } while (ch.equals("y"));
  }

}

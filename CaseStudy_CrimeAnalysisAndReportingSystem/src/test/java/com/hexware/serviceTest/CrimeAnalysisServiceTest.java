package com.hexware.serviceTest;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import com.hexaware.dao.CrimeAnalysisServiceImpl;
import com.hexaware.entity.GeoPoint;
import com.hexaware.entity.Incident;
import com.hexaware.exception.IncidentNotFoundException;

public class CrimeAnalysisServiceTest {
    private CrimeAnalysisServiceImpl service;

    @Before
    public void setUp() {
        service = new CrimeAnalysisServiceImpl();
        
    }

    @Test
    public void testCreateIncident() throws ParseException {
    	String dateString = "2023-01-15"; 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(dateString);
        
        Incident incident = new Incident(1,"Robbery",date,new GeoPoint(40.7128, -74.0060),"Armed robbery in a store","Pending",1,3);
        assertTrue(service.createIncident(incident));
    }

    @Test
    public void testUpdateIncidentStatus(){
        int incidentId = 1;
        String newStatus = "Unarmed robbery in school";
        try {
        	assertTrue(service.updateIncidentStatus(newStatus, incidentId));
        }catch(IncidentNotFoundException e) {
        	System.out.println(e.getMessage());
        }
    }
    
    @Test(expected = IncidentNotFoundException.class)
    public void testUpdateIncidentStatusInvalid() throws IncidentNotFoundException {	
    	System.out.println("Inside testUpdateIncidentStatusInvalid()");
        int incidentId = 123; 
        String status = "Status";
        service.updateIncidentStatus(status, incidentId);
        fail("Expected IncidentNotFoundException but no exception was thrown.");
    }    
}

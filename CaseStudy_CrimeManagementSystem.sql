create database cars;
use cars;

CREATE TABLE Incident (
    IncidentID INT PRIMARY KEY,
    IncidentType VARCHAR(255),
    IncidentDate DATE,
    Location point, 
    Description TEXT,
    Status VARCHAR(50),
    VictimID INT,
    SuspectID INT,
    FOREIGN KEY (VictimID) REFERENCES Victim(VictimID),
    FOREIGN KEY (SuspectID) REFERENCES Suspect(SuspectID)
);

CREATE TABLE Victim (
    VictimID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    DateOfBirth DATE,
    Gender VARCHAR(10),
    Address Text,
    phoneNumber varchar(15)
);

CREATE TABLE Suspect (
    SuspectID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    DateOfBirth DATE,
    Gender VARCHAR(10),
    Address text,
    phoneNumber varchar(15)
);

CREATE TABLE LawEnforcementAgency (
    AgencyID INT PRIMARY KEY,
    AgencyName VARCHAR(255),
    Jurisdiction VARCHAR(255),
    ContactInformation VARCHAR(100)
);

CREATE TABLE Officer (
    OfficerID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    BadgeNumber VARCHAR(20),
    officer_Rank VARCHAR(50),
    ContactInformation TEXT,
    AgencyID INT,
    FOREIGN KEY (AgencyID) REFERENCES LawEnforcementAgency(AgencyID)
);

CREATE TABLE Evidence (
    EvidenceID INT PRIMARY KEY,
    Description TEXT,
    LocationFound VARCHAR(255),
    IncidentID INT,
    FOREIGN KEY (IncidentID) REFERENCES Incident(IncidentID)
);

CREATE TABLE Report (
    ReportID INT PRIMARY KEY,
    IncidentID INT,
    ReportingOfficer INT,
    ReportDate DATE,
    ReportDetails TEXT,
    Status VARCHAR(50),
    FOREIGN KEY (IncidentID) REFERENCES Incident(IncidentID),
    FOREIGN KEY (ReportingOfficer) REFERENCES Officer(OfficerID)
);

create table cases(caseId int auto_increment primary key, caseDescription varchar(50));
create table case_incidents(caseId int, incidentId int, foreign key (incidentId) references incident(incidentId)); 


INSERT INTO Victim (VictimID, FirstName, LastName, DateOfBirth, Gender, Address, PhoneNumber)
VALUES
  (1, 'John', 'Doe', '1990-05-15', 'Male', '123 Main St', '123-456-7890'),
  (2, 'Jane', 'Smith', '1985-08-20', 'Female', '456 Oak St', '987-654-3210'),
  (3, 'Mike', 'Johnson', '1993-02-10', 'Male', '789 Elm St', '111-222-3333'),
  (4, 'Sarah', 'Williams', '1982-11-25', 'Female', '567 Pine St', '444-555-6666'),
  (5, 'Robert', 'Brown', '1978-07-03', 'Male', '890 Birch St', '777-888-9999');

INSERT INTO Suspect (SuspectID, FirstName, LastName, DateOfBirth, Gender, Address, PhoneNumber)
VALUES
  (1, 'Eva', 'Martinez', '1989-04-18', 'Female', '111 Cedar St', '555-444-3333'),
  (2, 'Carlos', 'Lee', '1995-09-22', 'Male', '222 Maple St', '666-777-8888'),
  (3, 'Maria', 'Garcia', '1983-12-07', 'Female', '333 Pine St', '999-111-2222'),
  (4, 'Alex', 'Rodriguez', '1977-06-14', 'Male', '444 Oak St', '123-456-7890'),
  (5, 'Linda', 'Lopez', '1991-03-30', 'Female', '555 Elm St', '987-654-3210');

INSERT INTO incident (incidentID, incidentType, incidentDate, location, description, status, victimID, suspectID) VALUES
  (1, 'Robbery', '2023-01-01', POINT(40.7128, -74.0060), 'Armed robbery at a store', 'Investigating', 1, 2),
  (2, 'Assault', '2023-01-02', POINT(34.0522, -118.2437), 'Physical assault reported', 'Under review', 2, 2),
  (3, 'Burglary', '2023-01-03', POINT(41.8781, -87.6298), 'Break-in at a residence', 'Open', 3, 3),
  (4, 'Vandalism', '2023-01-04', POINT(37.7749, -122.4194), 'Property damage reported', 'Closed', 4, 4),
  (5, 'Fraud', '2023-01-05', POINT(33.7490, -84.3880), 'Identity theft case', 'Pending', 5, 5);


insert into report values(1, 1, 101, '2023-01-10', 'Details for Incident 1', 'Completed'),
(2, 2, 102, '2023-01-11', 'Details for Incident 2', 'InProgress'),
(3, 3, 103, '2023-01-12', 'Details for Incident 3', 'Completed'),
(4, 4, 104, '2023-01-13', 'Details for Incident 4', 'InProgress');


INSERT INTO officer (officerID, firstName, lastName, badgeNumber, officer_rank)
VALUES (101, 'John', 'Doe', '123', 'Detective'),
(102, 'Jane', 'Smith', '456', 'Sergeant'),
(103, 'Michael', 'Johnson', '789', 'Lieutenant'),
(104, 'Emily', 'Davis', '321', 'Detective'),
(105, 'Christopher', 'Wilson', '654', 'Captain');




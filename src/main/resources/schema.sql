CREATE TABLE Users (
    userID INT AUTO_INCREMENT PRIMARY KEY,
    LastName VARCHAR(255) NOT NULL,
    FirstName VARCHAR(255) NOT NULL,
    Telephone VARCHAR(20) NOT NULL,
    DateOfBirth DATE,
    Gender VARCHAR(20) NOT NULL CHECK (Gender IN ('Male', 'Female', 'Other')),
    Email VARCHAR(255) UNIQUE NOT NULL,
    HashedPassword VARCHAR(255) NOT NULL, -- Strong (At least 8 characters with 1 uppercase, lowercase, digit, special character) and must be hashed during registration.
    RegistrationDate DATETIME NOT NULL,
    PreferredLanguage VARCHAR(50) NOT NULL, -- Language entered or retrieved via user's device.
    Profession VARCHAR(100),
    HobbiesInterests TEXT,
    EmergencyContact VARCHAR(255),
    ProfilePhoto VARCHAR(255),
    IsActive Boolean,
    Role VARCHAR(20) NOT NULL CHECK (role IN ('Driver', 'Passenger'))
);


CREATE TABLE Cars (
    CarID INT AUTO_INCREMENT PRIMARY KEY,
    DriverID INT NOT NULL,
    Brand VARCHAR(100) NOT NULL,
    Model VARCHAR(100) NOT NULL,
    CarYear INT NOT NULL, -- 4 characters
    Color VARCHAR(50) NOT NULL,
    LicensePlate VARCHAR(20) NOT NULL,
    SerialNumber VARCHAR(50) NOT NULL, -- Serial number or identification number (NIV)
    NumberOfSeats INT NOT NULL,
    FOREIGN KEY (DriverID) REFERENCES Users(userID)
);

CREATE TABLE DaysOfWeek (
    DayID INT AUTO_INCREMENT PRIMARY KEY,
    DayName VARCHAR(20) NOT NULL
);

CREATE TABLE Trajets (
    TrajetID INT AUTO_INCREMENT PRIMARY KEY,
    DepartureAddress VARCHAR(255) NOT NULL,
    DestinationAddress VARCHAR(255) NOT NULL,
    DesiredDepartureTime DATETIME NOT NULL,
    DesiredArrivalTime DATETIME,
    UserID INT NOT NULL,
    DayID INT NOT NULL,
    DepartureLatitude DECIMAL(10, 8),
    DepartureLongitude DECIMAL(11, 8),
    DestinationLatitude DECIMAL(10, 8),
    DestinationLongitude DECIMAL(11, 8),
    FOREIGN KEY (UserID) REFERENCES Users(userID),
    FOREIGN KEY (DayID) REFERENCES DaysOfWeek(DayID)
);

CREATE TABLE Journeys (
    JourneyID INT AUTO_INCREMENT PRIMARY KEY,
    DriverID INT NOT NULL,
    TrajetID INT NOT NULL,
    AvailableSeats INT NOT NULL,
    Price DECIMAL(10, 2) NOT NULL,
    JourneyCreationDate DATETIME NOT NULL,
    IsActive BOOLEAN, -- TRUE or FALSE
    FOREIGN KEY (DriverID) REFERENCES Users(userID),
    FOREIGN KEY (TrajetID) REFERENCES Trajets(TrajetID)
);

CREATE TABLE Reservations (
    reservationID INT AUTO_INCREMENT PRIMARY KEY,
    PassengerID INT NOT NULL,
    JourneyID INT NOT NULL,
    ReservationDate DATETIME NOT NULL,
    ReservationStatus VARCHAR(20) NOT NULL CHECK (ReservationStatus IN ('Confirmed', 'Pending', 'Cancelled')),
    FOREIGN KEY (PassengerID) REFERENCES Users(userID),
    FOREIGN KEY (JourneyID) REFERENCES Journeys(journeyID)
);

CREATE TABLE Ratings (
    ratingID INT AUTO_INCREMENT PRIMARY KEY,
    RaterID INT NOT NULL,
    RatedID INT NOT NULL,
    Score INT NOT NULL,
    RatingDate DATETIME NOT NULL,
    Comment TEXT,
    FOREIGN KEY (RaterID) REFERENCES Users(userID),
    FOREIGN KEY (RatedID) REFERENCES Users(userID)
);

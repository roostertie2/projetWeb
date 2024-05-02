-- Insertion de données dans la table User
INSERT INTO Users (LastName, FirstName, Telephone, DateOfBirth, Gender, Email, HashedPassword, RegistrationDate, PreferredLanguage, Profession, HobbiesInterests, EmergencyContact, ProfilePhoto, IsActive, role)
VALUES
    ('Doe', 'John', '1234567890', '1990-01-01', 'Male', 'john1@example.com', 'hashedpass1', NOW(), 'English', 'Engineer', 'Reading, hiking', 'Jane Doe (sister)', 'photo1.jpg', 'TRUE', 'Driver'),
    ('Smith', 'Alice', '9876543210', '1985-05-15', 'Female', 'alice2@example.com', 'hashedpass2', NOW(), 'English', 'Teacher', 'Music, painting', 'Bob Smith (brother)', 'photo2.jpg', 'TRUE', 'Passenger'),
    ('Johnson', 'Michael', '5551234567', '1982-09-20', 'Male', 'michael3@example.com', 'hashedpass3', NOW(), 'English', 'Doctor', 'Cooking, traveling', 'Mary Johnson (wife)', 'photo3.jpg', 'TRUE', 'Driver'),
    ('Brown', 'Emily', '4447890123', '1995-03-10', 'Female', 'emily4@example.com', 'hashedpass4', NOW(), 'French', 'Artist', 'Photography, writing', 'David Brown (father)', 'photo4.jpg', 'TRUE', 'Passenger'),
    ('Garcia', 'Daniel', '3334567890', '1988-11-28', 'Male', 'daniel5@example.com', 'hashedpass5', NOW(), 'Spanish', 'Lawyer', 'Soccer, gardening', 'Maria Garcia (sister)', 'photo5.jpg', 'TRUE', 'Driver'),
    ('Kim', 'Soo', '1231231234', '1987-06-12', 'Male', 'soo6@example.com', 'hashedpass6', NOW(), 'Korean', 'Chef', 'Cooking, fishing', 'Kim Min (mother)', 'photo6.jpg', 'TRUE', 'Driver'),
    ('Chen', 'Li', '4564564567', '1993-09-25', 'Female', 'li7@example.com', 'hashedpass7', NOW(), 'Chinese', 'Software Engineer', 'Coding, hiking', 'Chen Wei (brother)', 'photo7.jpg', 'TRUE', 'Driver'),
    ('Singh', 'Raj', '7897897890', '1980-12-08', 'Male', 'raj8@example.com', 'hashedpass8', NOW(), 'Hindi', 'Doctor', 'Yoga, reading', 'Singh Amar (father)', 'photo8.jpg', 'TRUE', 'Driver'),
    ('Gonzalez', 'Maria', '3216549870', '1996-04-18', 'Female', 'maria9@example.com', 'hashedpass9', NOW(), 'Spanish', 'Nurse', 'Dancing, cooking', 'Gonzalez Luis (brother)', 'photo9.jpg', 'TRUE', 'Driver'),
    ('Yamada', 'Takashi', '9879876543', '1984-02-03', 'Male', 'takashi10@example.com', 'hashedpass10', NOW(), 'Japanese', 'Architect', 'Drawing, gardening', 'Yamada Sakura (wife)', 'photo10.jpg', 'TRUE', 'Driver'),
    ('Lee', 'Ji', '6543217890', '1991-07-22', 'Female', 'ji11@example.com', 'hashedpass11', NOW(), 'Korean', 'Teacher', 'Music, traveling', 'Lee Minho (brother)', 'photo11.jpg', 'TRUE', 'Passenger'),
    ('Wang', 'Xiao', '1472583690', '1989-10-30', 'Male', 'xiao12@example.com', 'hashedpass12', NOW(), 'Chinese', 'Entrepreneur', 'Business, hiking', 'Wang Wei (father)', 'photo12.jpg', 'TRUE', 'Driver'),
    ('Nguyen', 'Huyen', '3692581470', '1990-05-05', 'Female', 'huyen13@example.com', 'hashedpass13', NOW(), 'Vietnamese', 'Engineer', 'Technology, cooking', 'Nguyen Minh (husband)', 'photo13.jpg', 'TRUE', 'Passenger'),
    ('Kumar', 'Rahul', '2583691470', '1986-11-15', 'Male', 'rahul14@example.com', 'hashedpass14', NOW(), 'Hindi', 'Lawyer', 'Reading, sports', 'Kumar Rajesh (brother)', 'photo14.jpg', 'TRUE', 'Driver'),
    ('Fernandez', 'Luisa', '9876541230', '1983-08-11', 'Female', 'luisa15@example.com', 'hashedpass15', NOW(), 'Spanish', 'Artist', 'Painting, hiking', 'Fernandez Miguel (father)', 'photo15.jpg', 'TRUE', 'Driver'),
    ('Kato', 'Yuki', '4561237890', '1997-03-27', 'Male', 'yuki16@example.com', 'hashedpass16', NOW(), 'Japanese', 'Doctor', 'Skiing, photography', 'Kato Hiroshi (uncle)', 'photo16.jpg', 'TRUE', 'Driver'),
    ('Chowdhury', 'Aisha', '3219876540', '1994-01-09', 'Female', 'aisha17@example.com', 'hashedpass17', NOW(), 'Bengali', 'Software Engineer', 'Coding, reading', 'Chowdhury Abdul (father)', 'photo17.jpg', 'TRUE', 'Driver'),
    ('Lopez', 'Javier', '9871234560', '1981-09-03', 'Male', 'javier18@example.com', 'hashedpass18', NOW(), 'Spanish', 'Chef', 'Cooking, soccer', 'Lopez Carlos (brother)', 'photo18.jpg', 'TRUE', 'Driver'),
    ('Ali', 'Fatima', '6549873210', '1988-06-20', 'Female', 'fatima19@example.com', 'hashedpass19', NOW(), 'Urdu', 'Teacher', 'Music, gardening', 'Ali Ahmed (father)', 'photo19.jpg', 'TRUE', 'Driver'),
    ('Park', 'Min', '1234569870', '1992-12-04', 'Male', 'min20@example.com', 'hashedpass20', NOW(), 'Korean', 'Entrepreneur', 'Business, hiking', 'Park Jisoo (sister)', 'photo20.jpg', 'TRUE', 'Driver'),
    ('Gupta', 'Anjali', '9876547890', '1987-04-14', 'Female', 'anjali21@example.com', 'hashedpass21', NOW(), 'Hindi', 'Nurse', 'Dancing, cooking', 'Gupta Sanjay (husband)', 'photo21.jpg', 'TRUE', 'Driver'),
    ('Tanaka', 'Haruto', '3216549870', '1995-10-07', 'Male', 'haruto22@example.com', 'hashedpass22', NOW(), 'Japanese', 'Architect', 'Drawing, traveling', 'Tanaka Hikari (wife)', 'photo22.jpg', 'TRUE', 'Driver'),
    ('Ma', 'Xiaojie', '4561237890', '1990-03-13', 'Female', 'xiaojie23@example.com', 'hashedpass23', NOW(), 'Chinese', 'Engineer', 'Technology, cooking', 'Ma Wei (father)', 'photo23.jpg', 'TRUE', 'Driver'),
    ('Tran', 'Linh', '7894561230', '1984-07-31', 'Male', 'linh24@example.com', 'hashedpass24', NOW(), 'Vietnamese', 'Lawyer', 'Reading, soccer', 'Tran Minh (brother)', 'photo24.jpg', 'TRUE', 'Driver'),
    ('Chen', 'Yan', '3692581470', '1996-05-15', 'Female', 'yan25@example.com', 'hashedpass25', NOW(), 'Chinese', 'Artist', 'Painting, hiking', 'Chen Wei (father)', 'photo25.jpg', 'TRUE', 'Driver'),
    ('Singh', 'Aman', '2583691470', '1982-11-24', 'Male', 'aman26@example.com', 'hashedpass26', NOW(), 'Hindi', 'Doctor', 'Yoga, reading', 'Singh Amar (father)', 'photo26.jpg', 'TRUE', 'Driver'),
    ('Rodriguez', 'Gabriela', '9876543210', '1993-01-05', 'Female', 'gabriela27@example.com', 'hashedpass27', NOW(), 'Spanish', 'Teacher', 'Music, traveling', 'Rodriguez Jose (brother)', 'photo27.jpg', 'TRUE', 'Driver'),
    ('Suzuki', 'Takahiro', '6549873210', '1980-08-18', 'Male', 'takahiro28@example.com', 'hashedpass28', NOW(), 'Japanese', 'Entrepreneur', 'Business, hiking', 'Suzuki Ryu (father)', 'photo28.jpg', 'TRUE', 'Driver'),
    ('Ahmed', 'Nadia', '1234569870', '1997-04-26', 'Female', 'nadia29@example.com', 'hashedpass29', NOW(), 'Urdu', 'Software Engineer', 'Coding, reading', 'Ahmed Abdul (father)', 'photo29.jpg', 'TRUE', 'Passenger'),
    ('Gomez', 'Miguel', '9871234560', '1985-10-10', 'Male', 'miguel30@example.com', 'hashedpass30', NOW(), 'Spanish', 'Chef', 'Cooking, soccer', 'Gomez Carlos (brother)', 'photo30.jpg', 'TRUE', 'Driver'),
    ('Sinha', 'Ananya', '6543219870', '1991-06-03', 'Female', 'ananya31@example.com', 'hashedpass31', NOW(), 'Hindi', 'Teacher', 'Music, gardening', 'Sinha Sanjay (husband)', 'photo31.jpg', 'TRUE', 'Driver'),
    ('Choi', 'Joon', '1472583690', '1988-11-13', 'Male', 'joon32@example.com', 'hashedpass32', NOW(), 'Korean', 'Nurse', 'Dancing, cooking', 'Choi Min (mother)', 'photo32.jpg', 'TRUE', 'Driver'),
    ('Wu', 'Yan', '3692581470', '1983-05-22', 'Female', 'yan33@example.com', 'hashedpass33', NOW(), 'Chinese', 'Entrepreneur', 'Business, hiking', 'Wu Wei (father)', 'photo33.jpg', 'TRUE', 'Driver'),
    ('Le', 'Nam', '2583691470', '1992-12-16', 'Male', 'nam34@example.com', 'hashedpass34', NOW(), 'Vietnamese', 'Lawyer', 'Reading, soccer', 'Le Minh (brother)', 'photo34.jpg', 'TRUE', 'Driver'),
    ('Cheng', 'Xiao', '7896541230', '1981-09-29', 'Female', 'xiao35@example.com', 'hashedpass35', NOW(), 'Chinese', 'Artist', 'Painting, hiking', 'Cheng Wei (father)', 'photo35.jpg', 'TRUE', 'Driver'),
    ('Patel', 'Amit', '3219876540', '1989-07-08', 'Male', 'amit36@example.com', 'hashedpass36', NOW(), 'Hindi', 'Doctor', 'Yoga, reading', 'Patel Amar (father)', 'photo36.jpg', 'TRUE', 'Driver'),
    ('Fuentes', 'Isabella', '9876541230', '1996-02-19', 'Female', 'isabella37@example.com', 'hashedpass37', NOW(), 'Spanish', 'Teacher', 'Music, traveling', 'Fuentes Jose (brother)', 'photo37.jpg', 'TRUE', 'Driver'),
    ('Nakamura', 'Ryu', '4561237890', '1984-10-26', 'Male', 'ryu38@example.com', 'hashedpass38', NOW(), 'Japanese', 'Entrepreneur', 'Business, hiking', 'Nakamura Yuki (wife)', 'photo38.jpg', 'TRUE', 'Driver'),
    ('Rahman', 'Fatima', '3216549870', '1990-06-08', 'Female', 'fatima39@example.com', 'hashedpass39', NOW(), 'Urdu', 'Software Engineer', 'Coding, reading', 'Rahman Ahmed (father)', 'photo39.jpg', 'TRUE', 'Passenger'),
    ('Martinez', 'Diego', '9871234560', '1982-03-17', 'Male', 'diego40@example.com', 'hashedpass40', NOW(), 'Spanish', 'Chef', 'Cooking, soccer', 'Martinez Carlos (brother)', 'photo40.jpg', 'TRUE', 'Driver'),
    ('Jain', 'Priya', '6549873210', '1987-11-30', 'Female', 'priya41@example.com', 'hashedpass41', NOW(), 'Hindi', 'Teacher', 'Music, gardening', 'Jain Sanjay (husband)', 'photo41.jpg', 'TRUE', 'Passenger'),('Kim', 'Min', '1234569870', '1993-05-12', 'Male', 'min42@example.com', 'hashedpass42', NOW(), 'Korean', 'Nurse', 'Dancing, cooking', 'Kim Min (mother)', 'photo42.jpg', 'TRUE', 'Driver'),
    ('Li', 'Xiaoli', '4561237890', '1988-09-23', 'Female', 'xiaoli43@example.com', 'hashedpass43', NOW(), 'Chinese', 'Entrepreneur', 'Business, hiking', 'Li Wei (father)', 'photo43.jpg', 'TRUE', 'Passenger'),
    ('Tran', 'Hoa', '7894561230', '1985-02-07', 'Male', 'hoa44@example.com', 'hashedpass44', NOW(), 'Vietnamese', 'Lawyer', 'Reading, soccer', 'Tran Minh (brother)', 'photo44.jpg', 'TRUE', 'Driver'),
    ('Zhang', 'Yan', '3692581470', '1991-10-19', 'Female', 'yan45@example.com', 'hashedpass45', NOW(), 'Chinese', 'Artist', 'Painting, hiking', 'Zhang Wei (father)', 'photo45.jpg', 'TRUE', 'Driver'),
    ('Singh', 'Rajesh', '2583691470', '1987-04-29', 'Male', 'rajesh46@example.com', 'hashedpass46', NOW(), 'Hindi', 'Doctor', 'Yoga, reading', 'Singh Amar (father)', 'photo46.jpg', 'TRUE', 'Driver'),
    ('Santos', 'Ana', '9876543210', '1994-02-14', 'Female', 'ana47@example.com', 'hashedpass47', NOW(), 'Spanish', 'Teacher', 'Music, traveling', 'Santos Jose (brother)', 'photo47.jpg', 'TRUE', 'Passenger'),
    ('Abe', 'Takumi', '6549873210', '1983-09-03', 'Male', 'takumi48@example.com', 'hashedpass48', NOW(), 'Japanese', 'Entrepreneur', 'Business, hiking', 'Abe Ryu (father)', 'photo48.jpg', 'TRUE', 'Driver'),
    ('Hussain', 'Aisha', '1234569870', '1998-06-26', 'Female', 'aisha49@example.com', 'hashedpass49', NOW(), 'Urdu', 'Software Engineer', 'Coding, reading', 'Hussain Abdul (father)', 'photo49.jpg', 'TRUE', 'Passenger'),
    ('Gonzalez', 'Pedro', '9871234560', '1981-02-18', 'Male', 'pedro50@example.com', 'hashedpass50', NOW(), 'Spanish', 'Chef', 'Cooking, soccer', 'Gonzalez Carlos (brother)', 'photo50.jpg', 'TRUE', 'Driver');
-- Insertion de données dans la table Cars
INSERT INTO Cars (DriverID, Brand, Model, CarYear, Color, LicensePlate, SerialNumber, NumberOfSeats)
VALUES 
(1, 'Toyota', 'Camry', 2018, 'Blue', 'ABC123', '1234567890', 5),
(3, 'Honda', 'Civic', 2019, 'Red', 'DEF456', '0987654321', 4),
(5, 'Ford', 'Focus', 2017, 'Black', 'GHI789', '5678901234', 4),
(22, 'Chevrolet', 'Malibu', 2020, 'Silver', 'JKL012', '3456789012', 5),
(4, 'BMW', 'X5', 2016, 'White', 'MNO345', '7890123456', 7),
(14, 'Toyota', 'Corolla', 2018, 'Blue', 'ABC123', '1234567890', 5),
(23, 'Honda', 'Civic', 2019, 'Red', 'XYZ456', '2345678901', 4),
(43, 'Ford', 'Fusion', 2017, 'Black', 'DEF789', '3456789012', 5),
(24, 'Chevrolet', 'Malibu', 2020, 'White', 'GHI012', '4567890123', 4),
(25, 'Nissan', 'Altima', 2016, 'Silver', 'JKL345', '5678901234', 5),
(26, 'Toyota', 'Camry', 2019, 'Gray', 'MNO678', '6789012345', 5),
(27, 'Honda', 'Accord', 2015, 'Black', 'PQR901', '7890123456', 4),
(28, 'Ford', 'Focus', 2018, 'White', 'STU234', '8901234567', 5),
(29, 'Chevrolet', 'Impala', 2021, 'Red', 'VWX567', '9012345678', 4),
(10, 'Nissan', 'Maxima', 2017, 'Blue', 'YZA890', '0123456789', 5),
(11, 'Toyota', 'Prius', 2019, 'Green', 'BCD234', '1234567890', 5),
(12, 'Honda', 'Fit', 2016, 'Silver', 'CDE567', '2345678901', 4),
(13, 'Ford', 'Mustang', 2020, 'Red', 'EFG890', '3456789012', 5),
(14, 'Chevrolet', 'Cruze', 2018, 'Gray', 'HIJ123', '4567890123', 4),
(15, 'Nissan', 'Sentra', 2015, 'Black', 'JKL456', '5678901234', 5),
(16, 'Toyota', 'Rav4', 2019, 'Blue', 'MNO789', '6789012345', 5),
(17, 'Honda', 'Pilot', 2017, 'White', 'PQR012', '7890123456', 4),
(18, 'Ford', 'Escape', 2016, 'Silver', 'STU345', '8901234567', 5),
(19, 'Chevrolet', 'Equinox', 2021, 'Black', 'VWX678', '9012345678', 4),
(10, 'Nissan', 'Rogue', 2018, 'Red', 'YZA901', '0123456789', 5),
(16, 'Toyota', 'Highlander', 2019, 'Gray', 'BCD345', '1234567890', 5),
(32, 'Honda', 'Odyssey', 2016, 'White', 'CDE678', '2345678901', 7),
(33, 'Ford', 'Explorer', 2020, 'Black', 'EFG901', '3456789012', 7),
(34, 'Chevrolet', 'Tahoe', 2018, 'Blue', 'HIJ234', '4567890123', 7),
(35, 'Nissan', 'Pathfinder', 2015, 'Red', 'JKL567', '5678901234', 7),
(36, 'Toyota', 'Sienna', 2019, 'Silver', 'MNO890', '6789012345', 7),
(37, 'Honda', 'CR-V', 2017, 'Gray', 'PQR123', '7890123456', 5),
(38, 'Ford', 'Expedition', 2016, 'Black', 'STU456', '8901234567', 7),
(39, 'Chevrolet', 'Suburban', 2021, 'White', 'VWX789', '9012345678', 7),
(40, 'Nissan', 'Armada', 2018, 'Blue', 'YZA012', '0123456789', 7),
(41, 'Toyota', 'Tacoma', 2019, 'Red', 'BCD456', '1234567890', 5),
(42, 'Honda', 'Ridgeline', 2016, 'Gray', 'CDE789', '2345678901', 5),
(13, 'Ford', 'F-150', 2020, 'Black', 'EFG012', '3456789012', 5),
(44, 'Chevrolet', 'Silverado', 2018, 'Silver', 'HIJ345', '4567890123', 5),
(45, 'Nissan', 'Frontier', 2015, 'Blue', 'JKL678', '5678901234', 5),
(46, 'Toyota', 'Tundra', 2019, 'White', 'MNO901', '6789012345', 5),
(47, 'Honda', 'Pilot', 2017, 'Black', 'PQR234', '7890123456', 7),
(48, 'Ford', 'Expedition', 2016, 'Red', 'STU567', '8901234567', 7),
(49, 'Chevrolet', 'Suburban', 2021, 'Gray', 'VWX890', '9012345678', 7),
(30, 'Nissan', 'Armada', 2018, 'White', 'YZA123', '0123456789', 7),
(1, 'Toyota', '4Runner', 2019, 'Black', 'BCD567', '1234567890', 5),
(2, 'Honda', 'Pilot', 2016, 'Silver', 'CDE890', '2345678901', 7),
(23, 'Ford', 'Explorer', 2020, 'Red', 'EFG123', '3456789012', 7),
(24, 'Chevrolet', 'Traverse', 2018, 'Gray', 'HIJ456', '4567890123', 7),
(5, 'Nissan', 'Rogue', 2015, 'Black', 'JKL789', '5678901234', 7),
(6, 'Toyota', 'Highlander', 2019, 'Blue', 'MNO012', '6789012345', 7),
(7, 'Honda', 'CR-V', 2017, 'White', 'PQR345', '7890123456', 5),
(8, 'Ford', 'Escape', 2016, 'Gray', 'STU678', '8901234567', 5),
(9, 'Chevrolet', 'Equinox', 2021, 'Red', 'VWX901', '9012345678', 5),
(10, 'Nissan', 'Pathfinder', 2018, 'Silver', 'YZA234', '0123456789', 7);


-- Insertion de données dans la table DaysOfWeek
INSERT INTO DaysOfWeek (DayName) VALUES
('Monday'),
('Tuesday'),
('Wednesday'),
('Thursday'),
('Friday'),
('Saturday'),
('Sunday');

-- Insertion de données dans la table Trajets
INSERT INTO Trajets (DepartureAddress, DestinationAddress, DesiredDepartureTime, DesiredArrivalTime, UserID, DayID)
VALUES 
('123 Main St', '456 Oak St', '2024-04-05 08:00:00', '2024-04-05 09:00:00', 1, 1),
('789 Elm St', '321 Pine St', '2024-04-06 09:00:00', '2024-04-06 10:00:00', 2, 2),
('555 Maple St', '888 Birch St', '2024-04-07 10:00:00', '2024-04-07 11:00:00', 3, 3),
('222 Cedar St', '999 Walnut St', '2024-04-08 11:00:00', '2024-04-08 12:00:00', 4, 4),
('777 Spruce St', '444 Cherry St', '2024-04-09 12:00:00', '2024-04-09 13:00:00', 5, 5),
('123 Main St', '456 Oak St', '2024-04-05 08:00:00', '2024-04-05 09:00:00', 1, 1),
('789 Elm St', '321 Pine St', '2024-04-06 09:00:00', '2024-04-06 10:00:00', 2, 2),
('555 Maple St', '888 Birch St', '2024-04-07 10:00:00', '2024-04-07 11:00:00', 3, 3),
('222 Cedar St', '999 Walnut St', '2024-04-08 11:00:00', '2024-04-08 12:00:00', 4, 4),
('777 Spruce St', '444 Cherry St', '2024-04-09 12:00:00', '2024-04-09 13:00:00', 5, 5),
('111 Pine St', '222 Elm St', '2024-04-10 13:00:00', '2024-04-10 14:00:00', 1, 6),
('333 Oak St', '444 Maple St', '2024-04-11 14:00:00', '2024-04-11 15:00:00', 2, 7),
('555 Birch St', '666 Cedar St', '2024-04-12 15:00:00', '2024-04-12 16:00:00', 3, 1),
('777 Walnut St', '888 Spruce St', '2024-04-13 16:00:00', '2024-04-13 17:00:00', 4, 2),
('999 Cherry St', '111 Pine St', '2024-04-14 17:00:00', '2024-04-14 18:00:00', 5, 3),
('222 Elm St', '333 Oak St', '2024-04-15 18:00:00', '2024-04-15 19:00:00', 1, 4),
('444 Maple St', '555 Birch St', '2024-04-16 19:00:00', '2024-04-16 20:00:00', 2, 5),
('666 Cedar St', '777 Walnut St', '2024-04-17 20:00:00', '2024-04-17 21:00:00', 3, 6),
('888 Spruce St', '999 Cherry St', '2024-04-18 21:00:00', '2024-04-18 22:00:00', 4, 7),
('111 Pine St', '222 Elm St', '2024-04-19 22:00:00', '2024-04-19 23:00:00', 5, 1),
('333 Oak St', '444 Maple St', '2024-04-20 23:00:00', '2024-04-21 00:00:00', 1, 2),
('555 Birch St', '666 Cedar St', '2024-04-22 00:00:00', '2024-04-22 01:00:00', 2, 3),
('777 Walnut St', '888 Spruce St', '2024-04-23 01:00:00', '2024-04-23 02:00:00', 3, 4),
('999 Cherry St', '111 Pine St', '2024-04-24 02:00:00', '2024-04-24 03:00:00', 4, 5),
('222 Elm St', '333 Oak St', '2024-04-25 03:00:00', '2024-04-25 04:00:00', 5, 6),
('444 Maple St', '555 Birch St', '2024-04-26 04:00:00', '2024-04-26 05:00:00', 1, 7),
('666 Cedar St', '777 Walnut St', '2024-04-27 05:00:00', '2024-04-27 06:00:00', 2, 1),
('888 Spruce St', '999 Cherry St', '2024-04-28 06:00:00', '2024-04-28 07:00:00', 3, 2),
('111 Pine St', '222 Elm St', '2024-04-29 07:00:00', '2024-04-29 08:00:00', 4, 3),
('333 Oak St', '444 Maple St', '2024-04-30 08:00:00', '2024-04-30 09:00:00', 5, 4),
('555 Birch St', '666 Cedar St', '2024-05-01 09:00:00', '2024-05-01 10:00:00', 1, 5),
('777 Walnut St', '888 Spruce St', '2024-05-02 10:00:00', '2024-05-02 11:00:00', 2, 6),
('999 Cherry St', '111 Pine St', '2024-05-03 11:00:00', '2024-05-03 12:00:00', 3, 7),
('222 Elm St', '333 Oak St', '2024-05-04 12:00:00', '2024-05-04 13:00:00', 4, 1),
('444 Maple St', '555 Birch St', '2024-05-05 13:00:00', '2024-05-05 14:00:00', 5, 2),
('666 Cedar St', '777 Walnut St', '2024-05-06 14:00:00', '2024-05-06 15:00:00', 1, 3),
('888 Spruce St', '999 Cherry St', '2024-05-07 15:00:00', '2024-05-07 16:00:00', 2, 4),
('111 Pine St', '222 Elm St', '2024-05-08 16:00:00', '2024-05-08 17:00:00', 3, 5),
('333 Oak St', '444 Maple St', '2024-05-09 17:00:00', '2024-05-09 18:00:00', 4, 6),
('555 Birch St', '666 Cedar St', '2024-05-10 18:00:00', '2024-05-10 19:00:00', 5, 7),
('777 Walnut St', '888 Spruce St', '2024-05-11 19:00:00', '2024-05-11 20:00:00', 1, 1),
('999 Cherry St', '111 Pine St', '2024-05-12 20:00:00', '2024-05-12 21:00:00', 2, 2),
('222 Elm St', '333 Oak St', '2024-05-13 21:00:00', '2024-05-13 22:00:00', 3, 3),
('444 Maple St', '555 Birch St', '2024-05-14 22:00:00', '2024-05-14 23:00:00', 4, 4),
('666 Cedar St', '777 Walnut St', '2024-05-15 23:00:00', '2024-05-16 00:00:00', 5, 5),
('888 Spruce St', '999 Cherry St', '2024-05-16 00:00:00', '2024-05-16 01:00:00', 1, 6),
('111 Pine St', '222 Elm St', '2024-05-17 01:00:00', '2024-05-17 02:00:00', 2, 7),
('333 Oak St', '444 Maple St', '2024-05-18 02:00:00', '2024-05-18 03:00:00', 3, 1),
('555 Birch St', '666 Cedar St', '2024-05-19 03:00:00', '2024-05-19 04:00:00', 4, 2);


-- Insertion de données dans la table Journeys
INSERT INTO Journeys (DriverID, TrajetID, AvailableSeats, Price, JourneyCreationDate, IsActive)
VALUES 
(1, 1, 3, 20.00, NOW(), 'FALSE'),
(2, 2, 2, 15.00, NOW(), 'FALSE'),
(3, 3, 4, 25.00, NOW(), 'TRUE'),
(4, 4, 3, 18.00, NOW(), 'TRUE'),
(5, 5, 5, 30.00, NOW(), 'TRUE'),
(1, 1, 3, 20.00, NOW(), 'TRUE'),
(2, 2, 2, 15.00, NOW(), 'TRUE'),
(3, 3, 4, 25.00, NOW(), 'TRUE'),
(4, 4, 3, 20.00, NOW(), 'TRUE'),
(5, 5, 2, 15.00, NOW(), 'TRUE'),
(6, 6, 4, 25.00, NOW(), 'FALSE'),
(7, 7, 3, 20.00, NOW(), 'TRUE'),
(8, 8, 2, 15.00, NOW(), 'TRUE'),
(9, 9, 4, 25.00, NOW(), 'TRUE'),
(10, 10, 3, 20.00, NOW(), 'TRUE'),
(1, 11, 2, 15.00, NOW(), 'TRUE'),
(2, 12, 4, 25.00, NOW(), 'TRUE'),
(3, 13, 3, 20.00, NOW(), 'TRUE'),
(4, 14, 2, 15.00, NOW(), 'TRUE'),
(5, 15, 4, 25.00, NOW(), 'TRUE'),
(6, 16, 3, 20.00, NOW(), 'TRUE'),
(7, 17, 2, 15.00, NOW(), 'TRUE'),
(8, 18, 4, 25.00, NOW(), 'TRUE'),
(9, 19, 3, 20.00, NOW(), 'TRUE'),
(10, 20, 2, 15.00, NOW(), 'FALSE'),
(1, 21, 4, 25.00, NOW(), 'TRUE'),
(2, 22, 3, 20.00, NOW(), 'TRUE'),
(3, 23, 2, 15.00, NOW(), 'TRUE'),
(4, 24, 4, 25.00, NOW(), 'TRUE'),
(5, 25, 3, 20.00, NOW(), 'TRUE'),
(6, 26, 2, 15.00, NOW(), 'TRUE'),
(7, 27, 4, 25.00, NOW(), 'TRUE'),
(8, 28, 3, 20.00, NOW(), 'TRUE'),
(9, 29, 2, 15.00, NOW(), 'TRUE'),
(10, 30, 4, 25.00, NOW(), 'TRUE'),
(1, 31, 3, 20.00, NOW(), 'TRUE'),
(2, 32, 2, 15.00, NOW(), 'TRUE'),
(3, 33, 4, 25.00, NOW(), 'TRUE'),
(4, 34, 3, 20.00, NOW(), 'TRUE'),
(5, 35, 2, 15.00, NOW(), 'TRUE'),
(6, 36, 4, 25.00, NOW(), 'TRUE'),
(7, 37, 3, 20.00, NOW(), 'TRUE'),
(8, 38, 2, 15.00, NOW(), 'TRUE'),
(9, 39, 4, 25.00, NOW(), 'TRUE'),
(10, 40, 3, 20.00, NOW(), 'TRUE'),
(1, 41, 2, 15.00, NOW(), 'TRUE'),
(2, 42, 4, 25.00, NOW(), 'TRUE'),
(3, 43, 3, 20.00, NOW(), 'TRUE'),
(4, 44, 2, 15.00, NOW(), 'TRUE'),
(5, 45, 4, 25.00, NOW(), 'FALSE'),
(6, 46, 3, 20.00, NOW(), 'TRUE'),
(7, 47, 2, 15.00, NOW(), 'TRUE'),
(8, 48, 4, 25.00, NOW(), 'TRUE'),
(9, 49, 3, 20.00, NOW(), 'FALSE'),
(10, 49, 2, 15.00, NOW(), 'TRUE'),
(1, 1, 3, 20.00, NOW(), 'TRUE'),
(2, 2, 2, 15.00, NOW(), 'TRUE'),
(3, 3, 4, 25.00, NOW(), 'TRUE'),
(4, 4, 3, 20.00, NOW(), 'TRUE'),
(5, 5, 2, 15.00, NOW(), 'TRUE'),
(6, 6, 4, 25.00, NOW(), 'TRUE'),
(7, 7, 3, 20.00, NOW(), 'TRUE'),
(8, 8, 2, 15.00, NOW(), 'TRUE'),
(9, 9, 4, 25.00, NOW(), 'TRUE'),
(10, 10, 3, 20.00, NOW(), 'TRUE'),
(1, 11, 2, 15.00, NOW(), 'TRUE'),
(2, 12, 4, 25.00, NOW(), 'TRUE'),
(3, 13, 3, 20.00, NOW(), 'TRUE'),
(4, 14, 2, 15.00, NOW(), 'TRUE'),
(5, 15, 4, 25.00, NOW(), 'TRUE'),
(6, 16, 3, 20.00, NOW(), 'TRUE'),
(7, 17, 2, 15.00, NOW(), 'TRUE'),
(8, 18, 4, 25.00, NOW(), 'TRUE'),
(9, 19, 3, 20.00, NOW(), 'TRUE'),
(10, 20, 2, 15.00, NOW(), 'TRUE'),
(1, 21, 4, 25.00, NOW(), 'TRUE'),
(2, 22, 3, 20.00, NOW(), 'TRUE'),
(3, 23, 2, 15.00, NOW(), 'TRUE'),
(4, 24, 4, 25.00, NOW(), 'TRUE'),
(5, 25, 3, 20.00, NOW(), 'TRUE'),
(6, 26, 2, 15.00, NOW(), 'TRUE'),
(7, 27, 4, 25.00, NOW(), 'TRUE'),
(8, 28, 3, 20.00, NOW(), 'TRUE'),
(9, 29, 2, 15.00, NOW(), 'TRUE'),
(10, 30, 4, 25.00, NOW(), 'TRUE'),
(1, 31, 3, 20.00, NOW(), 'TRUE'),
(2, 32, 2, 15.00, NOW(), 'TRUE'),
(3, 33, 4, 25.00, NOW(), 'TRUE'),
(4, 34, 3, 20.00, NOW(), 'TRUE'),
(5, 35, 2, 15.00, NOW(), 'TRUE'),
(6, 36, 4, 25.00, NOW(), 'TRUE'),
(7, 37, 3, 20.00, NOW(), 'TRUE'),
(8, 38, 2, 15.00, NOW(), 'TRUE'),
(9, 39, 4, 25.00, NOW(), 'TRUE'),
(10, 40, 3, 20.00, NOW(), 'TRUE'),
(1, 41, 2, 15.00, NOW(), 'TRUE'),
(2, 42, 4, 25.00, NOW(), 'TRUE'),
(3, 43, 3, 20.00, NOW(), 'TRUE'),
(4, 44, 2, 15.00, NOW(), 'TRUE'),
(5, 45, 4, 25.00, NOW(), 'TRUE'),
(6, 46, 3, 20.00, NOW(), 'TRUE'),
(7, 47, 2, 15.00, NOW(), 'TRUE'),
(8, 48, 4, 25.00, NOW(), 'TRUE'),
(9, 49, 3, 20.00, NOW(), 'TRUE'),
(10, 49, 2, 15.00, NOW(), 'TRUE'),
(1, 1, 3, 20.00, NOW(), 'TRUE'),
(2, 2, 2, 15.00, NOW(), 'TRUE'),
(3, 3, 4, 25.00, NOW(), 'TRUE'),
(4, 4, 3, 20.00, NOW(), 'TRUE'),
(5, 5, 2, 15.00, NOW(), 'TRUE'),
(6, 6, 4, 25.00, NOW(), 'TRUE'),
(7, 7, 3, 20.00, NOW(), 'TRUE'),
(8, 8, 2, 15.00, NOW(), 'TRUE'),
(9, 9, 4, 25.00, NOW(), 'TRUE'),
(10, 10, 3, 20.00, NOW(), 'TRUE'),
(1, 11, 2, 15.00, NOW(), 'TRUE'),
(2, 12, 4, 25.00, NOW(), 'TRUE'),
(3, 13, 3, 20.00, NOW(), 'TRUE'),
(4, 14, 2, 15.00, NOW(), 'TRUE'),
(5, 15, 4, 25.00, NOW(), 'TRUE'),
(6, 16, 3, 20.00, NOW(), 'TRUE'),
(7, 17, 2, 15.00, NOW(), 'TRUE'),
(8, 18, 4, 25.00, NOW(), 'TRUE'),
(9, 19, 3, 20.00, NOW(), 'TRUE'),
(10, 20, 2, 15.00, NOW(), 'TRUE'),
(1, 21, 4, 25.00, NOW(), 'TRUE'),
(2, 22, 3, 20.00, NOW(), 'TRUE'),
(3, 23, 2, 15.00, NOW(), 'TRUE'),
(4, 24, 4, 25.00, NOW(), 'TRUE'),
(5, 25, 3, 20.00, NOW(), 'TRUE'),
(6, 26, 2, 15.00, NOW(), 'TRUE'),
(7, 27, 4, 25.00, NOW(), 'TRUE'),
(8, 28, 3, 20.00, NOW(), 'FALSE'),
(9, 29, 2, 15.00, NOW(), 'FALSE'),
(10, 30, 4, 25.00, NOW(), 'FALSE'),
(1, 31, 3, 20.00, NOW(), 'FALSE'),
(2, 32, 2, 15.00, NOW(), 'FALSE'),
(3, 33, 4, 25.00, NOW(), 'FALSE'),
(4, 34, 3, 20.00, NOW(), 'FALSE'),
(5, 35, 2, 15.00, NOW(), 'FALSE'),
(6, 36, 4, 25.00, NOW(), 'TRUE'),
(7, 37, 3, 20.00, NOW(), 'TRUE'),
(8, 38, 2, 15.00, NOW(), 'TRUE'),
(9, 39, 4, 25.00, NOW(), 'TRUE'),
(10, 40, 3, 20.00, NOW(), 'TRUE'),
(1, 41, 2, 15.00, NOW(), 'TRUE'),
(2, 42, 4, 25.00, NOW(), 'TRUE'),
(3, 43, 3, 20.00, NOW(), 'TRUE'),
(4, 44, 2, 15.00, NOW(), 'TRUE'),
(5, 45, 4, 25.00, NOW(), 'TRUE'),
(6, 46, 3, 20.00, NOW(), 'TRUE'),
(7, 47, 2, 15.00, NOW(), 'TRUE'),
(8, 48, 4, 25.00, NOW(), 'TRUE'),
(9, 49, 3, 20.00, NOW(), 'TRUE'),
(10, 49, 2, 15.00, NOW(), 'TRUE');

-- Insertion de données dans la table Reservations
INSERT INTO Reservations (PassengerID, JourneyID, ReservationDate, ReservationStatus)
VALUES 
(2, 1, NOW(), 'Confirmed'),
(3, 2, NOW(), 'Pending'),
(4, 3, NOW(), 'Confirmed'),
(5, 4, NOW(), 'Cancelled'),
(1, 5, NOW(), 'Pending');

-- Insertion de données dans la table Ratings
INSERT INTO Ratings (RaterID, RatedID, Score, RatingDate, Comment)
VALUES 
(1, 2, 4, NOW(), 'Great passenger!'),
(2, 1, 5, NOW(), 'Excellent driver!'),
(3, 4, 3, NOW(), 'Average experience.'),
(4, 3, 5, NOW(), 'Very satisfied!'),
(5, 5, 2, NOW(), 'Disappointing journey.');

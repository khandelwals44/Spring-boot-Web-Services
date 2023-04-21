# Spring-boot-Web-Services
Shivam's First Project

# PROJECT OEVRVIEW
The Service is a simple patient encounter REST service which includes Patient’s id, name, age and his Protocol's name and details using many to one unidirectional mapping. This data can be fetched by an API call where all the CRUD operations can be performed by referring to the MySQL Database table for the required information.

# Relation

  ![](Image/Database%20ER%20Diagram.png)

# Development Environmennt
- Spring Boot 2.2.6.RELEASE
- Maven 4
- Eclipse IDE 2020-03
- Java 1.8
- JPA
- Hibernate

# Local Setup
1. Clone the repository
      
    ```
    git clone https://github.com/khandelwals44/Spring-boot-Web-Services.git
    ```
    
2. Create MySQL database

    ```
    CREATE DATABASE devcenter
    ```
  
    
3. Create table or Run the SQL script file

    ```
    CREATE TABLE `protocols` 
    (
        `protocol_id` int NOT NULL AUTO_INCREMENT,
        `protocol_name` varchar(255) NOT NULL,
        `protocol_details` varchar(255) NOT NULL,
        PRIMARY KEY (`protocol_id`)
    )
    
    CREATE TABLE `patient` 
    (
        `patient_id` int NOT NULL AUTO_INCREMENT,
        `patient_firstname` varchar(45) NOT NULL,
        `patient_lastname` varchar(45) NOT NULL,
        `patient_age` int NOT NULL,
        `protocol_id` int DEFAULT NULL,
        PRIMARY KEY (`patient_id`),
        KEY `protocol_id` (`protocol_id`),
        CONSTRAINT `protocol_id` FOREIGN KEY (`protocol_id`) REFERENCES `protocols` (`protocol_id`)
    )
    ```
    
4. Change MySQL Username and Password as per your MySQL Installation
  
    - open src/main/resources/application.properties file.
    - change spring.datasource.username and spring.datasource.password as per your installation
  
  
  
5. Install the POM dependecies
    ```
    mvn clean install
    ```
    The server will start on a random port.
    If your 8080 port is not in use, delete the following line in src/main/resources/application.properties file
     ```
     server.port=0
     ```
    this will start the derver on 8080 port
    
 # Explore REST APIs
 
  1. APIs for Patient's details
      ```
      GET /patient/

      POST /patient/AddPatient

      GET /patient/{patient_id}

      PUT /patient/update

      DELETE /patient/delete/{patient_id}
      ```
    
  2. APIs for Protocol's details
 
      ```
      GET /protocol/

      POST /protocol/AddPatient

      GET /protocol/{patient_id}

      PUT /protocol/update

      DELETE /protocol/delete/{patient_id}
      ```
      
     You can test them using postman or any other rest client.

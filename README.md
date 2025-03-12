**API Testing Automation for Cat Facts API - /breeds Endpoint**

**Description:**
- This project automates API tests for the "/breeds" endpoint of the public Cat Facts API (https://catfact.ninja/). 
The API's Swagger documentation, available at https://catfact.ninja/, was used to define the test scenarios. 
This project aims to validate the functionality and contract of the "/breeds" endpoint, covering both successful and error responses.

**Technologies Used:**
* Cucumber: For Behavior-Driven Development (BDD) and writing test scenarios in Gherkin.
* Java: The primary programming language used for test automation.
* Rest Assured: For making HTTP requests and validating API responses.
* JUnit: For running and managing test suites.

**Key Features:**
Automated testing of the "/breeds" API endpoint.
Validation of API responses against expected results.
Implementation of positive and negative test scenarios.
Clear and readable test scenarios using Gherkin syntax.
Validation of the API contract based on swagger documentation.

**Getting Started:**

Prerequisites:
* Java Development Kit (JDK) installed - https://openjdk.java.net
* Maven installed - https://maven.apache.org/download.cgi 
* Git installed - https://git-scm.com/downloads

**Clone the repository:**

- git clone https://github.com/maryelenw/cats-breeds-api-tests.git
- Navigate to the project directory:
  - cd [project directory]
  - Run the tests: mvn test

**Project Structure:**
- src/test/java/: Contains the Java test code and step definitions.
- src/test/resources/features/: Contains the Cucumber feature files written in Gherkin.
- pom.xml: Maven project configuration file with dependencies.

Dependencies:
* io.cucumber:cucumber-java
* io.cucumber:cucumber-junit
* io.rest-assured:rest-assured
* junit:junit
* com.fasterxml.jackson.core:jackson-databind

Further Information:
- API Documentation: https://catfact.ninja/
- Swagger: acess the main page of the api https://catfact.ninja/

Contributing:
Feel free to contribute to this project by submitting pull requests or opening issues for bug reports and feature requests.  

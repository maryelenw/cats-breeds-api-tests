# API Testing Automation for Cat Facts API - /breeds Endpoint

**Description:**

This project automates API tests for the "/breeds" endpoint of the public Cat Facts API (https://catfact.ninja/). The API's Swagger documentation, available at https://catfact.ninja/, was used to define the test scenarios. This project aims to validate the functionality and contract of the "/breeds" endpoint, covering both successful and error responses.

**Technologies Used:**

* **Cucumber:** For Behavior-Driven Development (BDD) and writing test scenarios in Gherkin.
* **Java:** The primary programming language used for test automation.
* **Rest Assured:** For making HTTP requests and validating API responses.
* **JUnit:** For running and managing test suites.
* **Maven Surefire Plugin:** Used to generate clear and detailed test reports.
* **GitHub Actions:** Used to run the test pipeline.

**Key Features:**

* Automated testing of the "/breeds" API endpoint.
* Validation of API responses against expected results.
* Implementation of positive and negative test scenarios.
* Clear and readable test scenarios using Gherkin syntax.
* Validation of the API contract based on Swagger documentation.
* Integration of tests into a CI/CD pipeline using GitHub Actions.
* Detailed test results provided by the Maven Surefire Plugin.

**Getting Started:**

**Prerequisites:**

* Java Development Kit (JDK) installed - https://adoptium.net/ (Eclipse Temurin, recommended)
* Maven installed - https://maven.apache.org/download.cgi
* Git installed - https://git-scm.com/downloads

**Clone the repository:**
- git clone https://github.com/maryelenw/cats-breeds-api-tests.git

- Navigate to the project directory:
  - cd cats-breeds-api-tests
  - Run the tests: mvn test

**Project Structure:**
- src/test/java/: Contains the Java test code and step definitions.
- src/test/resources/features/: Contains the Cucumber feature files written in Gherkin.
- pom.xml: Maven project configuration file with dependencies.
- .github/workflows/api-tests.yml: GitHub Actions workflow file for CI/CD.

Dependencies:
* io.cucumber:cucumber-java
* io.cucumber:cucumber-junit
* io.rest-assured:rest-assured
* junit:junit
* com.fasterxml.jackson.core:jackson-databind

Further Information:
- API Documentation: https://catfact.ninja/
- Swagger: acess the main page of the api https://catfact.ninja/

CI/CD:
- This project uses GitHub Actions for continuous integration. The test pipeline is defined in .github/workflows/api-tests.yml.
- The Maven Surefire Reports is used to generate detailed and clear test reports, which are published within the GitHub Actions workflow.

Contributing:
Feel free to contribute to this project by submitting pull requests or opening issues for bug reports and feature requests.  

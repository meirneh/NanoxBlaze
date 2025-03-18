# NanoxBlaze - Test Automation Project

## Project Overview
This project is an automated test framework for the **Demo Blaze** application, developed as part of the QA Automation Engineer home assignment. The framework is built using **Selenium WebDriver, TestNG, and Java**, following best practices for test automation.

## Technologies Used
- **Java** (JDK 11)
- **Selenium WebDriver** (v4.23.1)
- **TestNG** (v7.10.2)
- **Apache Maven** (Dependency management)
- **JavaFaker** (Test data generation)
- **Apache POI** (Excel file handling)

## Project Structure
```
NanoxBlaze/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── nanoxBlazePageObjects/
│   │   │   │   ├── BasePage.java
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── CartPage.java
│   │   │   │   ├── PlaceOrderPage.java
│   │   │   │   ├── ProductPage.java
│   │   │   ├── nanoxBlazeUtils/
│   │   │   │   ├── ConfigReader.java
│   │   ├── resources/
│   │   │   ├── config/
│   │   │   │   ├── config.properties
│   ├── test/
│   │   ├── java/
│   │   │   ├── nanoxBlazeTests/
│   │   │   │   ├── BaseTest.java
│   │   │   │   ├── e2eTests.java
│   │   │   │   ├── LoginRegistrationTests.java
│── pom.xml
│── testng.xml
```

## Installation & Setup
### Prerequisites
Ensure the following software is installed:
1. **Java JDK 11** or later
2. **Apache Maven** (Ensure `mvn` is available in the system path)
3. **Google Chrome** and **ChromeDriver** (Ensure the driver version matches your Chrome browser)

### Clone the Repository
```sh
git clone <repository_url>
cd NanoxBlaze
```

### Install Dependencies
```sh
mvn clean install
```

## Running the Tests
### Execute All Tests
```sh
mvn test
```

### Run Specific Test Suite
```sh
mvn test -DsuiteXmlFile=testng.xml
```

## Test Scenarios Implemented
The framework includes the following automated test cases:
1. **Login and Registration Tests**
   - Verify successful login
   - Validate logout functionality
   - Verify error message for incorrect credentials
2. **E2E Tests**
   - Validate complete purchase flow
   - Add and remove items from the cart

## Configuration & Test Data
- **`config.properties`** (located in `src/main/resources/config/`) contains:
  - Application URL
  - Test user credentials
  - Product names used in tests
  - Order details (name, country, city, card information)
- **`ConfigReader.java`** reads values from `config.properties` and provides them dynamically to the tests.

## Reporting & Logs
- **TestNG Reports**: HTML reports are stored under `target/surefire-reports`.

## Bug Reports & Suggestions
- Any identified bugs are documented separately.
- A report with suggestions for application improvements is included in the submission.

## Future Enhancements
- Expand test coverage with additional edge cases.
- Integrate CI/CD pipelines for automated execution.
- Implement parallel execution for faster test runs.

## Contact
For any questions regarding the setup or execution, feel free to reach out.

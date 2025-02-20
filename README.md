# API Test Automation Project

This project utilizes Java and various tools to automate API testing. Below is a brief overview of the tools and structure used.

## Table of Contents
- [Introduction](#introduction)
- [Rest Assured](#rest-assured)
- [Test Logging](#test-logging)
- [Test Reporting](#test-reporting)
- [Cucumber and Gherkin](#cucumber-and-gherkin)

## Introduction
This project uses Java and various tools to automate and report API tests. The tests are configured using tools such as Rest Assured, Log4j, Allure, Jenkins, and Cucumber.

## Rest Assured
- **What is Rest Assured?**: Rest Assured is a Java library used for testing RESTful web services.
- **Automating Tests**: Rest Assured allows for writing and automating API tests. Tests can perform HTTP requests and validate responses.
- **The project performs test operations globally by retrieving necessary test information.**

## Test Logging
- **Log4j**: Log4j is used to obtain detailed logs of the tests. It facilitates monitoring every stage of the tests and diagnosing issues.
- **Logs are configured to be separated by day. Log files older than 30 days are automatically deleted.**
- **Logs could be accessed in logs directory. Also configuration file is in resources directory.**

## Test Reporting
- **Allure**: Allure is used to present test reports visually.
    - **Pre-operations should be done for using allure. Visit this website to get more detailed information ->  [Allure Website](https://allurereport.org/docs/install/)**
    - **Generating Reports**: Use the following command to convert test results into Allure reports:
      ```bash
      allure generate target/allure-results --clean -o target/allure-report
      ```
    - **Allure property file could be accessed in resources.**

## Cucumber and Gherkin
- **Cucumber and Gherkin**: Cucumber and Gherkin are used to make test scenarios more readable and understandable.
    - **Configuration**: Test scenarios written in Gherkin language are processed by Cucumber and integrated with Rest Assured.

## Fake Data Generation with Faker
- **To generate fake register data, fake-register-data-generator.py could be used.**
- **Also a new python file could be developed with same way with fake-register-data-generator.py according to the needs.**
    - **Usage of the file at main path:**
  ```bash 
  python fake-register-data-generator.py <Number of record that will be generated> --null_probability <range is 0-1> --output <destination file with path>
  ```
    - **ExampleUsage of the file at main path:**
  ```bash
  python fake-register-data-generator.py 20 --null_probability 0.1
  ```

## Setup and Running
1. **Install Required Dependencies**: Check the `pom.xml` file in the root directory of the project and install the necessary dependencies. Be careful with the library versions.
2. **Configure system variables.**
2. **Run Tests**: Use Maven commands to run the tests.
3. **Generate Reports**: Use Allure commands to generate test reports.
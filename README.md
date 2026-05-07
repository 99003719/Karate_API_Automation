# Home Test API - Karate

This project contains API tests for the **Inventory API** using the **Karate (BDD) testing framework** with Maven.

## Prerequisites
Before running the tests, ensure you have the following installed:
1.Java JDK 11+
2.Docker
3.Git (to clone/push the project)  

## Setup API

1. Pull the API Docker image:
docker pull automaticbytes/demo-app

2. Run the Docker container:
docker run -p 3100:3100 automaticbytes/demo-app

3.Verify the API is running:
http://localhost:3100/api

The base URL for tests is:
http://localhost:3100/api

## Project Structure

```
Test_API_KARATE/
├── pom.xml
├── src
│   └── test
│       └── java
│           └── Tests
│               ├── data
│               │   ├── add_existing_item_payload.json
│               │   ├── add_item_payload.json
│               │   ├── expected_response.json
│               │   └── incomplete_payload.json
│               ├── users
│               │   ├── Add_item_existing_id.feature
│               │   ├── Add_item_non_existing_id.feature
│               │   ├── Add_item_with_missing_info.feature
│               │   ├── Filter_by_id.feature
│               │   ├── Get_all_menu_items.feature
│               │   ├── Validate_recent_added_item_is_present_in_the_inventory.feature
│               │   └── TestRunner
│               └── karate-config.js
├── target
└── README.md
```
                              
                               
## Folder Explanation

karate-config.js – Global configuration (base URL, environment settings) 

TestRunner.java – JUnit runner to execute feature files

.feature files – Gherkin scenarios describing API behavior
                              
## Build and run tests

Run using Test Runner (JUnit)

1.Clone the project from remote repository to local folder and open the project in IntelliJ, Eclipse, or VS Code.

2.Open TestRunner.java

3.Right-click → Run TestRunner

This will execute all feature files defined in the runner.

Run using Maven
1. mvn test (Run the feature files)
2. mvn test -Dkarate.options="classpath:Tests/users" (Run tests from a specific folder)
   
## Test Reports

After execution, Karate generates HTML reports automatically in the path:
"target/karate-reports/karate-summary.html"
Open this file in a browser to view execution results.

## Test Scenarios Covered

1.Get all menu items – Validate at least 9 items with fields id, name, price, image.

2.Filter by id – Filters the inventory with respect to ID and validate correct item data.

3.Add item for non-existent id – POST new item and expect status 200.

4.Add item for existing id – POST duplicate item and expect status 400.

5.Add item with missing information – POST incomplete JSON and expect status 400 with message "Not all requirements are met".

6.Validate recent added item is present – GET /inventory and verify the added item exists.





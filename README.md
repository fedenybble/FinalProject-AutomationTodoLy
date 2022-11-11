# FinalProject-AutomationTodoLy

This project was created to automate 25 test cases of todo.ly application.

Tools that has been used:
- IntelliJ + Gradle.
- Allure for Reports.
- SpotBugs.
- Docker.
- Github.
- JIRA.

Commands:

- gradle clean test -PenvFile=qa.properties (this will run all the tests)
- gradle clean -x test -PenvFile=qa.properties tags -PtestSuite=nameOfTheTestSuite
- allure serve ./build/allure-results/
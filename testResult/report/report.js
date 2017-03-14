$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("01_Login.feature");
formatter.feature({
  "line": 1,
  "name": "Login Verification",
  "description": "",
  "id": "login-verification",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Verification of Login",
  "description": "",
  "id": "login-verification;verification-of-login",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Smoke"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I am on the login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I enter username and password",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I should see the username",
  "keyword": "Then "
});
formatter.match({
  "location": "loginSteps.iAmOnTheLoginPage()"
});
formatter.result({
  "duration": 107171185,
  "status": "passed"
});
formatter.match({
  "location": "loginSteps.iEnterUsernameAndPassword()"
});
formatter.result({
  "duration": 107520,
  "status": "passed"
});
formatter.match({
  "location": "loginSteps.iShouldSeeTheUsername()"
});
formatter.result({
  "duration": 88747,
  "status": "passed"
});
});
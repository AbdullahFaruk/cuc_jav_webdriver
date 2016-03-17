$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/newUsers.feature");
formatter.feature({
  "line": 2,
  "name": "As a user",
  "description": "       I want to be able to add new clients in the system\r\n       So that I can add accounting data for that client",
  "id": "as-a-user",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@newuser"
    }
  ]
});
formatter.before({
  "duration": 8452933987,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Sign up a new user",
  "description": "",
  "id": "as-a-user;sign-up-a-new-user",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "the user is on landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "she chooses to sign up",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "she provides the first name as \"Sukesh\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "she provides the last name as \"Kumar\"",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "she provides the email as \"validemail@March160863.com\"",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "she provides the password as \"password\"",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "she provides the confirm password again as \"password\"",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "she signs-up",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "she should be logged in to the application",
  "keyword": "Then "
});
formatter.match({
  "location": "StartingSteps.the_user_is_on_landing_page()"
});
formatter.result({
  "duration": 742476981,
  "status": "passed"
});
formatter.match({
  "location": "LandingPageSteps.she_chooses_to_sign_up()"
});
formatter.result({
  "duration": 556616030,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sukesh",
      "offset": 32
    }
  ],
  "location": "SignUpPageSteps.she_provides_the_first_name_as(String)"
});
formatter.result({
  "duration": 91931646,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Kumar",
      "offset": 31
    }
  ],
  "location": "SignUpPageSteps.she_provides_the_last_name_as(String)"
});
formatter.result({
  "duration": 98363710,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "validemail@March160863.com",
      "offset": 27
    }
  ],
  "location": "SignUpPageSteps.she_provides_the_email_as(String)"
});
formatter.result({
  "duration": 956662156,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "password",
      "offset": 30
    }
  ],
  "location": "SignUpPageSteps.she_provides_the_password_as_password(String)"
});
formatter.result({
  "duration": 125906599,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "password",
      "offset": 44
    }
  ],
  "location": "SignUpPageSteps.she_provides_the_confirm_password_again_as_password(String)"
});
formatter.result({
  "duration": 115888765,
  "status": "passed"
});
formatter.match({
  "location": "SignUpPageSteps.she_signs_up()"
});
formatter.result({
  "duration": 1607411851,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.she_should_be_logged_in_to_the_application()"
});
formatter.result({
  "duration": 39364689,
  "status": "passed"
});
formatter.after({
  "duration": 715218884,
  "status": "passed"
});
});
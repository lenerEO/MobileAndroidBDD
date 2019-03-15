Feature: Calculator

  Scenario: Perform an Addition
    Given user has two number: "5" and "2"
    When user performs an the operation: "addition"
    Then the result should be "7"

  Scenario: Perform an Multiplication
    Given user has two number: "6" and "3"
    When user performs an the operation: "multiplication"
    Then the result should be "18"

  Scenario: Perform an Subtraction
    Given user has two number: "9" and "3"
    When user performs an the operation: "subtraction"
    Then the result should be "6"

  Scenario: Perform an Division
    Given user has two number: "8" and "2"
    When user performs an the operation: "division"
    Then the result should be "4"
Feature: Calculator

  Scenario Outline: Perform some operations
    Given user has two number: "<operando1>" and "<operando2>"
    When user performs an the operation: "<operador>"
    Then the result should be "<resultado>"
    Examples: List of examples
      | operando1 | operando2 | operador       | resultado |
      | 5         | 2         | addition       | 7         |
      | 6         | 3         | multiplication | 18        |
      | 9         | 3         | subtraction    | 6         |
      | 8         | 2         | division       | 4         |
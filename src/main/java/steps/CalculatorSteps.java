package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.AndroidDriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import objects.CalculatorObject;
import org.testng.Assert;

public class CalculatorSteps {

    private AndroidDriver<AndroidElement> driver;
    private String operando1, operando2;
    private CalculatorObject calculadora;

    @Before
    public void setUp() {
        driver = AndroidDriverManager.getDriver();
    }

    @Given("^user has two number: \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userHasTwoNumberAnd(String numero1, String numero2) {
        operando1 = numero1;
        operando2 = numero2;
    }

    @When("^user performs an the operation: \"([^\"]*)\"$")
    public void userPerformsAnTheOperation(String operador) {
        calculadora = new CalculatorObject(driver);
        calculadora.touchDigit(operando1);
        calculadora.touchOperation(operador);
        calculadora.touchDigit(operando2);
        calculadora.touchIgual();
    }

    @Then("^the result should be \"([^\"]*)\"$")
    public void theResultShouldBe(String arg0) {
        Assert.assertEquals(calculadora.getResultado(), String.valueOf(arg0));
    }

    @After
    public void tearDown() {
        driver = null;
    }
}
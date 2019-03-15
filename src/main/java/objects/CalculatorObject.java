package objects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorObject {

    private AndroidDriver<AndroidElement> driver;
    private WebDriverWait wait;

    //Constructor

    public CalculatorObject(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
        wait = new WebDriverWait(this.driver, 20);
    }

    //Locators

    @AndroidFindBy(id="formula")
    private AndroidElement txtFormula;

    @AndroidFindBy(id="result")
    private AndroidElement lblResultado;

    @AndroidFindBy(id="dec_point")
    private AndroidElement btnPunto;

    @AndroidFindBy(id="eq")
    private AndroidElement btnIgual;

    @AndroidFindBy(id="op_add")
    private AndroidElement btnMas;

    @AndroidFindBy(id="op_sub")
    private AndroidElement btnMenos;

    @AndroidFindBy(id="op_mul")
    private AndroidElement btnPor;

    @AndroidFindBy(id="op_div")
    private AndroidElement btnEntre;

    @AndroidFindBy(id="del")
    private AndroidElement btnBorrar;

    @AndroidFindBy(id="clr")
    private AndroidElement btnLimpiar;

    //Actions

    public void writeFormula(String texto) {
        wait.until(ExpectedConditions.visibilityOf(txtFormula)).sendKeys(texto);
    }

    public String getResultado() {
        return wait.until(ExpectedConditions.visibilityOf(lblResultado)).getText();
    }

    public void touchPunto() {
        wait.until(ExpectedConditions.visibilityOf(btnPunto)).click();
    }

    public void touchIgual() {
        wait.until(ExpectedConditions.visibilityOf(btnIgual)).click();
    }

    public void touchMas() {
        wait.until(ExpectedConditions.visibilityOf(btnMas)).click();
    }

    public void touchMenos() {
        wait.until(ExpectedConditions.visibilityOf(btnMenos)).click();
    }

    public void touchPor() {
        wait.until(ExpectedConditions.visibilityOf(btnPor)).click();
    }

    public void touchEntre() {
        wait.until(ExpectedConditions.visibilityOf(btnEntre)).click();
    }

    public void touchBorrar() {
        wait.until(ExpectedConditions.visibilityOf(btnBorrar)).click();
    }

    public void touchLimpiar() {
        wait.until(ExpectedConditions.visibilityOf(btnLimpiar)).click();
    }

    public void touchDigit(String digit) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("digit_" + digit))).click();
    }

    public void touchOperation(String operation) {
        switch(operation) {
            case "addition":
                wait.until(ExpectedConditions.visibilityOf(btnMas)).click();
                break;
            case "multiplication":
                wait.until(ExpectedConditions.visibilityOf(btnPor)).click();
                break;
            case "subtraction":
                wait.until(ExpectedConditions.visibilityOf(btnMenos)).click();
                break;
            case "division":
                wait.until(ExpectedConditions.visibilityOf(btnEntre)).click();
                break;
        }
    }
}
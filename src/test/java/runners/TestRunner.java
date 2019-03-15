package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import driver.AndroidDriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.URL;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        tags = {"~@Ignore"},
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })
public class TestRunner {
    private TestNGCucumberRunner testNGCucumberRunner;
    private AndroidDriver<AndroidElement> driver;

    @Parameters({"deviceName", "version", "platformName", "automationName", "appPackage", "appActivity", "url"})
    @BeforeClass(alwaysRun = true)
    public void setUpClass(String deviceName, String version, String platformName, String automationName, String appPackage, String appActivity, String url) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability(CapabilityType.VERSION, version);
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("automationName", automationName);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        driver = new AndroidDriver<>(new URL(url),	capabilities);
        AndroidDriverManager.setDriver(driver);
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        driver.quit();
        testNGCucumberRunner.finish();
    }
}
package Login;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginSteps {

    private WebDriver driver;

    private String baseURL = "https://thetracktor.com/account/login/";
    private String loggedInURL = "https://thetracktor.com/account/profile/";

    @Before public void setUp(){
        DOMConfigurator.configure("log4j.xml");
        MyLog.info("Opening browser");
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    @After public void tearDown(){
        MyLog.info("Exiting browser");
        driver.close();
    }

    // Successful login

    @Given("^user is on the login page$")
    public void userIsOnTheLoginPage() throws Throwable {
        MyLog.info("Navigating to login page");
        driver.navigate().to(baseURL);

    }

    @When("^entering the correct username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void enteringTheCorrectUsernameAndPassword(String arg0, String arg1) throws Throwable {
        MyLog.info("Entering correct username");
        driver.findElement(By.id("id_username")).sendKeys(arg0);
        MyLog.info("Entering correct password");
        driver.findElement(By.id("id_password")).sendKeys(arg1);
        MyLog.info("Clicking on login button");
        driver.findElement(By.id("submit-id-submit")).click();
    }

    @Then("^the user is able to login$")
    public void theUserIsAbleToLogin() throws Throwable {
        if (driver.getCurrentUrl().equalsIgnoreCase(loggedInURL)){
            assert true;
            MyLog.info("User has logged in");
        } else {
            assert false;
        }
    }

    // Unsuccessful login

    @When("^entering the wrong credentials for username \"([^\"]*)\" or password \"([^\"]*)\"$")
    public void enteringTheWrongCredentialsForOr(String arg0, String arg1) throws Throwable {
        MyLog.info("Entering wrong username/password combination");
        driver.findElement(By.id("id_username")).sendKeys(arg0);
        driver.findElement(By.id("id_password")).sendKeys(arg1);
        driver.findElement(By.id("submit-id-submit")).click();
    }

    @Then("^the user is not able to login$")
    public void theUserIsNotAbleToLogin() throws Throwable {
        if (driver.getCurrentUrl().equalsIgnoreCase(loggedInURL)){
            MyLog.info("User cannot log in with wrong credentials");
            assert false;
        } else {
            assert true;
        }
    }
}

package com.lukegjpotter.hellocucumber.selenium;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Optional;

public class SeleniumGoogleSearch {

    private WebDriver driver = null;

    @Before
    public void configureSelenium() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
    }

    @Given("I am on the Google search page")
    public void iAmOnTheGoogleSearchPage() {
        driver.get("https://www.google.ie/");
        // Reject Cookies
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/span/div/div/div/div[3]/div[1]/button[1]")).click();
    }

    @When("I search for {string}")
    public void iSearchFor(String query) {
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys(query);
        searchbox.submit();
    }

    @Then("the page title should start with {string}")
    public void thePageTitleShouldStartWith(String titleStartsWith) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(
                (ExpectedCondition<Boolean>) waitWebDriver -> Optional.of(waitWebDriver.getTitle()).orElse("")
                        .toLowerCase()
                        .startsWith(titleStartsWith));
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}

package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.SearchPage;
import pages.SearchResultPage;

import java.time.Duration;

public class SearchSteps {
    private WebDriver driver;
    private SearchPage searchPage;
    private SearchResultPage searchResultPage;

    @Before
    public void initialize() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        this.searchPage = new SearchPage(driver);
        this.searchResultPage = new SearchResultPage(driver);

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Given("I am on yandex.by page")
    public void iAmOnYandexByPage() {
        searchPage.open();
    }

    @When("^I type (.*) into search input$")
    public void iTypeIntoSearchInput(String value) {
        searchPage.setSearchInputValue(value);

    }

    @And("Press Enter")
    public void pressEnter() {
        searchPage.pressEnter();
    }

    @Then("^there are (.*) search results present$")
    public void thereAreSearchResultsPresent(int arg0) {
        Assert.assertEquals(searchResultPage.getSearchResultsCount(), arg0);
    }

    @And("^first search result contains (.*) in title$")
    public void firstSearchResultContainsInTitle(String arg0) {
        Assert.assertTrue(this.searchResultPage.getSearchResultTitleByIndex(0).toLowerCase().contains(arg0.toLowerCase()));
    }
}

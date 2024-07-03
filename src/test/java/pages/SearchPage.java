package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SearchPage extends BasePage {
    private final static By SEARCH_INPUT_LOCATOR = By.cssSelector("#catalogSearch");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void setSearchInputValue(String value) {
        driver.findElement(SEARCH_INPUT_LOCATOR).sendKeys(value);
    }

    public void pressEnter() {
        new Actions(driver).sendKeys(Keys.ENTER).perform();
    }

    public void open() {
        driver.get("https://www.21vek.by");
    }
}

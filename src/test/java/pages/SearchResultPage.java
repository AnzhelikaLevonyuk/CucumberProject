package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {
    private final static By RESULTS_LOCATOR = By.cssSelector("li[class$='g-box_lseparator']");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchResultTitleByIndex(int index) {
        return driver.findElements(RESULTS_LOCATOR).get(index).findElement(By.cssSelector("span[class = 'result__name']")).getText();

    }

    public int getSearchResultsCount() {
        return driver.findElements(RESULTS_LOCATOR).size();
    }
}

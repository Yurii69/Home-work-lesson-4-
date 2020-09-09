import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class MinnesotaDNR {

    WebDriver driver;



    @BeforeSuite
    private void setup (){


        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();

    }





// 1. Go to https://www.dnr.state.mn.us
//2. Type the search request
//3. Submit the request
//4. Verify that results page is displayed

    @Test
    public void test001() {
        String SearchRequest = "Sturgeon fishing regulations";

        openMainPage();
        typeSearchRequest(SearchRequest);
        submitSearchRequest();
        waitForResults();
        verifyResultsPage();

    }

    private void waitForResults() {

        By elementToWait = By.id("search-total");
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(elementToWait);
        new WebDriverWait(driver, 10).until(condition);
    }

    private void verifyResultsPage() {

        String searchTotalId = "search-total";
        WebElement element = driver.findElement(By.id(searchTotalId));
        boolean isResultDisplayed = element.isDisplayed();
        Assert.assertTrue(isResultDisplayed);


    }

    private void submitSearchRequest() {
        String selector = "#search_input";
        WebElement element = driver.findElement(By.cssSelector(selector));
        element.submit();

    }

    private void typeSearchRequest(String searchRequest) {
        String selector = "#search_input";
        WebElement element = driver.findElement(By.cssSelector(selector));
        element.sendKeys(searchRequest);
    }


    private void openMainPage() {
        driver.get("https://www.dnr.state.mn.us");
        
    }


}

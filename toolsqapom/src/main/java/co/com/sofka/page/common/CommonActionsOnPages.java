package co.com.sofka.page.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class CommonActionsOnPages extends BaseSikulix{
    private static final Logger LOGGER = Logger.getLogger(CommonActionsOnPages.class);
    private static final String WEBDRIVER_NULL_MESSAGE = "\nWARNING!\n\rThe Webdriver is null, please check it.\n";
    private WebDriver driver;

    //Explicit wait.
    private WebDriverWait webDriverExplicitWait;

    //Constructor
    public CommonActionsOnPages(WebDriver driver) {
        super();
        try {

            if(driver == null)
                LOGGER.warn(WEBDRIVER_NULL_MESSAGE);

            this.driver = driver;
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    public CommonActionsOnPages(WebDriver driver, int seconds) {
        super();
        try {

            if(driver == null)
                LOGGER.warn(WEBDRIVER_NULL_MESSAGE);

            this.driver = driver;

            webDriverExplicitWaitConfiguration(this.driver, seconds);

        } catch (Exception e){
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Configure the explicit wait.
    private void webDriverExplicitWaitConfiguration(WebDriver driver, int seconds){
        try{
            webDriverExplicitWait = new WebDriverWait(driver, seconds);
        } catch (Exception e){
            LOGGER.warn(e.getMessage(), e);
        }

    }

    //Configure the implicit wait.
    private void webDriverImplicitwait(WebDriver driver, int seconds){
        try{
            this.driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        } catch (Exception e){
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Functions
    public void doSubmit(By webElement) throws IOException {
        driver.findElement(webElement).submit();
    }

    public void doSubmit(WebElement webElement){
        webElement.submit();
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement webElement){
        return webElement.getText();
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void typeInto(By locator, CharSequence... keysToSend) throws IOException {
        driver.findElement(locator).sendKeys(keysToSend);
    }

    public void typeInto(WebElement webElement, CharSequence... keysToSend){
        webElement.sendKeys(keysToSend);
    }

    public void withExplicitWaitTypeInto(By locator, CharSequence... keysToSend){
        webDriverExplicitWait.until(presenceOfElementLocated(locator)).sendKeys(keysToSend);
    }

    public void withExplicitWaitTypeInto(WebElement webElement, CharSequence... keysToSend){
        webDriverExplicitWait.until(elementToBeClickable(webElement)).sendKeys(keysToSend);
    }

    public void clear(By webElement){
        driver.findElement(webElement).clear();
    }

    public void clear(WebElement webElement){
        webElement.clear();
    }

    public void clear(By locator, CharSequence... keysToSend){
        webDriverExplicitWait.until(presenceOfElementLocated(locator)).sendKeys(keysToSend);
    }

    public void clear(WebElement webElement, CharSequence... keysToSend){
        webDriverExplicitWait.until(elementToBeClickable(webElement)).sendKeys(keysToSend);
    }

    public void withExplicitWaitClear(By locator){
        webDriverExplicitWait.until(presenceOfElementLocated(locator)).clear();
    }

    public void withExplicitWaitClear(WebElement webElement){
        webDriverExplicitWait.until(elementToBeClickable(webElement)).clear();
    }

    public void scrollTo(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    public void scrollTo(WebElement webElement){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void clickOn(By locator){
        driver.findElement(locator).click();
    }

    public void clickOn(WebElement webElement){
        webElement.click();
    }

    public void withExplicitWaitClickOn(By locator){
        webDriverExplicitWait.until(presenceOfElementLocated(locator)).click();
    }

    public boolean isDisplayed(By locator) throws NoSuchElementException {
        return driver.findElement(locator).isDisplayed();
    }

    public boolean isDisplayed(WebElement webElement) throws NoSuchElementException {
        return webElement.isDisplayed();
    }

    public List<WebElement> javascriptExecutorWithReturnCollection(String script){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        return (List<WebElement>)jse.executeScript(script);
    }

    public WebElement javascriptExecutorWithReturn(String script){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        return (WebElement)jse.executeScript(script);
    }

    public void javascriptExecutor(String script){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript(script);
    }
}

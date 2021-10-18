package co.com.sofka.page.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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

    //Init POM with Page Factory.
    protected void  pageFactoryInitElement(WebDriver driver, Object page){
        PageFactory.initElements(driver, page);
    }

    //Functions
    protected void doSubmit(By webElement) throws IOException {
        driver.findElement(webElement).submit();
    }

    protected void doSubmit(WebElement webElement){
        webElement.submit();
    }

    protected WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    protected List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    protected String getText(WebElement webElement){
        return webElement.getText();
    }

    protected String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void typeInto(By locator, CharSequence... keysToSend) throws IOException {
        driver.findElement(locator).sendKeys(keysToSend);
    }

    protected void typeInto(WebElement webElement, CharSequence... keysToSend){
        webElement.sendKeys(keysToSend);
    }

    public void select(WebElement locator,String index) throws IOException {

        Select select = new Select(locator);
        select.selectByVisibleText(index);

    }

    protected void withExplicitWaitTypeInto(By locator, CharSequence... keysToSend){
        webDriverExplicitWait.until(presenceOfElementLocated(locator)).sendKeys(keysToSend);
    }

    protected void withExplicitWaitTypeInto(WebElement webElement, CharSequence... keysToSend){
        webDriverExplicitWait.until(elementToBeClickable(webElement)).sendKeys(keysToSend);
    }

    protected void clear(By webElement){
        driver.findElement(webElement).clear();
    }

    protected void clear(WebElement webElement){
        webElement.clear();
    }

    protected void clear(By locator, CharSequence... keysToSend){
        webDriverExplicitWait.until(presenceOfElementLocated(locator)).sendKeys(keysToSend);
    }

    protected void clear(WebElement webElement, CharSequence... keysToSend){
        webDriverExplicitWait.until(elementToBeClickable(webElement)).sendKeys(keysToSend);
    }

    protected void withExplicitWaitClear(By locator){
        webDriverExplicitWait.until(presenceOfElementLocated(locator)).clear();
    }

    protected void withExplicitWaitClear(WebElement webElement){
        webDriverExplicitWait.until(elementToBeClickable(webElement)).clear();
    }

    protected void scrollTo(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    protected void scrollTo(WebElement webElement){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void clickOn(By locator){
        driver.findElement(locator).click();
    }

    public void clickOn(WebElement webElement){
        webElement.click();
    }

    protected void withExplicitWaitClickOn(By locator){
        webDriverExplicitWait.until(presenceOfElementLocated(locator)).click();
    }

    protected boolean isDisplayed(By locator) throws NoSuchElementException {
        return driver.findElement(locator).isDisplayed();
    }

    protected boolean isDisplayed(WebElement webElement) throws NoSuchElementException {
        return webElement.isDisplayed();
    }

    protected List<WebElement> javascriptExecutorWithReturnCollection(String script){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        return (List<WebElement>)jse.executeScript(script);
    }

    protected WebElement javascriptExecutorWithReturn(String script){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        return (WebElement)jse.executeScript(script);
    }

    protected void javascriptExecutor(String script){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript(script);
    }

    protected void javascriptExecutor(String script,WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript(script,element);
    }
    public void javascriptExecutor(String script,By localisador){
        WebElement element = driver.findElement(localisador);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript(script,element);
    }

}

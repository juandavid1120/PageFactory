package co.com.sofka.page.practiceform;

import co.com.sofka.model.practiceform.PracticeFormModel;
import co.com.sofka.page.common.CommonActionsOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class PracticeForm extends CommonActionsOnPages {

    private static final Logger LOGGER = Logger.getLogger(PracticeForm.class);
    private PracticeFormModel practiceFormModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";
    WebDriver driver;

    //For input test cases.
    @FindBy(id = "addCandidate_firstName")
    @CacheLookup
    private WebElement firsName;

    @FindBy(id = "addCandidate_middleName")
    @CacheLookup
    private WebElement middleName;

    @FindBy(id = "addCandidate_lastName")
    @CacheLookup
    private WebElement lastName;

    @FindBy(id = "addCandidate_email")
    @CacheLookup
    private WebElement candidateEmail;

    /*@FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")
    @CacheLookup
    private WebElement genderMale;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[2]/label")
    @CacheLookup
    private WebElement genderFemale;

    @FindBy(xpath = "//*[@id=\"genterWrapper\"]/div[2]/div[3]/label")
    @CacheLookup
    private WebElement genderOther;*/

    @FindBy(id = "addCandidate_contactNo")
    @CacheLookup
    private WebElement contactNo;

    @FindBy(id = "addCandidate_vacancy")
    @CacheLookup
    private WebElement jobVacancy;

    @FindBy(xpath = "//*[@id=\"frmAddCandidate\"]/fieldset/ol[2]/li[2]/label[1]")
    @CacheLookup
    private WebElement resumeCandidate;

    @FindBy(id = "addCandidate_keyWords")
    @CacheLookup
    private WebElement keyWords;

    @FindBy(id = "addCandidate_comment")
    @CacheLookup
    private WebElement commentCandidate;

    @FindBy(id = "addCandidate_appliedDate")
    @CacheLookup
    private WebElement dateAplication;

    @FindBy(id = "addCandidate_consentToKeepData")
    @CacheLookup
    private WebElement consentToKeepData;


    @FindBy(id = "btnSave")
    @CacheLookup
    private WebElement btnSave;
    @FindBy(id = "btnBack")
    @CacheLookup
    private WebElement btnBack;

    //For Assertions test case.
    @FindBy(id = "candidateSearch_candidateName")
    @CacheLookup
    private WebElement assertionUserName ;


    //Sikulix elements.
    private static final String ATTACHMENT_FILE_PATCH = USER_DIR.value() + "\\src\\test\\resources\\images\\practiceform\\resume.pdf";

    private static final String PAGE_BASE_PATCH = USER_DIR.value() + "\\src\\main\\resources\\page\\practiceform\\";
    private static final String SELECT_PICTURE_PATCH = PAGE_BASE_PATCH + "Seleccionar.PNG";
    private static final String SELECT_OPEN_PATCH = PAGE_BASE_PATCH + "openWindows.PNG";
    private static final String FILE_NAME_TEXT_BOX_PATCH = PAGE_BASE_PATCH + "fileNameWindows.PNG";


    public PracticeForm(WebDriver driver, PracticeFormModel practiceFormModel) {
        super(driver);
        pageFactoryInitElement(driver, this);
        this.practiceFormModel = practiceFormModel;
        this.driver = driver;
    }

    public PracticeForm(WebDriver driver, PracticeFormModel practiceFormModel, int secondsForExplicitWait) {

        super(driver, secondsForExplicitWait);
        pageFactoryInitElement(driver, this);

        if (practiceFormModel == null)
            LOGGER.warn(MODEL_NULL_MESSAGE);

        this.practiceFormModel = practiceFormModel;
        this.driver = driver;

    }

    //Page functions.


    public void fillStudentFormUsingAllFields() {
        try {
            scrollTo(firsName);
            withExplicitWaitClear(firsName);
            withExplicitWaitTypeInto(firsName, practiceFormModel.getName());

            scrollTo(middleName);
            withExplicitWaitClear(middleName);
            withExplicitWaitTypeInto(middleName, practiceFormModel.getMiddleName());

            scrollTo(lastName);
            withExplicitWaitClear(lastName);
            withExplicitWaitTypeInto(lastName, practiceFormModel.getLastName());

            scrollTo(candidateEmail);
            withExplicitWaitClear(candidateEmail);
            withExplicitWaitTypeInto(candidateEmail, practiceFormModel.getEmail());

            /*switch (practiceFormModel.getGender()){
                case MALE:
                    scrollTo(genderMale);
                    clickOn(genderMale);
                    break;

                case FEMALE:
                    scrollTo(genderFemale);
                    clickOn(genderFemale);
                    break;

                case OTHER:
                    scrollTo(genderOther);
                    clickOn(genderOther);
                    break;

                default:
            }*/

            scrollTo(contactNo);
            withExplicitWaitClear(contactNo);
            withExplicitWaitTypeInto(contactNo, practiceFormModel.getContactNo());

            select(jobVacancy, practiceFormModel.getJobVacancy().getValue());

            javascriptExecutor("arguments[0].click();",resumeCandidate);
            //clickOn(SELECT_PICTURE_PATCH);
            insertInto(FILE_NAME_TEXT_BOX_PATCH, ATTACHMENT_FILE_PATCH);
            clickOn(SELECT_OPEN_PATCH);

            scrollTo(keyWords);
            withExplicitWaitClear(keyWords);
            withExplicitWaitTypeInto(keyWords, practiceFormModel.getKeyWords());

            scrollTo(commentCandidate);
            withExplicitWaitClear(commentCandidate);
            withExplicitWaitTypeInto(commentCandidate, practiceFormModel.getComment());

            scrollTo(dateAplication);
            clickOn(dateAplication);

            clickOn(By.xpath("//option[. = '" + practiceFormModel.getYear() + "']"));
            clickOn(By.xpath("//option[. = '" + practiceFormModel.getMonth() + "']"));
            // clickOn(By.xpath("//div[contains(@aria-label,'" + practiceFormModel.getDay() + "') and contains(@aria-label, '" + practiceFormModel.getMonth() + "')]"));

            DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat dateFormat3 = new SimpleDateFormat("dd");
            String strFecha = practiceFormModel.getYear() + "-09" + "-" + practiceFormModel.getDay();
            Date date2 = dateFormat2.parse(strFecha);

            String today = dateFormat3.format(date2);

            List<WebElement> allRows = driver.findElements(By.tagName("tr"));

            int i = 0;
            for (WebElement row : allRows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                int j = 0;
                for (WebElement cell : cells) {
                    if (i != 0 && cell.getText().equalsIgnoreCase(today)) {
                        cell.click();
                    }
                    j++;
                }
                i++;
            }



            scrollTo(consentToKeepData);
            clickOn(consentToKeepData);


            scrollTo(btnSave);
            clickOn(btnSave);
            clickOn(btnBack);

        } catch (Exception exception) {
            LOGGER.warn(exception.getMessage());
        }
    }

    /*public void asertionsTest() {//para traer datos
        assertionUserName = driver.findElement(By.id("candidateSearch_candidateName"));

    }*/

    public List<WebElement> getResultTable() {
        WebElement table = findElement(By.id("resultTable"));
        List<WebElement> allRows = table.findElements(By.tagName("tr"));
        return allRows;
    }

    public boolean validateUsersFilteredByRoles(List<WebElement> allRows, String candidato) {
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int i = 0;
            for (WebElement cell : cells) {
                if (i == 2 && cell.getText().equalsIgnoreCase(candidato)) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public void searchUserAdd() throws IOException {

        //scrollTo(assertionUserName);
        withExplicitWaitClear(assertionUserName);
        withExplicitWaitTypeInto(assertionUserName, practiceFormModel.getName() + practiceFormModel.getLastName());


    }

   /* public List<String> isRegistrationDone() {
        List<String> submitedFormResult = new ArrayList<>();
        submitedFormResult.add(getText(assertionStudentName).trim());
        submitedFormResult.add(getText(assertionGender).trim());
        submitedFormResult.add(getText(assertionMobile).trim());
        return submitedFormResult;
    }

    public String isNoneInseted() {
        return getText(assertionStudentName).trim();
    }*/

}

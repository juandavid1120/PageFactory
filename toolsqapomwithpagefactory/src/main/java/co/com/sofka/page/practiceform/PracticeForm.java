package co.com.sofka.page.practiceform;

import co.com.sofka.model.practiceform.PracticeFormModel;
import co.com.sofka.page.common.CommonActionsOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class PracticeForm extends CommonActionsOnPages {

    private static final Logger LOGGER = Logger.getLogger(PracticeForm.class);
    private PracticeFormModel practiceFormModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";

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
    private  WebElement candidateEmail;

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

    @FindBy(id = "addCandidate_resume")
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

    /*//For Assertions test case.
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[2]")
    @CacheLookup
    private WebElement assertionStudentName;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[2]/td[2]")
    @CacheLookup
    private WebElement assertionStudentEmail;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[3]/td[2]")
    @CacheLookup
    private WebElement assertionGender;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[4]/td[2]")
    @CacheLookup
    private WebElement assertionMobile;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[5]/td[2]")
    @CacheLookup
    private WebElement assertionStudentDateOfBirth;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[6]/td[2]")
    @CacheLookup
    private WebElement assertionSubjects;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[7]/td[2]")
    @CacheLookup
    private WebElement assertionHobbies;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[8]/td[2]")
    @CacheLookup
    private WebElement assertionPicture;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[9]/td[2]")
    @CacheLookup
    private WebElement assertionAddress;

    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[10]/td[2]")
    @CacheLookup
    private WebElement assertionStateAndCity;*/

    //Sikulix elements.
    private static final String ATTACHMENT_FILE_PATCH = USER_DIR.value() + "\\src\\test\\resources\\images\\practiceform\\happy.jpg";

    private static final String PAGE_BASE_PATCH = USER_DIR.value() + "\\src\\main\\resources\\page\\practiceform\\";
    private static final String SELECT_PICTURE_PATCH = PAGE_BASE_PATCH + "selectPicture.PNG";
    private static final String SELECT_OPEN_PATCH = PAGE_BASE_PATCH + "openWindows.PNG";
    private static final String FILE_NAME_TEXT_BOX_PATCH = PAGE_BASE_PATCH + "fileNameWindows.PNG";


    public PracticeForm(WebDriver driver, PracticeFormModel practiceFormModel) {
        super(driver);
        pageFactoryInitElement(driver, this);
        this.practiceFormModel = practiceFormModel;
    }

    public PracticeForm(WebDriver driver, PracticeFormModel practiceFormModel, int secondsForExplicitWait) {

        super(driver, secondsForExplicitWait);
        pageFactoryInitElement(driver, this);

        if(practiceFormModel == null)
            LOGGER.warn(MODEL_NULL_MESSAGE);

        this.practiceFormModel = practiceFormModel;

    }

    //Page functions.


    public void fillStudentFormUsingAllFields(){
        try{
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

            select(jobVacancy,practiceFormModel.getJobVacancy().getValue());

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
            clickOn(By.xpath("//div[contains(@aria-label,'" + practiceFormModel.getDay() + "') and contains(@aria-label, '" + practiceFormModel.getMonth() + "')]"));


            clickOn(SELECT_PICTURE_PATCH);
            insertInto(FILE_NAME_TEXT_BOX_PATCH, ATTACHMENT_FILE_PATCH);
            clickOn(SELECT_OPEN_PATCH);

            scrollTo(consentToKeepData);
            withExplicitWaitClear(consentToKeepData);
            withExplicitWaitTypeInto(consentToKeepData, practiceFormModel.getConsentData());



            scrollTo(btnSave);
            clickOn(btnSave);

        } catch (Exception exception){
            LOGGER.warn(exception.getMessage());
        }
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

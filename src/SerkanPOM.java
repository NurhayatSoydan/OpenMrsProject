import Utility.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SerkanPOM {
    public SerkanPOM() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(linkText = "Demo")
    public WebElement DemoButton;

    @FindBy(xpath = "//span[text()='Explore OpenMRS 2']")
    public WebElement OpenMRS;

    @FindBy(xpath = "//span[text()='Enter the OpenMRS 2 Demo']")
    public WebElement OpenMrsDemo;

    @FindBy(id ="username")
    public WebElement UserName;

    @FindBy(id ="password")
    public WebElement Password;

    @FindBy(css ="[class='select'] >li")
    public List<WebElement> Locations;

    @FindBy(css ="[tabindex='0']")
    public List<WebElement>LocationButton;

    @FindBy(id ="loginButton")
    public WebElement Loginbuton;

    @FindBy(css ="[class='icon-user']")
    public WebElement Register_Patient;

    @FindBy(name ="givenName")
    public WebElement GivenName;

    @FindBy(name ="middleName")
    public WebElement MiddleName;

    @FindBy(name ="familyName")
    public WebElement FamilyName;

    @FindBy(css ="[class='confirm right']")
    public WebElement ConfrimButton;

    @FindBy(id ="gender-field")
    public WebElement Gender;

    @FindBy(css ="[class='fas fa-chevron-right']")
    public WebElement RightArrow;

    @FindBy(name ="birthdateDay")
    public WebElement BirthDay;

    @FindBy(name ="birthdateMonth")
    public WebElement BirthdateMonth;

    @FindBy(name ="birthdateYear")
    public WebElement BirthDateYear;

    @FindBy(css ="[name='address1'][id='address1']")
    public WebElement Adress1;
    @FindBy(css = "[name='address2'][id='address2']")
    public WebElement Adress2;
    @FindBy(css =("[id='cityVillage']"))
    public WebElement City;
    @FindBy(css ="[id='stateProvince']")
    public WebElement StateProvince;

    @FindBy(css ="[id='country']")
    public WebElement Country;

    @FindBy(css ="[id='postalCode']")
    public WebElement PostalCode;

    @FindBy(name ="phoneNumber")
    public WebElement PhoneNumber;

    @FindBy(css ="[id='relationship_type']")
    public WebElement RelationShip;

    @FindBy(css ="[placeholder='Person Name']")
    public WebElement PersonName;

    @FindBy(id ="submit")
    public WebElement Confrim;

    @FindBy(css ="[class='PersonName-givenName']")
    public WebElement ConfrimName;
    @FindBy(css ="[class='float-sm-right']")
    public WebElement ConfrimID;

    @FindBy(xpath ="(//*[@class='icon-calendar'])[2]")
    public WebElement AppointmentScheduiling;

    @FindBy(id = "appointmentschedulingui-manageAppointments-app")
    public WebElement ManageServiceTypes;

    @FindBy(css = "[id='patient-search']")
    public WebElement SearchBox;

    @FindBy(css ="[id='time-zone-warning']")
    public WebElement Massege;

    @FindBy(css = "[class='icon-search']")
    public WebElement FindPatRec;

    @FindBy(css = "[class='odd']")
    public WebElement ClickPatient;

    @FindBy(css = "[class='float-left'] > li")
    public List<WebElement> GeneralActions;

    @FindBy(xpath = "//*[text()='No matching records found']")
    public WebElement WrongSearch;

    @FindBy(id = "Pharmacy")
    public WebElement PharmacyButton;

























}

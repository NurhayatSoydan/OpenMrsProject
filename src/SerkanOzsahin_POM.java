import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SerkanOzsahin_POM {

    public SerkanOzsahin_POM() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(className = "zak-button")
    public WebElement demoBtn;

    @FindBy(xpath = "//span[text()='Explore OpenMRS 2']")
    public WebElement openMRS2;

    @FindBy(xpath = "//span[text()='Enter the OpenMRS 2 Demo']")
    public WebElement openMRS2Demo;

    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "Pharmacy")
    public WebElement pharmacyBtn;

    @FindBy(id = "loginButton")
    public WebElement loginBtn;

    @FindBy(id = "error-message")
    public WebElement errorMsg;

    @FindBy(className = "icon-hdd")
    public WebElement dataMBtn;

    @FindBy(className = "icon-group")
    public WebElement mergePBtn;

    @FindBy(id = "patient1-text")
    public WebElement patient1;

    @FindBy(id = "patient2-text")
    public WebElement patient2;

    @FindBy(id = "confirm-button")
    public WebElement confirmBtn;

    @FindBy(css = "div[class='messages-container'] > h1")
    public WebElement warningText;

    @FindBy(id = "first-patient")
    public WebElement firstPatient;
}

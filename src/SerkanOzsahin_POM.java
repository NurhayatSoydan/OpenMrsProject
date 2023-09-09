import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SerkanOzsahin_POM {

    public SerkanOzsahin_POM() {PageFactory.initElements(BaseDriver.driver, this);}

    @FindBy(linkText = "Demo")
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
}

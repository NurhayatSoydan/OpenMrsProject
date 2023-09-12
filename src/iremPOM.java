import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class iremPOM {
    public iremPOM() {
        PageFactory.initElements(BaseDriver.driver, this);
    }
        @FindBy(xpath = "//span[text()='Enter the OpenMRS 2 Demo']")
    public WebElement demo;

       @FindBy(css ="input[id='username']" )
    public WebElement username;

       @FindBy(css ="input[id='password']" )
    public WebElement password;

       @FindBy(css = "li[id='Registration Desk']")
    public WebElement desk;

       @FindBy(css ="input[id='loginButton']" )
    public WebElement in;

       @FindBy(css = "a[href='/openmrs/appui/header/logout.action?successUrl=openmrs']")
    public WebElement out;

       @FindBy(xpath = "//span[text()='Enter the OpenMRS 2 Demo']")
    public WebElement Demo;

       @FindBy(css ="input[id='username']" )
    public WebElement Username;

       @FindBy(css="input[id='password']")
    public WebElement Password;

       @FindBy(css ="li[id='Registration Desk']" )
    public WebElement Desk;

       @FindBy(css ="input[id='loginButton']" )
    public WebElement IN;

       @FindBy(css ="i[class='icon-search']" )
    public WebElement findElement;


}

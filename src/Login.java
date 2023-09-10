import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Login extends BaseDriver {
    @Test
    public void login1() {

        driver.get("https://openmrs.org/demo/");

        WebElement demo2 = driver.findElement(By.xpath("(//*[@class='elementor-button-text'])[2]"));
        demo2.click();
        MyFunc.Bekle(3);

        WebElement demo3 = driver.findElement(By.xpath("(//*[@class='elementor-button-text'])[4]"));
        demo3.click();
        MyFunc.Bekle(2);

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Admin123");

        WebElement inpatientWard = driver.findElement(By.id("Inpatient Ward"));
        inpatientWard.click();

        WebElement lgnbutton = driver.findElement(By.id("loginButton"));
        lgnbutton.click();

    }
}

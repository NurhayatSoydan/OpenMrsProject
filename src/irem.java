import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class irem extends BaseDriver {
    String name = "Admin";
    String pAssword = "Admin123";

    @Test
    public void LogOut() {
        iremPOM e = new iremPOM();
        driver.get("https://openmrs.org/demo/");
        wait.until(ExpectedConditions.elementToBeClickable(e.demo));
        e.demo.click();
        e.username.sendKeys(name);
        e.password.sendKeys(pAssword);
        e.desk.click();
        e.in.click();
        e.out.click();

    }

    @Test
    public void list() {
        iremPOM e = new iremPOM();
        driver.get("https://openmrs.org/demo/");
        wait.until(ExpectedConditions.elementToBeClickable(e.Demo));
        e.Demo.click();
        e.Username.sendKeys(name);
        e.Password.sendKeys(pAssword);
        e.Desk.click();
        e.IN.click();
        e.findElement.click();


    }
}

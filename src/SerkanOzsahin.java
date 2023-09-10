import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SerkanOzsahin extends BaseDriver {

    String validId = "Admin";
    String validPassword = "Admin123";
    String invalidId = "Admin1";
    String invalidPassword = "Admin1234";

    @Test(priority = 1)
    public void LocationNull() { // Location not selected

        SerkanOzsahin_POM elements = new SerkanOzsahin_POM();
        driver.get("https://openmrs.org/");
        MyFunc.Bekle(1);
        elements.demoBtn.click();
        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        elements.openMRS2.click();
        MyFunc.Bekle(2);
        elements.openMRS2Demo.click();
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        elements.userName.sendKeys(validId);
        elements.password.sendKeys(validPassword);
        elements.loginBtn.click();
        WebElement locationError = driver.findElement(By.id("sessionLocationError"));
        wait.until(ExpectedConditions.visibilityOf(locationError));
        Assert.assertTrue(locationError.getText().contains("location"));
    }

    @Test(priority = 2)
    public void LoginPositive() { // Valid ID and Password

        SerkanOzsahin_POM elements = new SerkanOzsahin_POM();
        driver.get("https://openmrs.org/");
        MyFunc.Bekle(1);
        elements.demoBtn.click();
        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        elements.openMRS2.click();
        MyFunc.Bekle(2);
        elements.openMRS2Demo.click();
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        elements.userName.sendKeys(validId);
        elements.password.sendKeys(validPassword);
        elements.pharmacyBtn.click();
        elements.loginBtn.click();
        WebElement adminText = driver.findElement(By.cssSelector("div[class='col-12 col-sm-12 col-md-12 col-lg-12'] > h4"));
        wait.until(ExpectedConditions.visibilityOf(adminText));
        Assert.assertTrue(adminText.getText().contains("admin"));
        WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
        logoutBtn.click();
    }

    @Test(dataProvider = "userInvalid", priority = 3)
    public void LoginNegative1(String Id, String password) { // Invalid ID and Password, Invalid ID, Invalid Password

        SerkanOzsahin_POM elements = new SerkanOzsahin_POM();
        driver.get("https://openmrs.org/");
        MyFunc.Bekle(1);
        elements.demoBtn.click();
        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        elements.openMRS2.click();
        MyFunc.Bekle(2);
        elements.openMRS2Demo.click();
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        elements.userName.sendKeys(Id);
        elements.password.sendKeys(password);
        elements.pharmacyBtn.click();
        elements.loginBtn.click();
        wait.until(ExpectedConditions.visibilityOf(elements.errorMsg));
        Assert.assertTrue(elements.errorMsg.getText().contains("Invalid"));
    }

    @DataProvider
    public Object[][] userInvalid() {

        Object[][] invalidData = {{invalidId, invalidPassword}, {invalidId, validPassword}, {validId, invalidPassword}};
        return invalidData;
    }

    @Test(dataProvider = "userNull", priority = 4)
    public void LoginNull1(String Id, String password) { // Null ID and Password, Null ID, Null Password

        SerkanOzsahin_POM elements = new SerkanOzsahin_POM();
        driver.get("https://openmrs.org/");
        MyFunc.Bekle(1);
        elements.demoBtn.click();
        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        elements.openMRS2.click();
        MyFunc.Bekle(2);
        elements.openMRS2Demo.click();
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        elements.userName.sendKeys(Id);
        elements.password.sendKeys(password);
        elements.pharmacyBtn.click();
        elements.loginBtn.click();
        wait.until(ExpectedConditions.visibilityOf(elements.errorMsg));
        Assert.assertTrue(elements.errorMsg.getText().contains("Invalid"));
    }

    @DataProvider
    public Object[][] userNull() {

        Object[][] nullData = {{"", ""}, {"", validPassword}, {validId, ""}};
        return nullData;
    }
}

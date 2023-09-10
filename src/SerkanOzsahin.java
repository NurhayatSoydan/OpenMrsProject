import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
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

    @Test(priority = 3)
    public void LoginNegative1() { // Invalid ID and Password

        SerkanOzsahin_POM elements = new SerkanOzsahin_POM();
        driver.get("https://openmrs.org/");
        MyFunc.Bekle(1);
        elements.demoBtn.click();
        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        elements.openMRS2.click();
        MyFunc.Bekle(2);
        elements.openMRS2Demo.click();
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        elements.userName.sendKeys(invalidId);
        elements.password.sendKeys(invalidPassword);
        elements.pharmacyBtn.click();
        elements.loginBtn.click();
        wait.until(ExpectedConditions.visibilityOf(elements.errorMsg));
        Assert.assertTrue(elements.errorMsg.getText().contains("Invalid"));
    }

    @Test(priority = 4)
    public void LoginNegative2() { // Invalid ID

        SerkanOzsahin_POM elements = new SerkanOzsahin_POM();
        driver.get("https://openmrs.org/");
        MyFunc.Bekle(1);
        elements.demoBtn.click();
        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        elements.openMRS2.click();
        MyFunc.Bekle(2);
        elements.openMRS2Demo.click();
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        elements.userName.sendKeys(invalidId);
        elements.password.sendKeys(validPassword);
        elements.pharmacyBtn.click();
        elements.loginBtn.click();
        wait.until(ExpectedConditions.visibilityOf(elements.errorMsg));
        Assert.assertTrue(elements.errorMsg.getText().contains("Invalid"));
    }

    @Test(priority = 5)
    public void LoginNegative3() { // Invalid Password

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
        elements.password.sendKeys(invalidPassword);
        elements.pharmacyBtn.click();
        elements.loginBtn.click();
        wait.until(ExpectedConditions.visibilityOf(elements.errorMsg));
        Assert.assertTrue(elements.errorMsg.getText().contains("Invalid"));
    }

    @Test(priority = 6)
    public void LoginNull1() { // Null ID and Password

        SerkanOzsahin_POM elements = new SerkanOzsahin_POM();
        driver.get("https://openmrs.org/");
        MyFunc.Bekle(1);
        elements.demoBtn.click();
        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        elements.openMRS2.click();
        MyFunc.Bekle(2);
        elements.openMRS2Demo.click();
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        elements.pharmacyBtn.click();
        elements.loginBtn.click();
        wait.until(ExpectedConditions.visibilityOf(elements.errorMsg));
        Assert.assertTrue(elements.errorMsg.getText().contains("Invalid"));
    }

    @Test(priority = 7)
    public void LoginNull2() { // Null ID

        SerkanOzsahin_POM elements = new SerkanOzsahin_POM();
        driver.get("https://openmrs.org/");
        MyFunc.Bekle(1);
        elements.demoBtn.click();
        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        elements.openMRS2.click();
        MyFunc.Bekle(2);
        elements.openMRS2Demo.click();
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        elements.password.sendKeys(validPassword);
        elements.pharmacyBtn.click();
        elements.loginBtn.click();
        wait.until(ExpectedConditions.visibilityOf(elements.errorMsg));
        Assert.assertTrue(elements.errorMsg.getText().contains("Invalid"));
    }

    @Test(priority = 8)
    public void LoginNull3() { // Null Password

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
        elements.pharmacyBtn.click();
        elements.loginBtn.click();
        wait.until(ExpectedConditions.visibilityOf(elements.errorMsg));
        Assert.assertTrue(elements.errorMsg.getText().contains("Invalid"));
    }
}

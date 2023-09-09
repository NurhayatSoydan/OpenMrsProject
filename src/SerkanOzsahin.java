import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SerkanOzsahin extends BaseDriver {

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
        elements.userName.sendKeys("Admin");
        elements.password.sendKeys("Admin123");
        elements.loginBtn.click();
        WebElement locationError = driver.findElement(By.id("sessionLocationError"));
        wait.until(ExpectedConditions.visibilityOf(locationError));
        Assert.assertTrue(locationError.getText().contains("location"));
    }

    @Test(priority = 2)
    public void LoginPositive() { // Valid Username and Password

        SerkanOzsahin_POM elements = new SerkanOzsahin_POM();
        driver.get("https://openmrs.org/");
        MyFunc.Bekle(1);
        elements.demoBtn.click();
        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        elements.openMRS2.click();
        MyFunc.Bekle(2);
        elements.openMRS2Demo.click();
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        elements.userName.sendKeys("Admin");
        elements.password.sendKeys("Admin123");
        elements.pharmacyBtn.click();
        elements.loginBtn.click();
        WebElement adminText = driver.findElement(By.cssSelector("div[class='col-12 col-sm-12 col-md-12 col-lg-12'] > h4"));
        wait.until(ExpectedConditions.visibilityOf(adminText));
        Assert.assertTrue(adminText.getText().contains("admin"));
        WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
        logoutBtn.click();
    }

    @Test(priority = 3)
    public void LoginNegative1() { // Invalid Username and Password

        SerkanOzsahin_POM elements = new SerkanOzsahin_POM();
        driver.get("https://openmrs.org/");
        MyFunc.Bekle(1);
        elements.demoBtn.click();
        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        elements.openMRS2.click();
        MyFunc.Bekle(2);
        elements.openMRS2Demo.click();
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        elements.userName.sendKeys("Admin1");
        elements.password.sendKeys("Admin1234");
        elements.pharmacyBtn.click();
        elements.loginBtn.click();
        WebElement errorMsg = driver.findElement(By.id("error-message"));
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        Assert.assertTrue(errorMsg.getText().contains("Invalid"));
    }

    @Test(priority = 4)
    public void LoginNegative2() { // Invalid Username

        SerkanOzsahin_POM elements = new SerkanOzsahin_POM();
        driver.get("https://openmrs.org/");
        MyFunc.Bekle(1);
        elements.demoBtn.click();
        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        elements.openMRS2.click();
        MyFunc.Bekle(2);
        elements.openMRS2Demo.click();
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        elements.userName.sendKeys("Admin1");
        elements.password.sendKeys("Admin123");
        elements.pharmacyBtn.click();
        elements.loginBtn.click();
        WebElement errorMsg = driver.findElement(By.id("error-message"));
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        Assert.assertTrue(errorMsg.getText().contains("Invalid"));
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
        elements.userName.sendKeys("Admin");
        elements.password.sendKeys("Admin1234");
        elements.pharmacyBtn.click();
        elements.loginBtn.click();
        WebElement errorMsg = driver.findElement(By.id("error-message"));
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        Assert.assertTrue(errorMsg.getText().contains("Invalid"));
    }

    @Test(priority = 6)
    public void LoginNull1() { // Null Username and Password

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
        WebElement errorMsg = driver.findElement(By.id("error-message"));
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        Assert.assertTrue(errorMsg.getText().contains("Invalid"));
    }

    @Test(priority = 7)
    public void LoginNull2() { // Null Username

        SerkanOzsahin_POM elements = new SerkanOzsahin_POM();
        driver.get("https://openmrs.org/");
        MyFunc.Bekle(1);
        elements.demoBtn.click();
        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        elements.openMRS2.click();
        MyFunc.Bekle(2);
        elements.openMRS2Demo.click();
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        elements.password.sendKeys("Admin123");
        elements.pharmacyBtn.click();
        elements.loginBtn.click();
        WebElement errorMsg = driver.findElement(By.id("error-message"));
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        Assert.assertTrue(errorMsg.getText().contains("Invalid"));
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
        elements.userName.sendKeys("Admin");
        elements.pharmacyBtn.click();
        elements.loginBtn.click();
        WebElement errorMsg = driver.findElement(By.id("error-message"));
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        Assert.assertTrue(errorMsg.getText().contains("Invalid"));
    }
}

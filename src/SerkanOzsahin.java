import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SerkanOzsahin extends BaseDriver {

    @Test
    public void LoginPositive() { // Valid Username and Password

        driver.get("https://openmrs.org/");

        WebElement demoBtn = driver.findElement(By.linkText("Demo"));
        demoBtn.click();

        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        WebElement openMRS2 = driver.findElement(By.xpath("//span[text()='Explore OpenMRS 2']"));
        openMRS2.click();

        MyFunc.Bekle(2);

        WebElement openMRS2Demo = driver.findElement(By.xpath("//span[text()='Enter the OpenMRS 2 Demo']"));
        wait.until(ExpectedConditions.visibilityOf(openMRS2Demo));
        openMRS2Demo.click();

        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("Admin");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Admin123");

        WebElement pharmacyBtn = driver.findElement(By.id("Pharmacy"));
        pharmacyBtn.click();

        WebElement loginBtn = driver.findElement(By.id("loginButton"));
        loginBtn.click();

        WebElement adminText = driver.findElement(By.cssSelector("div[class='col-12 col-sm-12 col-md-12 col-lg-12'] > h4"));

        Assert.assertTrue(adminText.getText().contains("admin"));
    }

    @Test
    public void LoginNegative1() { // Invalid Username and Password

        driver.get("https://openmrs.org/");

        WebElement demoBtn = driver.findElement(By.linkText("Demo"));
        demoBtn.click();

        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        WebElement openMRS2 = driver.findElement(By.xpath("//span[text()='Explore OpenMRS 2']"));
        openMRS2.click();

        MyFunc.Bekle(2);

        WebElement openMRS2Demo = driver.findElement(By.xpath("//span[text()='Enter the OpenMRS 2 Demo']"));
        wait.until(ExpectedConditions.visibilityOf(openMRS2Demo));
        openMRS2Demo.click();

        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("Admin1");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Admin1234");

        WebElement pharmacyBtn = driver.findElement(By.id("Pharmacy"));
        pharmacyBtn.click();

        WebElement loginBtn = driver.findElement(By.id("loginButton"));
        loginBtn.click();

        WebElement errorMsg = driver.findElement(By.id("error-message"));

        Assert.assertTrue(errorMsg.getText().contains("Invalid"));
    }

    @Test
    public void LoginNegative2() { // Invalid Username

        driver.get("https://openmrs.org/");

        WebElement demoBtn = driver.findElement(By.linkText("Demo"));
        demoBtn.click();

        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        WebElement openMRS2 = driver.findElement(By.xpath("//span[text()='Explore OpenMRS 2']"));
        openMRS2.click();

        MyFunc.Bekle(2);

        WebElement openMRS2Demo = driver.findElement(By.xpath("//span[text()='Enter the OpenMRS 2 Demo']"));
        wait.until(ExpectedConditions.visibilityOf(openMRS2Demo));
        openMRS2Demo.click();

        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("Admin1");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Admin123");

        WebElement pharmacyBtn = driver.findElement(By.id("Pharmacy"));
        pharmacyBtn.click();

        WebElement loginBtn = driver.findElement(By.id("loginButton"));
        loginBtn.click();

        WebElement errorMsg = driver.findElement(By.id("error-message"));

        Assert.assertTrue(errorMsg.getText().contains("Invalid"));
    }

    @Test
    public void LoginNegative3() { // Invalid Password

        driver.get("https://openmrs.org/");

        WebElement demoBtn = driver.findElement(By.linkText("Demo"));
        demoBtn.click();

        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        WebElement openMRS2 = driver.findElement(By.xpath("//span[text()='Explore OpenMRS 2']"));
        openMRS2.click();

        MyFunc.Bekle(2);

        WebElement openMRS2Demo = driver.findElement(By.xpath("//span[text()='Enter the OpenMRS 2 Demo']"));
        wait.until(ExpectedConditions.visibilityOf(openMRS2Demo));
        openMRS2Demo.click();

        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("Admin");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Admin1234");

        WebElement pharmacyBtn = driver.findElement(By.id("Pharmacy"));
        pharmacyBtn.click();

        WebElement loginBtn = driver.findElement(By.id("loginButton"));
        loginBtn.click();

        WebElement errorMsg = driver.findElement(By.id("error-message"));

        Assert.assertTrue(errorMsg.getText().contains("Invalid"));
    }

    @Test
    public void LoginNull1() { // Null Username and Password

        driver.get("https://openmrs.org/");

        WebElement demoBtn = driver.findElement(By.linkText("Demo"));
        demoBtn.click();

        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        WebElement openMRS2 = driver.findElement(By.xpath("//span[text()='Explore OpenMRS 2']"));
        openMRS2.click();

        MyFunc.Bekle(2);

        WebElement openMRS2Demo = driver.findElement(By.xpath("//span[text()='Enter the OpenMRS 2 Demo']"));
        wait.until(ExpectedConditions.visibilityOf(openMRS2Demo));
        openMRS2Demo.click();

        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));

        WebElement pharmacyBtn = driver.findElement(By.id("Pharmacy"));
        pharmacyBtn.click();

        WebElement loginBtn = driver.findElement(By.id("loginButton"));
        loginBtn.click();

        WebElement errorMsg = driver.findElement(By.id("error-message"));

        Assert.assertTrue(errorMsg.getText().contains("Invalid"));
    }

    @Test
    public void LoginNull2() { // Null Username

        driver.get("https://openmrs.org/");

        WebElement demoBtn = driver.findElement(By.linkText("Demo"));
        demoBtn.click();

        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        WebElement openMRS2 = driver.findElement(By.xpath("//span[text()='Explore OpenMRS 2']"));
        openMRS2.click();

        MyFunc.Bekle(2);

        WebElement openMRS2Demo = driver.findElement(By.xpath("//span[text()='Enter the OpenMRS 2 Demo']"));
        wait.until(ExpectedConditions.visibilityOf(openMRS2Demo));
        openMRS2Demo.click();

        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Admin123");

        WebElement pharmacyBtn = driver.findElement(By.id("Pharmacy"));
        pharmacyBtn.click();

        WebElement loginBtn = driver.findElement(By.id("loginButton"));
        loginBtn.click();

        WebElement errorMsg = driver.findElement(By.id("error-message"));

        Assert.assertTrue(errorMsg.getText().contains("Invalid"));
    }

    @Test
    public void LoginNull3() { // Null Password

        driver.get("https://openmrs.org/");

        WebElement demoBtn = driver.findElement(By.linkText("Demo"));
        demoBtn.click();

        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        WebElement openMRS2 = driver.findElement(By.xpath("//span[text()='Explore OpenMRS 2']"));
        openMRS2.click();

        MyFunc.Bekle(2);

        WebElement openMRS2Demo = driver.findElement(By.xpath("//span[text()='Enter the OpenMRS 2 Demo']"));
        wait.until(ExpectedConditions.visibilityOf(openMRS2Demo));
        openMRS2Demo.click();

        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("Admin");

        WebElement pharmacyBtn = driver.findElement(By.id("Pharmacy"));
        pharmacyBtn.click();

        WebElement loginBtn = driver.findElement(By.id("loginButton"));
        loginBtn.click();

        WebElement errorMsg = driver.findElement(By.id("error-message"));

        Assert.assertTrue(errorMsg.getText().contains("Invalid"));
    }

    @Test
    public void LocationNull() { // Location not selected

        driver.get("https://openmrs.org/");

        WebElement demoBtn = driver.findElement(By.linkText("Demo"));
        demoBtn.click();

        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        WebElement openMRS2 = driver.findElement(By.xpath("//span[text()='Explore OpenMRS 2']"));
        openMRS2.click();

        MyFunc.Bekle(2);

        WebElement openMRS2Demo = driver.findElement(By.xpath("//span[text()='Enter the OpenMRS 2 Demo']"));
        wait.until(ExpectedConditions.visibilityOf(openMRS2Demo));
        openMRS2Demo.click();

        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("Admin");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Admin123");

        WebElement loginBtn = driver.findElement(By.id("loginButton"));
        loginBtn.click();

        WebElement locationError = driver.findElement(By.id("sessionLocationError"));

        Assert.assertTrue(locationError.getText().contains("location"));
    }
}

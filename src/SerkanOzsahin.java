import Utility.BaseDriverParameter;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SerkanOzsahin extends BaseDriverParameter {

    String validId = "Admin";
    String validPassword = "Admin123";
    String invalidId = "Admin1";
    String invalidPassword = "Admin1234";
    String patient1ID = "100NUH";
    String patient2ID = "100NVF";

    @Test(groups = {"Smoke Test"})
    public void locationNull() { // Location not selected

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

    @Test(groups = {"Smoke Test"})
    public void loginPositive() { // Valid ID and Password

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

    @Test(dataProvider = "userInvalid", groups = {"Smoke Test"})
    public void loginNegative(String Id, String password) { // Invalid ID and Password, Invalid ID, Invalid Password

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

    @Test(dataProvider = "userNull", groups = {"Smoke Test"})
    public void loginNull(String Id, String password) { // Null ID and Password, Null ID, Null Password

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

    @Test(groups = {"Regression Test"})
    public void patientMerge() {

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
        elements.dataMBtn.click();
        elements.mergePBtn.click();
        elements.patient1.sendKeys(patient1ID);
        elements.patient2.sendKeys(patient2ID + Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(elements.confirmBtn));
        elements.confirmBtn.click();
        wait.until(ExpectedConditions.visibilityOf(elements.warningText));
        Assert.assertTrue(elements.warningText.getText().contains("Merging cannot"));
        elements.firstPatient.click();
        elements.confirmBtn.click();
        wait.until(ExpectedConditions.urlContains("patientDashboard"));
        WebElement firstPID = driver.findElement(By.xpath("//span[text()='" + patient1ID + "']"));
        WebElement secondPID = driver.findElement(By.xpath("//span[text()='" + patient2ID + "']"));
        Assert.assertTrue(firstPID.getText().equals(patient1ID));
        Assert.assertTrue(secondPID.getText().equals(patient2ID));
    }
}

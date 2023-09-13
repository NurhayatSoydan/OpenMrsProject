import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OpenMrsMain extends BaseDriver {
    OpenMrsMain_POM e = new OpenMrsMain_POM();


    //İrem TORUN
    String name = "Admin";
    String pAssword = "Admin123";

    @Test
    public void LogOut() {
        OpenMrsMain_POM e = new OpenMrsMain_POM();
        driver.get("https://openmrs.org/demo/");
        wait.until(ExpectedConditions.elementToBeClickable(e.demo));
        e.demo.click();
        e.username.sendKeys(name);
        e.Password.sendKeys(pAssword);
        e.desk.click();
        e.in.click();
        e.out.click();

    }

    @Test
    public void list() {
        OpenMrsMain_POM e = new OpenMrsMain_POM();
        driver.get("https://openmrs.org/demo/");
        wait.until(ExpectedConditions.elementToBeClickable(e.Demo));
        e.Demo.click();
        e.Username.sendKeys(name);
        e.Password.sendKeys(pAssword);
        e.Desk.click();
        e.IN.click();
        e.findElement.click();


    }

    //Nurhayat SOYDAN
    @Test
    public void login1() {

        driver.get("https://openmrs.org/demo/");
        MyFunc.Bekle(3);
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


    @Test
    public void test2() {
        driver.get("https://openmrs.org/");

        WebElement demoBtn = driver.findElement(By.cssSelector("[class='zak-button']"));
        demoBtn.click();

        MyFunc.Bekle(3);
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
        WebElement account = driver.findElement(By.cssSelector("[class='nav-item identifier']"));

        MyFunc.Bekle(2);
        Actions aksiyonDriver = new Actions(driver);
        MyFunc.Bekle(2);
        aksiyonDriver.moveToElement(account).build().perform();

        MyFunc.Bekle(2);
        account.click();
        WebElement giris = driver.findElement(By.cssSelector("[href='/openmrs/adminui/myaccount/myAccount.page']"));
        giris.click();

    }

    //Serkan ÖZŞAHİN
    String validId = "Admin";
    String validPassword = "Admin123";
    String invalidId = "Admin1";
    String invalidPassword = "Admin1234";
    String patient1ID = "100J0C";
    String patient2ID = "100HXG";

    @Test
    public void locationNull() { // Location not selected

        OpenMrsMain_POM e = new OpenMrsMain_POM();
        driver.get("https://openmrs.org/");
        MyFunc.Bekle(1);
        e.demoBtn.click();
        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        e.openMRS2.click();
        MyFunc.Bekle(2);
        e.openMRS2Demo.click();
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        e.userName.sendKeys(validId);
        e.Password.sendKeys(validPassword);
        e.loginBtn.click();
        WebElement locationError = driver.findElement(By.id("sessionLocationError"));
        wait.until(ExpectedConditions.visibilityOf(locationError));
        Assert.assertTrue(locationError.getText().contains("location"));
    }

    @Test
    public void loginPositive() { // Valid ID and Password

        OpenMrsMain_POM e = new OpenMrsMain_POM();
        driver.get("https://openmrs.org/");
        MyFunc.Bekle(1);
        e.demoBtn.click();
        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        e.openMRS2.click();
        MyFunc.Bekle(2);
        e.openMRS2Demo.click();
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        e.userName.sendKeys(validId);
        e.Password.sendKeys(validPassword);
        e.pharmacyBtn.click();
        e.loginBtn.click();
        WebElement adminText = driver.findElement(By.cssSelector("div[class='col-12 col-sm-12 col-md-12 col-lg-12'] > h4"));
        wait.until(ExpectedConditions.visibilityOf(adminText));
        Assert.assertTrue(adminText.getText().contains("admin"));
        WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
        logoutBtn.click();
    }

    @Test(dataProvider = "userInvalid")
    public void loginNegative(String Id, String password) { // Invalid ID and Password, Invalid ID, Invalid Password

        OpenMrsMain_POM e = new OpenMrsMain_POM();
        driver.get("https://openmrs.org/");
        MyFunc.Bekle(1);
        e.demoBtn.click();
        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        e.openMRS2.click();
        MyFunc.Bekle(2);
        e.openMRS2Demo.click();
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        e.userName.sendKeys(Id);
        e.Password.sendKeys(password);
        e.pharmacyBtn.click();
        e.loginBtn.click();
        wait.until(ExpectedConditions.visibilityOf(e.errorMsg));
        Assert.assertTrue(e.errorMsg.getText().contains("Invalid"));
    }

    @DataProvider
    public Object[][] userInvalid() {

        Object[][] invalidData = {{invalidId, invalidPassword}, {invalidId, validPassword}, {validId, invalidPassword}};
        return invalidData;
    }

    @Test(dataProvider = "userNull")
    public void loginNull(String Id, String password) { // Null ID and Password, Null ID, Null Password

        OpenMrsMain_POM e = new OpenMrsMain_POM();
        driver.get("https://openmrs.org/");
        MyFunc.Bekle(1);
        e.demoBtn.click();
        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        e.openMRS2.click();
        MyFunc.Bekle(2);
        e.openMRS2Demo.click();
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        e.userName.sendKeys(Id);
        e.Password.sendKeys(password);
        e.pharmacyBtn.click();
        e.loginBtn.click();
        wait.until(ExpectedConditions.visibilityOf(e.errorMsg));
        Assert.assertTrue(e.errorMsg.getText().contains("Invalid"));
    }

    @DataProvider
    public Object[][] userNull() {

        Object[][] nullData = {{"", ""}, {"", validPassword}, {validId, ""}};
        return nullData;
    }

    @Test
    public void patientMerge() {

        OpenMrsMain_POM e = new OpenMrsMain_POM();
        driver.get("https://openmrs.org/");
        MyFunc.Bekle(1);
        e.demoBtn.click();
        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        e.openMRS2.click();
        MyFunc.Bekle(2);
        e.openMRS2Demo.click();
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        e.userName.sendKeys(validId);
        e.Password.sendKeys(validPassword);
        e.pharmacyBtn.click();
        e.loginBtn.click();
        e.dataMBtn.click();
        e.mergePBtn.click();
        e.patient1.sendKeys(patient1ID);
        e.patient2.sendKeys(patient2ID + Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(e.confirmBtn));
        e.confirmBtn.click();
        wait.until(ExpectedConditions.visibilityOf(e.warningText));
        Assert.assertTrue(e.warningText.getText().contains("Merging cannot"));
        e.firstPatient.click();
        e.confirmBtn.click();
        wait.until(ExpectedConditions.urlContains("patientDashboard"));
        WebElement firstPID = driver.findElement(By.xpath("//span[text()='" + patient1ID + "']"));
        WebElement secondPID = driver.findElement(By.xpath("//span[text()='" + patient2ID + "']"));
        Assert.assertTrue(firstPID.getText().equals(patient1ID));
        Assert.assertTrue(secondPID.getText().equals(patient2ID));
    }
    //Serkan ŞENGÜL

    @Test
    public void Patient_Registration() {
        OpenMrsMain_POM e = new OpenMrsMain_POM();

        driver.get("https://openmrs.org/");
        MyFunc.Bekle(1);
        e.DemoButton.click();
        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        e.OpenMRS.click();
        MyFunc.Bekle(2);
        e.OpenMrsDemo.click();
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        e.UserName.sendKeys("admin");
        e.Password.sendKeys("Admin123");

        int randomSecim = MyFunc.randomGenerator(e.Locations.size());
        e.LocationButton.get(randomSecim).click();

        e.Loginbuton.click();
        e.Register_Patient.click();
        wait.until(ExpectedConditions.elementToBeClickable(e.GivenName));
        e.GivenName.sendKeys("TestHamza");
        e.MiddleName.sendKeys("TestHamdi");
        e.FamilyName.sendKeys("TestMemduh");
        e.ConfrimButton.click();

        Select Genderselect = new Select(e.Gender);
        Genderselect.selectByValue("M");

        e.RightArrow.click();
        e.BirthDay.sendKeys("23");

        Select MonthSelect = new Select(e.BirthdateMonth);
        MonthSelect.selectByValue("4");

        e.BirthDateYear.sendKeys("1990");
        e.ConfrimButton.click();
        e.Adress1.sendKeys("İzmir");
        e.Adress2.sendKeys("Türkiye");
        e.City.sendKeys("İzmir");
        e.StateProvince.sendKeys("İzmir");
        e.Country.sendKeys("İzmir");
        e.PostalCode.sendKeys("35000");
        e.ConfrimButton.click();
        e.PhoneNumber.sendKeys("5555555555");
        e.ConfrimButton.click();

        Select RelatSelect = new Select(e.RelationShip);
        RelatSelect.selectByVisibleText("Doctor");

        e.PersonName.sendKeys("Ebubekir");
        e.ConfrimButton.click();
        e.Confrim.click();
        wait.until(ExpectedConditions.visibilityOf(e.ConfrimName));
        System.out.println("hamza.ConfrimName = " + e.ConfrimName.getText());
        System.out.println("hamza.ConfrimID = " + e.ConfrimID.getText());

        Assert.assertTrue(e.ConfrimName.isEnabled());
        Assert.assertTrue(e.ConfrimID.isEnabled());


    }

    @Test
    public void Patient_Appointment_Wrong_Time_Zone() {
        OpenMrsMain_POM e = new OpenMrsMain_POM();

        driver.get("https://openmrs.org/");
        MyFunc.Bekle(1);
        e.DemoButton.click();
        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        e.OpenMRS.click();
        MyFunc.Bekle(2);
        e.OpenMrsDemo.click();
//        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
//        e.UserName.sendKeys("admin");
//        e.Password.sendKeys("Admin123");

//        e.PharmacyButton.click();
//        e.Loginbuton.click();
        e.AppointmentScheduiling.click();
        e.ManageServiceTypes.click();
        e.SearchBox.sendKeys("100LMX" + Keys.ENTER);

        System.out.println("hamza.Mesaage.getText() = " + e.Massege.getText());
        Assert.assertTrue(e.Massege.isEnabled());

    }

    @Test
    public void Patient_Appointment_Correct_Time_Zone() {
        OpenMrsMain_POM e = new OpenMrsMain_POM();
        //Randevu almadan önce mutlaka saati GMT+0 yapmanız gerekmektedir.
        driver.get("https://openmrs.org/");
        MyFunc.Bekle(1);
        e.DemoButton.click();
        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        e.OpenMRS.click();
        MyFunc.Bekle(2);
        e.OpenMrsDemo.click();
//        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
//
//        e.UserName.sendKeys("admin");
//       e.Password.sendKeys("Admin123");
//        e.PharmacyButton.click();
//        e.Loginbuton.click();
        e.AppointmentScheduiling.click();
        e.ManageServiceTypes.click();
        e.SearchBox.sendKeys("100LMX" + Keys.ENTER);

        System.out.println("hamza.Mesaage.getText() = " + e.Massege.getText());
        Assert.assertFalse(e.Massege.isDisplayed());
    }

    @Test
    public void Searching_the_Patient_List() {
        OpenMrsMain_POM e = new OpenMrsMain_POM();
        driver.get("https://openmrs.org/");
        MyFunc.Bekle(1);
        e.DemoButton.click();
        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        e.OpenMRS.click();
        MyFunc.Bekle(2);
        e.OpenMrsDemo.click();
//        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
//        e.UserName.sendKeys("admin");
//      e.Password.sendKeys("Admin123");
//        e.PharmacyButton.click();
//        e.Loginbuton.click();
        e.FindPatRec.click();
        e.SearchBox.sendKeys("100LMX");
        wait.until(ExpectedConditions.visibilityOf(e.ClickPatient));
        e.ClickPatient.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(e.GeneralActions));
        for (WebElement Siddik : e.GeneralActions) {
            System.out.println("Siddik.getText() = " + Siddik.getText());
            Assert.assertTrue(Siddik.isEnabled());
        }

    }

    @Test
    public void Searching_With_WrongName() {
        OpenMrsMain_POM e = new OpenMrsMain_POM();
        driver.get("https://openmrs.org/");
        MyFunc.Bekle(1);
        e.DemoButton.click();
        wait.until(ExpectedConditions.urlToBe("https://openmrs.org/demo/"));
        e.OpenMRS.click();
        MyFunc.Bekle(2);
        e.OpenMrsDemo.click();
//        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
//        e.UserName.sendKeys("admin");
//        e.Password.sendKeys("Admin123");
//        e.PharmacyButton.click();
//        e.Loginbuton.click();
        e.FindPatRec.click();
        e.SearchBox.sendKeys("100JK421");
        wait.until(ExpectedConditions.visibilityOf(e.WrongSearch));
        Assert.assertTrue(e.WrongSearch.isEnabled());
        System.out.println("test.WrongSearch.getText() = " + e.WrongSearch.getText());
    }

}

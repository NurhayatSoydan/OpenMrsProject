import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SerkanSengul extends BaseDriver {

    @Test
    public void Patient_Registration() {
        SerkanPOM hamza = new SerkanPOM();

        driver.get("https://openmrs.org/");
        wait.until(ExpectedConditions.elementToBeClickable(hamza.DemoButon));
        hamza.DiscoButon.click();

        Set<String> windowsIDler = driver.getWindowHandles();
        Iterator gosterge = windowsIDler.iterator();
        String secondSekme = gosterge.next().toString();

        driver.switchTo().window(secondSekme);
        driver.get("https://openmrs.org/product/");

        hamza.DemoButon.click();
        hamza.UserName.sendKeys("admin");
        hamza.Password.sendKeys("Admin123");

        int randomSecim = MyFunc.randomGenerator(hamza.Locations.size());
        hamza.LocationButton.get(randomSecim).click();

        hamza.Loginbuton.click();
        hamza.Register_Patient.click();
        wait.until(ExpectedConditions.elementToBeClickable(hamza.GivenName));
        hamza.GivenName.sendKeys("TestHamza");
        hamza.MiddleName.sendKeys("TestHamdi");
        hamza.FamilyName.sendKeys("TestMemduh");
        hamza.ConfrimButton.click();

        Select Genderselect = new Select(hamza.Gender);
        Genderselect.selectByValue("M");

        hamza.RightArrow.click();
        hamza.BirthDay.sendKeys("23");

        Select MonthSelect = new Select(hamza.BirthdateMonth);
        MonthSelect.selectByValue("4");

        hamza.BirthDateYear.sendKeys("1990");
        hamza.ConfrimButton.click();
        hamza.Adress1.sendKeys("İzmir");
        hamza.Adress2.sendKeys("Türkiye");
        hamza.City.sendKeys("İzmir");
        hamza.StateProvince.sendKeys("İzmir");
        hamza.Country.sendKeys("İzmir");
        hamza.PostalCode.sendKeys("35000");
        hamza.ConfrimButton.click();
        hamza.PhoneNumber.sendKeys("5555555555");
        hamza.ConfrimButton.click();

        Select RelatSelect = new Select(hamza.RelationShip);
        RelatSelect.selectByVisibleText("Doctor");

        hamza.PersonName.sendKeys("Ebubekir");
        hamza.ConfrimButton.click();
        hamza.Confrim.click();
        wait.until(ExpectedConditions.visibilityOf(hamza.ConfrimName));
        System.out.println("hamza.ConfrimName = " + hamza.ConfrimName.getText());
        System.out.println("hamza.ConfrimID = " + hamza.ConfrimID.getText());

        Assert.assertTrue(hamza.ConfrimName.isEnabled());
        Assert.assertTrue(hamza.ConfrimID.isEnabled());


    }
    @Test
    public void Patient_Appointment_Wrong_Time_Zone(){
        SerkanPOM hamza=new SerkanPOM();

        driver.get("https://openmrs.org/");
        wait.until(ExpectedConditions.elementToBeClickable(hamza.DemoButon));
        hamza.DiscoButon.click();

        Set<String> windowsIDler = driver.getWindowHandles();
        Iterator gosterge = windowsIDler.iterator();
        String secondSekme = gosterge.next().toString();

        driver.switchTo().window(secondSekme);
        driver.get("https://openmrs.org/product/");

        hamza.DemoButon.click();
        hamza.UserName.sendKeys("admin");
        hamza.Password.sendKeys("Admin123");

        int randomSecim = MyFunc.randomGenerator(hamza.Locations.size());
        hamza.LocationButton.get(randomSecim).click();

        hamza.Loginbuton.click();
        hamza.AppointmentScheduiling.click();
        hamza.ManageServiceTypes.click();
        hamza.SearchBox.sendKeys("100M6V"+Keys.ENTER);

        System.out.println("hamza.Mesaage.getText() = " + hamza.Massege.getText());
        Assert.assertTrue(hamza.Massege.isEnabled());

    }

    @Test
    public void Patient_Appointment_Correct_Time_Zone(){
        SerkanPOM hamza=new SerkanPOM();

        driver.get("https://openmrs.org/");
        wait.until(ExpectedConditions.elementToBeClickable(hamza.DemoButon));
        hamza.DiscoButon.click();

        Set<String> windowsIDler = driver.getWindowHandles();
        Iterator gosterge = windowsIDler.iterator();
        String secondSekme = gosterge.next().toString();

        driver.switchTo().window(secondSekme);
        driver.get("https://openmrs.org/product/");

        hamza.DemoButon.click();
        hamza.UserName.sendKeys("admin");
        hamza.Password.sendKeys("Admin123");

        int randomSecim = MyFunc.randomGenerator(hamza.Locations.size());
        hamza.LocationButton.get(randomSecim).click();

        hamza.Loginbuton.click();
        hamza.AppointmentScheduiling.click();
        hamza.ManageServiceTypes.click();
        hamza.SearchBox.sendKeys("100M6V"+Keys.ENTER);

        System.out.println("hamza.Mesaage.getText() = " + hamza.Massege.getText());
        Assert.assertFalse(hamza.Massege.isDisplayed());
    }


}



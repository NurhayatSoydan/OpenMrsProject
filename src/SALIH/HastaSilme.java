package SALIH;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HastaSilme extends BaseDriver {
    @Test
    public void HastaSilme1(){
        driver.get("https://openmrs.org/");
        MyFunc.Bekle(2);
        WebElement demo= driver.findElement(By.className("zak-button"));
        demo.click();
        WebElement buton=driver.findElement(By.xpath("//span[text()='Explore OpenMRS 2']"));
        wait.until(ExpectedConditions.visibilityOf(buton));
        buton.click();
        MyFunc.Bekle(3);
        WebElement demo2=driver.findElement(By.xpath("//span[text()='Enter the OpenMRS 2 Demo']"));
        demo2.click();
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        WebElement user=driver.findElement(By.id("username"));
        user.sendKeys("Admin");
        WebElement pass=driver.findElement(By.id("password"));
        pass.sendKeys("Admin123");

        WebElement isolation= driver.findElement(By.cssSelector("[id='sessionLocation'] :nth-child(2)"));
        isolation.click();
        WebElement login= driver.findElement(By.id("loginButton"));
        login.click();
        MyFunc.Bekle(2);
        WebElement record= driver.findElement(By.className("icon-search"));
        record.click();

        WebElement patient= driver.findElement(By.id("patient-search"));
        patient.sendKeys("100T5T");
        MyFunc.Bekle(2);
        WebElement person= driver.findElement(By.xpath("//td[text()='100T5T']"));
        person.click();
        WebElement delete= driver.findElement(By.id("org.openmrs.module.coreapps.deletePatient"));
        delete.click();
        WebElement text= driver.findElement(By.id("delete-reason"));
        text.sendKeys("YES");
        WebElement confirm= driver.findElement(By.xpath("(//*[@class='confirm right'])[6]"));
        confirm.click();



    }
    @Test
    public void Test2(){
        driver.get("https://openmrs.org/");
        MyFunc.Bekle(2);
        WebElement demo= driver.findElement(By.className("zak-button"));
        demo.click();
        WebElement buton=driver.findElement(By.xpath("//span[text()='Explore OpenMRS 2']"));
        wait.until(ExpectedConditions.visibilityOf(buton));
        buton.click();
        MyFunc.Bekle(3);
        WebElement demo2=driver.findElement(By.xpath("//span[text()='Enter the OpenMRS 2 Demo']"));
        demo2.click();
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        WebElement user=driver.findElement(By.id("username"));
        user.sendKeys("Admin");
        WebElement pass=driver.findElement(By.id("password"));
        pass.sendKeys("Admin123");

        WebElement isolation= driver.findElement(By.cssSelector("[id='sessionLocation'] :nth-child(2)"));
        isolation.click();
        WebElement login= driver.findElement(By.id("loginButton"));
        login.click();
        MyFunc.Bekle(2);
        WebElement record= driver.findElement(By.className("icon-search"));
        record.click();

        WebElement patient= driver.findElement(By.id("patient-search"));
        patient.sendKeys("100T55");
        MyFunc.Bekle(2);
        WebElement msj= driver.findElement(By.cssSelector("[class='dataTables_empty']"));
       Assert.assertTrue(msj.getText().toLowerCase().contains("no matching"));
        System.out.println("msj.getText() = " + msj.getText());
    }
}

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class irem extends BaseDriver {
    @Test
    public void LogOut(){
        iremPOM e=new iremPOM();
        driver.get("https://openmrs.org/demo/");
        WebElement demo= driver.findElement(By.xpath("//span[text()='Enter the OpenMRS 2 Demo']"));
        demo.click();
        MyFunc.Bekle(1);

        WebElement username=driver.findElement(By.cssSelector("input[id='username']"));
        username.sendKeys("Admin");
        MyFunc.Bekle(1);

        WebElement password=driver.findElement(By.cssSelector("input[id='password']"));
        password.sendKeys("Admin123");
        MyFunc.Bekle(1);

       WebElement desk=driver.findElement(By.cssSelector("li[id='Registration Desk']"));
       desk.click();
       MyFunc.Bekle(1);

       WebElement in=driver.findElement(By.cssSelector("input[id='loginButton']"));
       in.click();
       MyFunc.Bekle(1);

       WebElement out=driver.findElement(By.cssSelector("a[href='/openmrs/appui/header/logout.action?successUrl=openmrs']"));
       out.click();
       MyFunc.Bekle(1);
    }
    @Test
    public void list(){
        iremPOM e=new iremPOM();
        driver.get("https://openmrs.org/demo/");
        WebElement demo= driver.findElement(By.xpath("//span[text()='Enter the OpenMRS 2 Demo']"));
        demo.click();
        MyFunc.Bekle(1);

        WebElement username=driver.findElement(By.cssSelector("input[id='username']"));
        username.sendKeys("Admin");
        MyFunc.Bekle(1);

        WebElement password=driver.findElement(By.cssSelector("input[id='password']"));
        password.sendKeys("Admin123");
        MyFunc.Bekle(1);

        WebElement desk=driver.findElement(By.cssSelector("li[id='Registration Desk']"));
        desk.click();
        MyFunc.Bekle(1);

        WebElement in=driver.findElement(By.cssSelector("input[id='loginButton']"));
        in.click();
        MyFunc.Bekle(1);

        WebElement FindPatient=driver.findElement(By.cssSelector("i[class='icon-search']"));
        FindPatient.click();
        MyFunc.Bekle(1);


    }
}

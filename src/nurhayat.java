import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class nurhayat extends BaseDriver {
    @Test//(groups = {"Smoke Test"})
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


    @Test(dataProvider = "UserData")
    public void userTest(String username, String password){
             System.out.println("Geçersiz girişler listelendi: "+username+" "+password);
    }
    @DataProvider
    public Object[][] UserData(){
        Object[][] data={
                {"null","123456"},
                {"ayşe", "kanmaz"},
                {"ökkeş","kederli"},
                {"bahtsız","bahtlı"},
                {"keder","456456"},
                {"tonyy","478956"}
        };
        return data;
    }


    @Test(groups = {"Smoke Test"})
    public void test2(){
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
        Actions aksiyonDriver=new Actions(driver);
        MyFunc.Bekle(2);
        aksiyonDriver.moveToElement(account).build().perform();

        MyFunc.Bekle(2);
        account.click();
        WebElement giris = driver.findElement(By.cssSelector("[href='/openmrs/adminui/myaccount/myAccount.page']"));
        giris.click();

    }
}

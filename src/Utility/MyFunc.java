package Utility;

import org.openqa.selenium.WebElement;

import java.util.List;

public class MyFunc {

    public static void Bekle(int sn) {

        try {
            Thread.sleep(sn * 1000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int randomGenerator(int sinir) {
        return (int) (Math.random() * sinir);
    }

    public static boolean listContainsString(List<WebElement> list, String aranacakKelime) {
        boolean bulundu = false;
        for (WebElement e : list) {
            if (e.getText().toLowerCase().equals(aranacakKelime.toLowerCase())) {
                bulundu = true;
                break;
            }
        }

        return bulundu;
    }
}

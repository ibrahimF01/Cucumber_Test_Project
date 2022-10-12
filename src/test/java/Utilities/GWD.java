package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GWD {
    public static WebDriver driver;

    //Bana neler lazım:  1 browser tipi lazım burada ona göre oluşturucam
    // her bir paralel çalışan süreç için sadece o sürece özel static bir değişken lazım
    // çünkü runner classdaki işaret edilen tüm senaryolarda aynısını çalışması lazım.
    // demekki her pipeline için (Local) ve de ona özel static bir drivera ihtiyacım var
    //donanımdaki adı pipeline , yazılımdaki adı Thread , paralel çalışan her bir süreç

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>(); // WebDriver 1 WebbDriver 2
    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>(); // chrome , firefox ...

    // threadDriver.get() -> ilgili thread deki driveri verecek
    // threadDriver.set(driver) -> ilgili thread e driver set ediliyor.

    public static WebDriver getDriver() {
        // extend report türkçe bilg çalışmaması sebebiyle kondu
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        Logger.getLogger("").setLevel(Level.SEVERE);
        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");

        if (threadBrowserName.get() == null) // paralel çalışmayan yani XML den parametreyle gelmeyen ger çağıran
            threadBrowserName.set("chrome"); // Basic araynlar için


        if (threadDriver.get() == null) {

            String browserName = threadBrowserName.get(); // bu threaddeki browsername i verdi.
            switch (browserName) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    threadDriver.set(new ChromeDriver()); // bu thread e chrome istenmişşse ve yoksa bir tane ekleniyor
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    threadDriver.set(new FirefoxDriver());  // bu thread e firefox istenmişşse ve yoksa bir tane ekleniyor
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    threadDriver.set(new SafariDriver());
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    threadDriver.set(new EdgeDriver());
                    break;
            }
        }

        return threadDriver.get();
    }

    public static void quitDriver() {
        Bekle(5);

        if (threadDriver.get() != null) { // driver varsa
            threadDriver.get().quit();

            WebDriver driver = threadDriver.get();
            driver = null;
            threadDriver.set(driver); // tekrar gelirse için boş olmuş olsun
        }

    }



    public static void Bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}

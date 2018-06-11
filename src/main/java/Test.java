import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = GetWebDriver();
        driver.manage().window().maximize();

        autorize(driver);

        Thread.sleep(3000);


        String[] mainMenuItems = {
                "Dashboard",
                "Заказы", "Каталог", "Клиенты", "Служба поддержки", "Статистика",
                "Modules", "Design", "Доставка", "Способ оплаты", "International",
                "Shop Parameters", "Конфигурация"};

        for (String menuItemText: mainMenuItems) {
            System.out.printf("Check '%s' menu item. ", menuItemText);
            Optional<WebElement> item = driver.findElements(By.linkText(menuItemText))
                    .stream()
                    .filter(WebElement::isDisplayed)
                    .findFirst();
            if (!item.isPresent()) {
                System.out.printf("Menu item '%s' is not found!\n", menuItemText);
                continue;
            }

            item.get().click();
            Thread.sleep(3000);

            String PageTitle =  driver.getTitle();
            driver.navigate().refresh();
            String PageTitle1 = driver.getTitle();
            if (!PageTitle.equals(PageTitle1)){
                System.out.println("The page title is not verifyed!");
            }
            else
            System.out.println("The page title is: " + driver.getTitle());
            Thread.sleep(3000);

        }
        logOut(driver);
        Thread.sleep(3000);
        driver.quit();
        }


    private static void autorize(WebDriver driver) {
        driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        driver.findElement(By.name("email")).sendKeys("webinar.test@gmail.com");
        driver.findElement(By.name("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(By.name("submitLogin")).click();
    }
    private static void logOut(WebDriver driver) throws InterruptedException {

        driver.findElement(By.xpath("//*[@id='employee_infos']/a/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='header_logout']")).click();

    }
    
    public static WebDriver GetWebDriver() {
        System.setProperty("webdriver.chrome.driver", Test.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }



}

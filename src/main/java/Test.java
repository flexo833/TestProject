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

        List<WebElement> list = new ArrayList<WebElement>();
        WebElement dashboard = driver.findElement(By.linkText("Dashboard"));
        list.add(dashboard);
        WebElement orders= driver.findElement(By.linkText("Заказы"));
        list.add(orders);
        WebElement catalog= driver.findElement(By.linkText("Каталог"));
        list.add(catalog);
        WebElement clients= driver.findElement(By.linkText("Клиенты"));
        list.add(clients);
        WebElement support= driver.findElement(By.linkText("Служба поддержки"));
        list.add(support);
        WebElement statisticts= driver.findElement(By.linkText("Статистика"));
        list.add(statisticts);
        WebElement modules = driver.findElement(By.linkText("Modules"));
        list.add(modules);
        WebElement design = driver.findElement(By.linkText("Design"));
        list.add(design);
        WebElement delivery= driver.findElement(By.linkText("Доставка"));
        list.add(delivery);
        WebElement paymentMethod= driver.findElement(By.linkText("Способ оплаты"));
        list.add(paymentMethod);
        WebElement international= driver.findElement(By.linkText("International"));
        list.add(international);
        WebElement shopParameters = driver.findElement(By.linkText("Shop Parameters"));
        list.add(shopParameters);
        WebElement configuration= driver.findElement(By.linkText("Конфигурация"));
        list.add(configuration);


        for (WebElement button : list) {
            button.click();
            System.out.println("The page title is: " + driver.getTitle());
            driver.navigate().refresh();
            System.out.println("The page title is: " + driver.getTitle());
            Thread.sleep(3000);
        }

    }

    private static void autorize(WebDriver driver) {
        driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        driver.findElement(By.name("email")).sendKeys("webinar.test@gmail.com");
        driver.findElement(By.name("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(By.name("submitLogin")).click();
    }


    public static WebDriver GetWebDriver() {
        System.setProperty("webdriver.chrome.driver", Test.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }



}

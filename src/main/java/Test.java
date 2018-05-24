import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = GetWebDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        driver.findElement(By.name("email")).sendKeys("webinar.test@gmail.com");
        driver.findElement(By.name("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(By.name("submitLogin")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//li[@id='tab-AdminDashboard']//span")).click();
        System.out.println("The page title is: " + driver.getTitle());
        driver.navigate().refresh();
        System.out.println("The page title is: " + driver.getTitle());

        Thread.sleep(3000);

        driver.findElement(By.xpath("//li[@id='subtab-AdminParentOrders']//span")).click();
        System.out.println("The page title is: " + driver.getTitle());
        driver.navigate().refresh();
        System.out.println("The page title is: " + driver.getTitle());

        Thread.sleep(3000);

        driver.findElement(By.xpath("//li[@id='subtab-AdminCatalog']//span")).click();
        System.out.println("The page title is: " + driver.getTitle());
        driver.navigate().refresh();
        System.out.println("The page title is: " + driver.getTitle());

        Thread.sleep(3000);

        driver.findElement(By.xpath("html/body/nav/ul/li[5]/a/span")).click();
        System.out.println("The page title is: " + driver.getTitle());
        driver.navigate().refresh();
        System.out.println("The page title is: " + driver.getTitle());

        Thread.sleep(3000);



        driver.findElement(By.xpath("//li[@id='subtab-AdminParentCustomerThreads']//span")).click();
        System.out.println("The page title is: " + driver.getTitle());
        driver.navigate().refresh();
        System.out.println("The page title is: " + driver.getTitle());

        Thread.sleep(3000);

        driver.findElement(By.xpath("//li[@id='subtab-AdminStats']//span")).click();
        System.out.println("The page title is: " + driver.getTitle());
        driver.navigate().refresh();
        System.out.println("The page title is: " + driver.getTitle());

        Thread.sleep(3000);

        driver.findElement(By.xpath("//li[@id='subtab-AdminParentModulesSf']//span")).click();
        System.out.println("The page title is: " + driver.getTitle());
        driver.navigate().refresh();
        System.out.println("The page title is: " + driver.getTitle());

    }


    public static WebDriver GetWebDriver() {
        System.setProperty("webdriver.chrome.driver", Test.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }

}

package WebTest.authority;


import com.example.finclaw.FinClawApplication;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.concurrent.TimeUnit;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@SpringBootTest(classes = FinClawApplication.class)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class authorityTest {

    private static ChromeDriver browser;
    //记得需要的时候修改
    private static int port_=8000;

    private static String url="http://localhost:";

    private static String name="Hewenbing";

    private static String phoneNumber="12345678901";

    @BeforeClass
    public static void openBrowser(){
        //记得需要的时候修改
        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\chromedriver_win32\\chromedriver.exe");
        browser=new ChromeDriver();
        browser.manage().deleteAllCookies();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        url=url+port_;
    }

    @AfterClass
    public static void closeBrowser(){
        browser.quit();
    }

    private void loginAsUser(){
        browser.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("123@qq.com");
        browser.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
        browser.findElement(By.xpath("//*[@id=\"formLogin\"]/div/div[3]/div/div[4]/div/div/span/button")).click();
    }

    @Test
    public void closeAuthorityTest() throws InterruptedException {
        browser.get(url);
        browser.findElement(By.xpath("//*[@id=\"app\"]/div/section/main[1]/header/div/button[1]/span")).click();
        loginAsUser();
        Thread.sleep(100);
        browser.findElement(By.xpath("//*[@id=\"layout\"]/section/section/aside/div/ul/li[7]/a")).click();
        browser.findElement(By.xpath("//*[@id=\"layout\"]/section/section/section/main/div/div/div/div/div/div/table/tbody/tr/td[8]/span/button")).click();
        String text = browser.findElement(By.xpath("//*[@id=\"layout\"]/section/section/section/main/div/div/div/div/div/div/table/tbody/tr/td[7]")).getText();
        Assert.assertEquals("0", text);
    }
}

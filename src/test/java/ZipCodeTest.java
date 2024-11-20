import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZipCodeTest {


    @Test
    public void checkZipCode4digits() {
        WebDriver driver = new ChromeDriver(); //браузер по умолчанию chrome
        driver.get("https://www.sharelane.com/cgi-bin/register.py");//переход гна страницу
        driver.findElement(By.name("zip_code")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value='Continue']")).click();
        String errorMassage = driver.findElement(By.cssSelector(".error_message")).getText();
        Assert.assertEquals(errorMassage, "Oops, error on page. ZIP code should have 5 digits");
        driver.quit(); //закрытие браузера
    }
    @Test
    public void checkPozitiveZipCode() {
        WebDriver driver = new ChromeDriver(); //браузер по умолчанию chrome
        driver.get("https://www.sharelane.com/cgi-bin/register.py");//переход гна страницу
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value='Continue']")).click();
        boolean elementOnPage = driver.findElement(By.cssSelector("[value = 'Register']")).isDisplayed();
        Assert.assertTrue(elementOnPage);
        driver.quit(); //закрытие браузера
    }
}

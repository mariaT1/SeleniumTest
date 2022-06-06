
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Privat24 {


    @Test
    public void checkMinPaymentsSum(){
        System.setProperty("webdriver.chrome .driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://next.privat24.ua/money-transfer/card");


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();


        By numberCardOne = By.xpath("//input[@data-qa-node='numberdebitSource']");
        By dataCardOne = By.xpath("//input[@data-qa-node='expiredebitSource']");
        By cvvCardOne = By.xpath("//input[@data-qa-node='cvvdebitSource']");
        By firstNameCardOne = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
        By lastNameCardOne = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
        By numberCardTwo = By.xpath("//input[@data-qa-node='numberreceiver']");
        By firstNameCardTwo = By.xpath("//input[@data-qa-node='firstNamereceiver']");
        By lastNameCardTwo = By.xpath("//input[@data-qa-node='lastNamereceiver']");
        By amount = By.xpath("//input[@data-qa-node='amount']");
        By currency = By.xpath("//button[@data-qa-value='UAH']");
        By currencyEUR = By.xpath("//button[@data-qa-value='EUR']");
        By comment = By.xpath("//span[@data-qa-node='toggle-comment']");
        By commentEnter = By.xpath("//textarea[@data-qa-node='comment']");
        By confirButton = By.xpath("//button[@class='sc-VigVT hcHAAV']");
        By basket = By.xpath("//button[@class='sc-VigVT hcHAAV']");


        driver.findElement(numberCardOne).sendKeys("4006 8956 8904 8337");
        driver.findElement(dataCardOne).sendKeys("0323");
        driver.findElement(cvvCardOne).sendKeys("480");
        driver.findElement(firstNameCardOne).sendKeys("Ivan");
        driver.findElement(lastNameCardOne).sendKeys("Ivanov");
        driver.findElement(numberCardTwo).sendKeys("4558 0328 5584 1715");
        driver.findElement(firstNameCardTwo).sendKeys("Sasha ");
        driver.findElement(lastNameCardTwo).sendKeys("Petrov");
        driver.findElement(amount).sendKeys("300");
        driver.findElement(currency).click();
        driver.findElement(currencyEUR).click();
        driver.findElement(comment).click();
        driver.findElement(commentEnter).sendKeys("Тебе");
        driver.findElement(confirButton).click();
        driver.findElement(basket).click();


        Assertions.assertEquals("Переказ власних коштів. Тебе", driver.findElement(By.xpath("//div[@data-qa-node='details']")).getText());
        Assertions.assertEquals("4006 **** **** 8337", driver.findElement(By.xpath("//td[@data-qa-node='card']")).getText());
        Assertions.assertEquals("4558 **** **** 1715", driver.findElement(By.xpath("//span[@data-qa-node='cardB']")).getText());
        Assertions.assertEquals("300 EUR", driver.findElement(By.xpath("//div[@data-qa-node='amount']")).getText());
        Assertions.assertEquals("Про комісії", driver.findElement(By.xpath("//a[@class='sc-caSCKo gVhIWz']")).getText());




    }
}

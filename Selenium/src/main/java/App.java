import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {

    public static void main(String[] args) {
        ChromeOptions option = new ChromeOptions();
        option.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver(option);
        webDriver.get("http://localhost:3000/");

        WebElement inputUser = webDriver.findElement(By.cssSelector("#username"));
        inputUser.sendKeys("Teacher2");
        WebElement inputPass = webDriver.findElement(By.cssSelector("#password"));
        inputPass.sendKeys("User_1234");
        WebElement chkBx = webDriver.findElement(By.className("PrivateSwitchBase-input-16"));
        boolean flag2 = chkBx.isSelected();
        System.out.println(flag2);
        if (flag2)      //true
        {
            System.out.println("checkbox is already selected");
        } else  //false
        {
            System.out.println("select checkbox");
            chkBx.click();
            WebElement button = webDriver.findElement(By.cssSelector("#root > main > div.MuiPaper-root.makeStyles-paper-1.MuiPaper-elevation4.MuiPaper-rounded > form > button > span.MuiButton-label"));
            button.click();
        }
//       Test chức năng 
    }
}

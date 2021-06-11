

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;

public class App {
    private static WebDriver webDriver;

    private static int[] selects = {0, 1, 0,1};
    private static String[] inputs = {"N2", "Lập trình C","N111","Lập trình C#"};
    private static String fileWithPath = "C:\\Users\\GinPLS\\OneDrive\\Máy tính\\SQA\\Case";

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions option = new ChromeOptions();
        option.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver(option);
        webDriver.get("http://localhost:3000/");
        webDriver.manage().window().maximize();
// Login
        WebElement username = webDriver.findElement(By.xpath("//*[@id=\"username\"]"));
        username.sendKeys("Admin");
        WebElement password = webDriver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("User_1234");
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
            WebElement button = webDriver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/form/button/span[1]"));
            button.click();
            Thread.sleep(1000);
        }
// Lich su dang ky
        Thread.sleep(1000);
        WebElement click = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/ul/li[2]/div/div[1]")).findElement(By.className("MuiButtonBase-root"));
        click.click();
        Thread.sleep(1000);
        WebElement check = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/ul/li[2]/div/div[2]/div/div/div/div[2]/button/span[1]"));
        check.click();

        Thread.sleep(1000);
        TakesScreenshot scrShot =((TakesScreenshot)webDriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath + String.valueOf(00) + ".png");

        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(1000);
        webDriver.navigate().refresh();
// Tim kiem lich su dang ky voi ten nhom, ten mon
        for (int i = 0; i < inputs.length; i++)
        {
            Thread.sleep(1000);
            WebElement click1 = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/ul/li[2]/div/div[1]")).findElement(By.className("MuiButtonBase-root"));
            click1.click();
            Thread.sleep(1000);
            WebElement check1 = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/ul/li[2]/div/div[2]/div/div/div/div[2]/button/span[1]"));
            check1.click();

            Thread.sleep(1000);

            Select select = new Select(webDriver.findElements(By.xpath("//select[@class='MuiNativeSelect-root MuiNativeSelect-select MuiNativeSelect-outlined MuiInputBase-input MuiInput-input']")).get(0));
            select.selectByIndex(selects[i]);
            Thread.sleep(1000);

            WebElement clicknhap = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div"));
            clicknhap.click();
            Thread.sleep(1000);

            WebElement nhap = webDriver.findElements(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd MuiOutlinedInput-inputAdornedEnd']")).get(0);
            //WebElement nhap = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div/input"));
            nhap.sendKeys(inputs[i]);

            Thread.sleep(1000);
            WebElement timkiem = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[1]/div/div[1]/div/div[2]/div/div/button"));
            timkiem.click();
            Thread.sleep(2000);

            TakesScreenshot scrShot1 =((TakesScreenshot)webDriver);
            File SrcFile1=scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile1=new File(fileWithPath + String.valueOf(i) + ".png");

            try {
                FileUtils.copyFile(SrcFile, DestFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Thread.sleep(2000);

            webDriver.navigate().refresh();
            if(i== inputs.length){
                break;
            }
        }

        Thread.sleep(1000);
        WebElement click1 = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/ul/li[4]/div/div[1]")).findElement(By.className("MuiButtonBase-root"));
        click.click();
        Thread.sleep(1000);
        WebElement check1 = webDriver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[2]/div[2]/div/ul/li[4]/div/div[2]/div/div/div/div[2]/button"));
        check.click();

        Thread.sleep(1000);
        TakesScreenshot scrShot2 =((TakesScreenshot)webDriver);
        File SrcFile2=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile2=new File(fileWithPath + String.valueOf(6) + ".png");

        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(1000);
        webDriver.navigate().refresh();
    }
}

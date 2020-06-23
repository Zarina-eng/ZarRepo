package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
public class BrowserUtils {
    public static void switchWindowByTitle(WebDriver driver, String targetTitle) {
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!driver.getTitle().equals(targetTitle)) {
                driver.switchTo().window(id);
            }
        }
    }

    public static void switchWindowByUrl(WebDriver driver, String url) {
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!driver.getCurrentUrl().contains(url)) {
                driver.switchTo().window(id);
            }
        }
    }

    public static void closeWindows(WebDriver driver, String parentId) {
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!id.equals(parentId)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
    }

    //Create a method for Fluent Wait
    public static WebElement fluentWait(WebDriver driver, long totalSec, long pollingEverySec, By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(totalSec))
                .pollingEvery(Duration.ofSeconds(pollingEverySec))
                .ignoring(RuntimeException.class);
        return wait.until(driver1 -> driver.findElement(locator));
    }

    public static WebElement visibilityOf(WebDriver driver, int timeInSecond, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSecond);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    //                public static WebElement visibilityOfElementLocated (WebDriver driver,int timeInSecond,By locator){
//                    WebDriverWait wait=new WebDriverWait(driver,timeInSecond);
//                    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//                }
    public static WebElement visibilityofElementLocated(WebDriver driver, int timeInSecond, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSecond);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static String takeScreenShot() throws IOException {
        //First we cast driver to TakeScreenShot
        //W get the screenShot as FILE

        File src = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);

        //We need the destiantion to store all my screenshot
        //System.getProperty("user.dir")will give the project location
        // String destination=System.getProperty("user.dir")+"\\Screenshot\"
        //"+System.currentTimeMillis()-->helps us to give unique name for my screenshot

        String destination = System.getProperty("user.dir") + "/ScreenShot/" + System.currentTimeMillis() + ".png";
        File des = new File(destination);
        try {
            //copyFile will get the file from source and store to the destination
            FileUtils.copyFile(src, des);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destination;
    }

    public static String todaysDate(String formatType) {
        LocalDate today = LocalDate.now();//(2021-05-26)
        DateTimeFormatter newformat = DateTimeFormatter.ofPattern(formatType);
        return newformat.format(today);
    }


    public static void switchFrameByIndex(WebDriver driver, int index) {
        driver.switchTo().frame(index);

    }

    public static void switchByElement(WebDriver driver, By locator) {
        driver.switchTo().frame(driver.findElement(locator));
    }

    public static void switchWebElement(WebDriver driver, WebElement element) {
        driver.switchTo().frame((element));
    }

    public static List<String> getTextOfWebElement(List<WebElement> lists) {

        List<String> text = new ArrayList<>();
        for (WebElement list : lists) {
            text.add(list.getText().trim());
        }
        return text;
    }
}
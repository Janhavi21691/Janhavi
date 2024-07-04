package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static  void main(String[] args) throws MalformedURLException, InterruptedException{
        DesiredCapabilities dc=new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Janhavi");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"14");
        dc.setCapability("appPackage","com.vivo.calculator");
        dc.setCapability("appActivity","com.vivo.calculator.Calculator");
        URL url=new URL("http://127.0.0.1:4723");
        AndroidDriver driver;
        driver = new AndroidDriver(url, dc);
        Thread.sleep(5000);

        WebElement CLEAR_OPTION=driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Clear\"]"));

        //sum of two numbers(9+5=14)
        WebElement NUM_9=driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id=\"com.vivo.calculator:id/digit_9\"]"));
        NUM_9.click();

        WebElement PLUS=driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Plus\"]"));
        PLUS.click();


        WebElement Num_5=driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id=\"com.vivo.calculator:id/digit_5\"]"));
        Num_5.click();


        WebElement EQUALS=driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"=\"]"));
        EQUALS.click();

        WebElement RESULT=driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"com.vivo.calculator:id/formula\"]"));
        String OUTPUT_SUM=RESULT.getText();

        System.out.println("sum of two numbers is "+OUTPUT_SUM);

        CLEAR_OPTION.click();

        //Subtract 2 numbers (8-3=5)

        WebElement NUM_8=driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id=\"com.vivo.calculator:id/digit_8\"]"));
        NUM_8.click();

        WebElement SUBSTRACT=driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Minus\"]"));
        SUBSTRACT.click();

        WebElement Num_3=driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id=\"com.vivo.calculator:id/digit_3\"]"));
        Num_3.click();

        EQUALS.click();

        String OUTPUT_DIFF=RESULT.getText();
        System.out.println("difference of two numbers is "+OUTPUT_DIFF);

        CLEAR_OPTION.click();

        //multiply Result of Sum and Subtraction (14*5=70)

        int OUTPUT_MUL=(Integer.parseInt(OUTPUT_SUM))*(Integer.parseInt(OUTPUT_DIFF));
        System.out.println("product of sum and diff of two numbers is  "+OUTPUT_MUL);

        CLEAR_OPTION.click();

        //Divide the result of multiplication with 10 (70/10=7)

        int OUTPUT_DIV=OUTPUT_MUL/10;
        System.out.println("Division result is "+OUTPUT_DIV);

        CLEAR_OPTION.click();

        //Solve this series (100+200-100*2/5)

        WebElement NUM_0=driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id=\"com.vivo.calculator:id/digit_0\"]"));
        WebElement NUM_1=driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id=\"com.vivo.calculator:id/digit_1\"]"));
        WebElement NUM_2=driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id=\"com.vivo.calculator:id/digit_2\"]"));
        WebElement MUL=driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Multiply\"]"));
        WebElement DIV=driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Divide\"]"));
        NUM_1.click();
        NUM_0.click();
        NUM_0.click();
        PLUS.click();
        NUM_2.click();
        NUM_0.click();
        NUM_0.click();
        EQUALS.click();
        SUBSTRACT.click();
        NUM_1.click();
        NUM_0.click();
        NUM_0.click();
        EQUALS.click();
        MUL.click();
        NUM_2.click();
        EQUALS.click();
        DIV.click();
        Num_5.click();
        EQUALS.click();
        String FINAL_RESULT=RESULT.getText();
        System.out.println("the solution of series is "+FINAL_RESULT);
        driver.quit();
    }
}
package com.ip.grid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;

public class Client {

    private static WebDriver webDriver;

    @Parameters("browser")
    @BeforeTest
    public void launchBrowser(String browser) throws MalformedURLException {

        if (browser.equalsIgnoreCase("firefox")) {

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setBrowserName("firefox");
            desiredCapabilities.setPlatform(Platform.WINDOWS);

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.merge(desiredCapabilities);

            String hubURL = "http://192.168.56.1:4444/wd/hub";
            webDriver = new RemoteWebDriver(new URL(hubURL), chromeOptions);
            webDriver.get("http://www.freecrm.com");

        } else if (browser.equalsIgnoreCase("chrome")) {

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setBrowserName("chrome");
            desiredCapabilities.setPlatform(Platform.WINDOWS);

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.merge(desiredCapabilities);

            String hubURL = "http://192.168.56.1:4444/wd/hub";
            webDriver = new RemoteWebDriver(new URL(hubURL), chromeOptions);
            webDriver.get("http://www.facebook.com");
        }

    }

    @Test
    public void doTest() {

        System.out.println(webDriver.getTitle());
    }


}

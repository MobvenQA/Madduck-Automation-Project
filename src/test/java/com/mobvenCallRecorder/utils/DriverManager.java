package com.mobvenCallRecorder.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    private static AppiumDriver driver;
    private static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub";

    public static AppiumDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    private static void initializeDriver() {
        XCUITestOptions options = new XCUITestOptions()
                .setDeviceName("iPhone xs max")
                .setAutomationName("XCUITest")
                .setPlatformName("iOS")
                .setPlatformVersion("18.4.1")
                .setBundleId("com.madduck.callrecorder")
                .setNoReset(true)   // kaldırılacak denildi hakan abi
                .setUdid("00008020-001274263450003A")
                .setIncludeSafariInWebviews(true)
                .setNewCommandTimeout(Duration.ofSeconds(3600))
                .setConnectHardwareKeyboard(true);

        // Xcode capabilities
        Map<String, Object> xcodeCapabilities = new HashMap<>();
        xcodeCapabilities.put("xcodeOrgId", "Y73A7DV5T6");
        xcodeCapabilities.put("xcodeSigningId", "iPhone Developer");
        options.setCapability("xcodeCapabilities", xcodeCapabilities);

        try {
            driver = new IOSDriver(new URL(APPIUM_SERVER_URL), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // 5'e düşürülecek
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to initialize Appium driver", e);
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

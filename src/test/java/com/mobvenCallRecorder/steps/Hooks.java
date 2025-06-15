package com.mobvenCallRecorder.steps;

import com.mobvenCallRecorder.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp() {
        System.out.println("Test başlıyor...");
        // Driver'ı başlat ve uygulamayı aç
        DriverManager.getDriver();
        System.out.println("Uygulama başlatıldı.");
    }

    @After
    public void tearDown(Scenario scenario) {
        // Test başarısız olduğunda ekran görüntüsü al
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        // Driver'ı kapat
        DriverManager.quitDriver();
        System.out.println("Test tamamlandı.");
    }
}

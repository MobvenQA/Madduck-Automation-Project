package com.mobvenCallRecorder.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.mobvenCallRecorder.utils.DriverManager;
import java.time.Duration;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.Pause;
import java.util.Collections;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import com.mobvenCallRecorder.pages.TapPoint;
import org.openqa.selenium.By;
import java.util.List;

public class BasePage {
    protected AppiumDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
    /**
     * Generic method to check if element is displayed
     * @param element WebElement to check
     * @return boolean indicating if element is displayed
     */
    public static boolean isDisplayed(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            boolean displayed = element.isDisplayed();
            System.out.println("Element görünür durumda: " + element + " - " + displayed);
            return displayed;
        } catch (Exception e) {
            System.out.println("Element görünür değil: " + element);
            System.out.println("Hata mesajı: " + e.getMessage());
            return false;
        }
    }

    public static void waitForElement(By locator, int timeoutInSeconds) {
        long timeout = System.currentTimeMillis() + (timeoutInSeconds * 1000L);
        int interval = 500; // her 0.5 saniyede bir dene

        while (System.currentTimeMillis() < timeout) {
            try {
                WebElement element = DriverManager.getDriver().findElement(locator);
                if (element.isDisplayed()) {
                    element.click();
                    System.out.println(" Element bulundu: " + locator);
                    return;
                }
            } catch (Exception ignored) {
                // element henüz yoksa hata vermesin, beklemeye devam etsin
            }

            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(" Bekleme sırasında kesildi", e);
            }
        }

        // timeout bittiğinde hala bulunamadıysa
        String message = ":x: Element " + locator + " belirtilen sürede bulunamadı: " + timeoutInSeconds + " saniye";
        System.err.println(message);
        throw new RuntimeException(message);
    }
    /**
     * Wait for specified number of seconds
     * @param seconds Number of seconds to wait
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
            System.out.println(seconds + " saniye beklendi");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Bekleme sırasında hata oluştu: " + e.getMessage());
        }
    }
    /**
     * Check if element is clickable
     * @param element WebElement to check
     * @return boolean indicating if element is clickable
     */
    public static boolean isClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            System.out.println("Element tıklanabilir durumda: " + element);
            return true;
        } catch (Exception e) {
            System.out.println("Element tıklanabilir değil: " + element);
            System.out.println("Hata mesajı: " + e.getMessage());
            return false;
        }
    }
    // Ortak kullanılacak metodlar buraya eklenebilir
    protected void waitForElementToBeVisible() {
        // Element görünür olana kadar bekleme işlemleri
    }

    protected void waitForElementToBeClickable() {
        // Element tıklanabilir olana kadar bekleme işlemleri
    }

    /**
     * Verilen x ve y koordinatına dokunma işlemi yapar
     */
    public static void forceClickAt(int x, int y) {
        try {
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence tap = new Sequence(finger, 1);
            tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
            tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            tap.addAction(new Pause(finger, Duration.ofMillis(10)));
            tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            DriverManager.getDriver().perform(Collections.singletonList(tap));
            System.out.println("Koordinata tıklandı: x=" + x + ", y=" + y);
        } catch (Exception e) {
            System.out.println("Koordinata tıklanırken hata oluştu: " + e.getMessage());
        }
    }

    /**
     * Enum ile isimli koordinata tıklama
     */
    public static void forceClick(TapPoint point) {
        forceClickAt(point.getX(), point.getY());
    }

    /**
     * Bir elementi sağa veya sola kaydırır (slide/swipe)
     * @param element WebElement
     * @param direction "RIGHT" veya "LEFT"
     * @param distance piksel cinsinden mesafe
     */
    public static void slideElement(WebElement element, String direction, int distance) {
        try {
            // Elementin orta noktası
            Point location = element.getLocation();
            Dimension size = element.getSize();
            int startX = location.getX() + size.getWidth() / 2;
            int startY = location.getY() + size.getHeight() / 2;

            int endX = startX;
            int endY = startY;

            if ("RIGHT".equalsIgnoreCase(direction)) {
                endX = startX + distance;
            } else if ("LEFT".equalsIgnoreCase(direction)) {
                endX = startX - distance;
            } else {
                throw new IllegalArgumentException("Yön sadece RIGHT veya LEFT olabilir!");
            }

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            DriverManager.getDriver().perform(Collections.singletonList(swipe));
            System.out.println("Elemente " + direction + " yönünde kaydırma yapıldı.");
        } catch (Exception e) {
            System.out.println("Slide işlemi sırasında hata oluştu: " + e.getMessage());
        }
    }

    public static Boolean elementExists(By selector) {
        try {
            List<WebElement> elementlist = DriverManager.getDriver().findElements(selector);
            return (!elementlist.isEmpty());
        } catch (Exception e) {
            System.out.println("Element arama hatası: " + e.getMessage());
            return false;
        }
    }

    /**
     * Ekrandaki elementlerin detaylarını yazdırır
     */
    public static void printAllElementsInfo() {
        try {
            List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//*"));
            System.out.println("=== EKRAN ELEMENTLERİ ===");
            System.out.println("Toplam element sayısı: " + elements.size());

            for (int i = 0; i < elements.size(); i++) {
                WebElement element = elements.get(i);
                try {
                    String tagName = element.getTagName();
                    String text = element.getText();
                    String name = element.getAttribute("name");
                    String accessibilityId = element.getAttribute("accessibility-id");
                    boolean isDisplayed = element.isDisplayed();
                    boolean isEnabled = element.isEnabled();

                    System.out.println((i+1) + ". Element:");
                    System.out.println("   Tag: " + tagName);
                    System.out.println("   Text: " + text);
                    System.out.println("   Name: " + name);
                    System.out.println("   AccessibilityId: " + accessibilityId);
                    System.out.println("   Displayed: " + isDisplayed);
                    System.out.println("   Enabled: " + isEnabled);
                    System.out.println("   ----");
                } catch (Exception e) {
                    System.out.println((i+1) + ". Element bilgisi alınamadı: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Element listesi alınamadı: " + e.getMessage());
        }
    }


    /**
     * Elementi 30 saniye boyunca arar, bulur ve tıklar
     * @param locator By locator to find and click
     */
    public static void waitAndClickTwo(By locator) {
        waitAndClick(locator, 30);
    }

    /**
     * Elementi belirtilen süre boyunca arar, bulur ve tıklar
     * @param locator By locator to find and click
     * @param timeout saniye cinsinden bekleme süresi
     */
    public static void waitAndClick(By locator, int timeout) {
        try {
            System.out.println("Element aranıyor " + timeout + " saniye boyunca: " + locator);
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));

            // Önce elementin var olmasını bekle
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

            // Sonra görünür olmasını bekle
//            wait.until(ExpectedConditions.visibilityOf(element));

            // Son olarak tıklanabilir olmasını bekle
//            wait.until(ExpectedConditions.elementToBeClickable(element));

            // Tıkla
            element.click();
            System.out.println("Element başarıyla bulundu ve tıklandı: " + locator);

        } catch (Exception e) {
            System.out.println("Element " + timeout + " saniye içinde bulunamadı veya tıklanamadı: " + locator);
            System.out.println("Hata mesajı: " + e.getMessage());

            // Alternatif olarak koordinat tıklama dene (eğer bilinen koordinatlar varsa)
            try {
                System.out.println("JavaScript ile tıklama deneniyor...");
                WebElement element = DriverManager.getDriver().findElement(locator);
                ((AppiumDriver) DriverManager.getDriver()).executeScript("arguments[0].click();", element);
                System.out.println("JavaScript ile tıklama başarılı");
            } catch (Exception jsEx) {
                System.out.println("JavaScript ile tıklama da başarısız: " + jsEx.getMessage());
                throw e;
            }
        }
    }

    /**
     * Element var olana kadar polling ile kontrol eder
     * @param locator By locator
     * @param timeout saniye cinsinden timeout
     * @param pollingInterval saniye cinsinden kontrol aralığı
     * @return element bulunursa true
     */
    public static boolean waitForElementWithPolling(By locator, int timeout, int pollingInterval) {
        long startTime = System.currentTimeMillis();
        long timeoutMs = timeout * 1000L;

        while ((System.currentTimeMillis() - startTime) < timeoutMs) {
            try {
                List<WebElement> elements = DriverManager.getDriver().findElements(locator);
                if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
                    System.out.println("Element bulundu (polling): " + locator);
                    return true;
                }
            } catch (Exception e) {
                // Devam et
            }

            try {
                Thread.sleep(pollingInterval * 1000L);
                System.out.println("Element aranıyor... (" + ((System.currentTimeMillis() - startTime) / 1000) + "s)");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println("Element " + timeout + " saniye sonunda bulunamadı: " + locator);
        return false;
    }

    /**
     * Element bulana kadar bekler ve sonra tıklar (polling yöntemi ile)
     * @param locator By locator
     * @param timeout saniye cinsinden timeout (default 30)
     */
    public static void waitAndClickWithPolling(By locator, int timeout) {
        if (waitForElementWithPolling(locator, timeout, 2)) { // 2 saniyede bir kontrol et
            try {
                WebElement element = DriverManager.getDriver().findElement(locator);
                element.click();
                System.out.println("Element polling ile bulundu ve tıklandı: " + locator);
            } catch (Exception e) {
                System.out.println("Element bulundu ama tıklanamadı: " + e.getMessage());
            }
        }
    }

    /**
     * Text field'a metin yazar
     * @param locator By locator of text field
     * @param text Text to enter
     */
    public static void sendKeys(By locator, String text) {
        try {
            System.out.println("Text yazılıyor: " + locator + " -> " + text);
            
            // Element'i bul
            WebElement textField = DriverManager.getDriver().findElement(locator);
            
            // Önce temizle
            textField.clear();
            
            // Text'i yaz
            textField.sendKeys(text);
            
            System.out.println("Text başarıyla yazıldı: " + text);
            
        } catch (Exception e) {
            System.out.println("Text yazılamadı: " + locator + " -> " + text);
            System.out.println("Hata mesajı: " + e.getMessage());
            throw e;
        }
    }
}

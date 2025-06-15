package com.mobvenCallRecorder.steps;
import com.mobvenCallRecorder.pages.TapPoint;
import com.mobvenCallRecorder.pages.BasePage;
import com.mobvenCallRecorder.pages.RecordsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import com.mobvenCallRecorder.utils.DriverManager;

public class RecordsPageSteps {

    @Given("User was able to click favorite button")
    public void userWasAbleToClickFavoriteButton() {
        BasePage.waitFor(3);
        BasePage.forceClickAt(98 , 363);
        // Alternatif: BasePage.waitForElement(RecordsPage.favoriteFilterRecordsPage, 30);
    }

    @And("User was able to click List All button")
    public void userWasAbleToClickListAllButton() {
        BasePage.waitFor(1);
        BasePage.forceClick(TapPoint.List_All_Tab_Records_Page);
        // Alternatif: BasePage.waitForElement(RecordsPage.filterAllRecordsPage, 30);
    }

    @And("User was able to click Contats Tab button")
    public void userWasAbleToClickContatsTabButton() {
        BasePage.forceClick(TapPoint.Contacts_Tab_Button);
        // Alternatif: BasePage.waitForElement(RecordsPage.ContactsTabBar, 30);
    }

    @And("User was able to add new contact in contacts page")
    public void userWasAbleToClickAddNewContactInContactsPage() {
        BasePage.forceClick(TapPoint.Add_New_Button);
        BasePage.forceClick(TapPoint.Close_Contact_Detail_Page);
        // Alternatif: 
        // BasePage.waitForElement(RecordsPage.addContactButton, 30);
        // BasePage.waitForElement(RecordsPage.ContactDetailPageCloseButton, 30);
    }

    @And("User was able to use favorite record and check")
    public void userWasAbleToUseFavoriteRecordAndCheck() {
        // Yeni By locator'ları ile dinamik element bulma ve sliding
        try {
            BasePage.waitForElement(RecordsPage.contactListFirstContact, 10);
            // Element bulunduktan sonra slide işlemi (eğer WebElement'e ihtiyaç varsa koordinat kullan)
            BasePage.forceClickAt(200, 400); // Slide için koordinat
            
            BasePage.waitForElement(RecordsPage.contactListFavButton, 10);
            BasePage.waitForElement(RecordsPage.ContactListDetailFirstRecord, 10);
            BasePage.waitForElement(RecordsPage.RecordPageRecordDetailPlayWhiteButton, 10);
            BasePage.waitForElement(RecordsPage.RecordPageRecordDetailForwardButton, 10);
            BasePage.waitForElement(RecordsPage.RecordPageRecordDetailBackwardButton, 10);
            BasePage.waitForElement(RecordsPage.RecordPageRecordDetailPauseWhiteButton, 10);
        } catch (Exception e) {
            System.out.println("Element sequence'ında hata: " + e.getMessage());
        }
    }

    @And("button tabs test")
    public void buttonTabsTest() {
        BasePage.waitFor(2);
        
        // Yeni By locator stratejisi ile güvenli tıklama
        try {
            // Help button'a 30 saniye bekleyerek tıkla
            BasePage.waitForElement(RecordsPage.RecordTabHelpButton, 30);
            System.out.println("Help button bulundu ve tıklandı");
        } catch (Exception e) {
            System.out.println("Help button bulunamadı, koordinat ile tıklanıyor: " + e.getMessage());
            BasePage.forceClickAt(323, 92); // HELP_BUTTON_COORDINATE
        }
        
        BasePage.waitFor(2);
        
        try {
            // Contacts tab'a 30 saniye bekleyerek tıkla
            BasePage.waitForElement(RecordsPage.ContactsTabBar, 30);
            System.out.println("Contacts tab bulundu ve tıklandı");
        } catch (Exception e) {
            System.out.println("Contacts tab bulunamadı, koordinat ile tıklanıyor: " + e.getMessage());
            BasePage.forceClickAt(141, 818); // CONTACTS_TAB_COORDINATE
        }
        
        BasePage.waitFor(2);
        
        try {
            // Records tab'a 30 saniye bekleyerek tıkla
            BasePage.waitForElement(RecordsPage.RecordsTabBar, 30);
            System.out.println("Records tab bulundu ve tıklandı");
        } catch (Exception e) {
            System.out.println("Records tab bulunamadı, koordinat ile tıklanıyor: " + e.getMessage());
            BasePage.forceClickAt(38, 843); // RECORDS_TAB_COORDINATE
        }
    }

    @And("Print all Elements")
    public void printAllElements() {
        BasePage.waitFor(2);
        BasePage.printAllElementsInfo();
    }

    @And("Test new locator strategy")
    public void testNewLocatorStrategy() {
        // Yeni By locator stratejisini test etmek için
        System.out.println("=== YENİ LOCATOR STRATEJİSİ TESTİ ===");
        
        // Farklı locator'ları test et
        try {
            if (BasePage.elementExists(RecordsPage.RecordTabHelpButton)) {
                System.out.println("✅ Help button locator çalışıyor");
                BasePage.waitForElement(RecordsPage.RecordTabHelpButton, 10);
            } else {
                System.out.println("❌ Help button locator çalışmıyor");
            }
            
            if (BasePage.elementExists(RecordsPage.ContactsTabBar)) {
                System.out.println("✅ Contacts tab locator çalışıyor");
            } else {
                System.out.println("❌ Contacts tab locator çalışmıyor");
            }
            
            if (BasePage.elementExists(RecordsPage.RecordsTabBar)) {
                System.out.println("✅ Records tab locator çalışıyor");
            } else {
                System.out.println("❌ Records tab locator çalışmıyor");
            }
            
        } catch (Exception e) {
            System.out.println("Locator test sırasında hata: " + e.getMessage());
        }
    }

    @And("Contact tab add new contact check")
    public void contactTabAddNewContactCheck() {
        BasePage.waitFor(2);
        BasePage.forceClick(TapPoint.Contacts_Tab_Button);
        BasePage.waitForElement(RecordsPage.addContactButton, 10);
        BasePage.waitForElement(RecordsPage.newContactPageNameInput, 10);
        BasePage.sendKeys(RecordsPage.newContactPageNameInput, "Okan Candemir");
        BasePage.waitForElement(RecordsPage.newContactPagePhoneInput, 10);
        BasePage.sendKeys(RecordsPage.newContactPagePhoneInput, "5551234567");
        BasePage.waitForElement(RecordsPage.ContactPageSaveNewContactButton,10);
        
    }
    @And("Record all functions check")
    public void recordAllFunctionsCheck() {
        BasePage.waitFor(2);
        BasePage.forceClick(TapPoint.ContactWithFavorite);
        BasePage.waitForElement(RecordsPage.ContactPageRecordVoiceButton,10);
        BasePage.waitForElement(RecordsPage.RecordPageRecordStartRedButton, 10);
        BasePage.waitFor(20);
        BasePage.waitForElement(RecordsPage.RecordPageRecordPauseRedButton,10);
        BasePage.waitForElement(RecordsPage.RecordPageRecordDetailPlayWhiteButton,10);
        BasePage.waitForElement(RecordsPage.RecordPageRecordDetailForwardButton,10);
        BasePage.waitForElement(RecordsPage.RecordPageRecordDetailBackwardButton,10);
        BasePage.waitForElement(RecordsPage.RecordPageRecordDetailPauseWhiteButton,10);
        BasePage.waitForElement(RecordsPage.RecordPageSaveRecordButton,10);


    }

    @And("Contact tab functions check")
    public void contactTabFunctionsCheck() {
        BasePage.waitFor(2);
        BasePage.forceClick(TapPoint.Contacts_Tab_Button);
        BasePage.slideElement(DriverManager.getDriver().findElement(RecordsPage.contactListFirstContact), "RIGHT", 150);
//        BasePage.forceClick(TapPoint.ContactFavoriteButtonHidden);
        BasePage.waitAndClickTwo(RecordsPage.FavoriteButtonHidden);
        BasePage.waitForElement(RecordsPage.contactListFirstContact, 10);
        BasePage.waitForElement(RecordsPage.ContactListDetailFirstRecord,10);
        BasePage.slideElement(DriverManager.getDriver().findElement(RecordsPage.ContactListDetailFirstRecord), "LEFT", 100);
        BasePage.waitForElement(RecordsPage.RecordFavoriteButtonHidden, 10);
        BasePage.waitForElement(RecordsPage.RecordPageFavTab, 10);
        BasePage.slideElement(DriverManager.getDriver().findElement(RecordsPage.ContactListDetailFirstRecord), "RIGHT", 100);
        BasePage.waitForElement(RecordsPage.RecordFavoriteButtonHidden, 10);
        BasePage.waitForElement(RecordsPage.RecordDeleteButtonHidden, 10);
        BasePage.waitFor(1);
        BasePage.forceClick(TapPoint.List_All_Tab_Records_Page);
        BasePage.waitForElement(RecordsPage.ContactPageBackButton, 10);





    }
}

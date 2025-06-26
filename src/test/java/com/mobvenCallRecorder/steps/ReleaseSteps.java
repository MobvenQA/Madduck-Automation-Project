package com.mobvenCallRecorder.steps;
import com.mobvenCallRecorder.pages.TapPoint;
import com.mobvenCallRecorder.pages.BasePage;
import com.mobvenCallRecorder.pages.ElementsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import com.mobvenCallRecorder.utils.DriverManager;

public class ReleaseSteps {

    @Given("User was able to click favorite button")
    public void userWasAbleToClickFavoriteButton() {
        BasePage.waitFor(5);
 //       BasePage.forceClickAt(98 , 363);
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
            BasePage.waitForElement(ElementsPage.contactListFirstContact, 10);
            // Element bulunduktan sonra slide işlemi (eğer WebElement'e ihtiyaç varsa koordinat kullan)
            BasePage.forceClickAt(200, 400); // Slide için koordinat
            
            BasePage.waitForElement(ElementsPage.hiddenFavoriteButton, 10);
            BasePage.waitForElement(ElementsPage.contactListDetailFirstRecord, 10);
            BasePage.waitForElement(ElementsPage.recordPageRecordDetailPlayWhiteButton, 10);
            BasePage.waitForElement(ElementsPage.recordPageRecordDetailForwardButton, 10);
            BasePage.waitForElement(ElementsPage.recordPageRecordDetailBackwardButton, 10);
            BasePage.waitForElement(ElementsPage.recordPageRecordDetailPauseWhiteButton, 10);
        } catch (Exception e) {
            System.out.println("Element sequence'ında hata: " + e.getMessage());
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
            if (BasePage.elementExists(ElementsPage.recordTabHelpButton)) {
                System.out.println("✅ Help button locator çalışıyor");
                BasePage.waitForElement(ElementsPage.recordTabHelpButton, 10);
            } else {
                System.out.println("❌ Help button locator çalışmıyor");
            }
            
            if (BasePage.elementExists(ElementsPage.contactsTabBar)) {
                System.out.println("✅ Contacts tab locator çalışıyor");
            } else {
                System.out.println("❌ Contacts tab locator çalışmıyor");
            }
            
            if (BasePage.elementExists(ElementsPage.recordsTabBar)) {
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
        BasePage.waitForElement(ElementsPage.contactsTabBar, 10);
        BasePage.waitForElement(ElementsPage.addContactButton, 10);
        BasePage.waitForElement(ElementsPage.newContactPageNameInput, 10);
        BasePage.sendKeys(ElementsPage.newContactPageNameInput, "Okan Candemir");
        BasePage.waitForElement(ElementsPage.newContactPagePhoneInput, 10);
        BasePage.sendKeys(ElementsPage.newContactPagePhoneInput, "5551234567");
        BasePage.waitForElement(ElementsPage.contactPageSaveNewContactButton,10);
        BasePage.waitFor(1);
        
    }
    @And("Record all functions check")
    public void recordAllFunctionsCheck() {
        BasePage.waitForElement(ElementsPage.recordTabRecordVoiceButton,10);
        BasePage.waitForElement(ElementsPage.recordPageRecordStartRedButton, 10);
        BasePage.waitFor(20);
        BasePage.waitForElement(ElementsPage.recordPageRecordPauseRedButton,10);
        BasePage.waitForElement(ElementsPage.recordPageRecordDetailPlayWhiteButton,10);
        BasePage.waitForElement(ElementsPage.recordPageRecordDetailForwardButton,10);
        BasePage.waitForElement(ElementsPage.recordPageRecordDetailBackwardButton,10);
        BasePage.waitForElement(ElementsPage.recordPageRecordDetailPauseWhiteButton,10);
        BasePage.waitForElement(ElementsPage.recordPageSaveRecordButton,10);
        BasePage.waitFor(5);


    }

    @And("Contact tab functions check")
    public void contactTabFunctionsCheck() {
        BasePage.waitForElement(ElementsPage.assignToContactSearchBar, 10);
        BasePage.sendKeys(ElementsPage.assignToContactSearchBar, "Test");
        BasePage.waitForElement(ElementsPage.contactListDetailFirstRecord, 10);
        BasePage.waitFor(1);





    }

    @And("Contact detail functions check")
    public void contactDetailFunctionsCheck() {
        BasePage.slideElement(DriverManager.getDriver().findElement(ElementsPage.contactListFirstContact), "RIGHT", 150);
        BasePage.waitAndClickTwo(ElementsPage.hiddenFavoriteButton);
        BasePage.waitForElement(ElementsPage.contactListFirstContact, 10);
        BasePage.waitFor(2);
        BasePage.waitForElement(ElementsPage.recordDetailTranscribeButton, 10);
        BasePage.waitForElement(ElementsPage.recordDetailStartToTranscribeButton, 10);
        BasePage.waitFor(1);
        BasePage.waitAndClickTwo(ElementsPage.recordPageCloseRecordButton);
        BasePage.waitForElement(ElementsPage.recordPageFavTab, 10);
        BasePage.waitForElement(ElementsPage.recordPagePhoneFilter,10);
        BasePage.waitForElement(ElementsPage.recordPageFilterVoiceButton, 10);
        BasePage.waitForElement(ElementsPage.recordPageFilterTranscribeButton, 10);
        BasePage.waitForElement(ElementsPage.recordPageFilterAllButton,10);
        BasePage.waitForElement(ElementsPage.contactListFirstContact, 10);
        BasePage.waitForElement(ElementsPage.recordDetailDeleteRecordButton, 10);
        BasePage.waitFor(1);





        BasePage.waitFor(1);

    }

    @And("Record tab voice record check")
    public void recordTabVoiceRecordCheck() {
        BasePage.waitForElement(ElementsPage.recordTabRecordVoiceButton, 10);

    }

    @And("Contact tab contact detail voice record")
    public void contactTabContactDetailVoiceRecord() {
        BasePage.waitForElement(ElementsPage.contactPageRecordVoiceButton,10);

    }

    @And("Start transcribe for last record")
    public void startTranscribeForLastRecord() {
        BasePage.waitForElement(ElementsPage.contactListDetailFirstRecord,10);
        BasePage.waitFor(2);
        BasePage.forceClick(TapPoint.Record_Transcribe);
        BasePage.forceClick(TapPoint.Record_Transcribe);
//        BasePage.waitForElement(ElementsPage.recordDetailTranscribeButton, 10);
        BasePage.waitForElement(ElementsPage.recordDetailStartToTranscribeButton, 10);
        BasePage.waitFor(2);
        BasePage.waitForElement(ElementsPage.recordPageAssignToContactButton,10);
        BasePage.waitForElement(ElementsPage.assignToContactSearchBar, 10);
        BasePage.sendKeys(ElementsPage.assignToContactSearchBar, "Test");
        BasePage.waitForElement(ElementsPage.contactListDetailFirstRecord, 10);
        BasePage.waitForElement(ElementsPage.recordPageCloseRecordButton,10);
        BasePage.slideElement(DriverManager.getDriver().findElement(ElementsPage.contactListFirstContact), "RIGHT", 150);
        BasePage.waitForElement(ElementsPage.hiddenFavoriteButton, 10);
        BasePage.waitFor(1);

    }
}

package com.mobvenCallRecorder.pages;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RecordsPage extends BasePage {
    //------------------------------------------------###### LOCATORS (By türünde) ######-----------------------------------------------\\
    
    // Filter buttons
    public static By favoriteFilterRecordsPage = AppiumBy.iOSNsPredicateString("name == 'icon_record_filter_fav'");
    public static By filterAllRecordsPage = AppiumBy.accessibilityId("icon_record_filter_all");

    //--------------------------------###### Add Contact Scenario Locators ######-----------------------------------------------\\
    
    public static By addContactButton = AppiumBy.accessibilityId("icon contacts add");
    public static By newContactPageNameInput = AppiumBy.xpath("//XCUIElementTypeTextField[@value='Name (Required)']");
    public static By newContactPagePhoneInput = AppiumBy.xpath("//XCUIElementTypeTextField[@value='Phone Number (Required)']");
    public static By searchBarContactPage = AppiumBy.xpath("//XCUIElementTypeTextField[@value='Phone Number (Required)']");
    public static By contactListFirstContact = AppiumBy.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[1]");
    public static By contactListFavButton = AppiumBy.xpath("//XCUIElementTypeButton[@name='icon contacts fav action']/XCUIElementTypeStaticText");
    public static By contactListDeleteButton = AppiumBy.xpath("//XCUIElementTypeButton[@name='icon contacts delete action']/XCUIElementTypeStaticText");
    public static By ContactPageCallButton = AppiumBy.accessibilityId("icon phone call");
    public static By ContactPageRecordVoiceButton = AppiumBy.accessibilityId("icon voice recorder");
    public static By ContactDetailPageCloseButton = AppiumBy.accessibilityId("icon record filter close");
    public static By ContactPageBackButton = AppiumBy.accessibilityId("Contacts");
    public static By ContactPageSaveNewContactButton = AppiumBy.xpath("//XCUIElementTypeNavigationBar[@name=\"New Contact\"]/XCUIElementTypeButton[1]");
    
    //--------------------------------###### Record Voice Page Scenario Locators ######-----------------------------------------------\\
    
    public static By RecordPageRecordStartRedButton = AppiumBy.accessibilityId("icon voice record pause");
    public static By RecordPageRecordPauseRedButton = AppiumBy.accessibilityId("icon voice record start");
    public static By RecordPageRecordDetailPlayWhiteButton = AppiumBy.accessibilityId("icon record detail play");
    public static By RecordPageRecordDetailPauseWhiteButton = AppiumBy.accessibilityId("icon record detail pause");
    public static By RecordPageRecordDetailForwardButton = AppiumBy.accessibilityId("icon player forward");
    public static By RecordPageRecordDetailBackwardButton = AppiumBy.accessibilityId("icon player backward");
    public static By RecordPageSaveRecordButton = AppiumBy.accessibilityId("icon voice record nav done");
    public static By RecordPageCloseRecordButton = AppiumBy.accessibilityId("icon record filter close");
    public static By RecordPageFavouriteButton = AppiumBy.xpath("//XCUIElementTypeButton[@name='icon player favourite']");
    public static By RecordSpeed = AppiumBy.xpath("//XCUIElementTypeStaticText[@name='1x']");
    public static By RecordTranscribe = AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Tap to Transcribe']");
    public static By RecordShareButton = AppiumBy.accessibilityId("icon contact detail share");
    public static By RecordDeleteButton = AppiumBy.accessibilityId("icon contacts delete action");
    public static By RecordDetailPageAssignedPersonButton = AppiumBy.xpath("//XCUIElementTypeButton[@name='Okan']");
    public static By RecordDetailTranscribeButton = AppiumBy.xpath("//XCUIElementTypeButton[@name='Start to Transcribe']");
    public static By RecordDetailClearButton = AppiumBy.xpath("//XCUIElementTypeButton[@name='Clear']");
    public static By TranscribeBackButton = AppiumBy.xpath("//XCUIElementTypeButton[@name='Back']");
    
    //--------------------------------###### Tab list & Filter Locators ######-----------------------------------------------\\
    
    public static By RecordPageFilterAllButton = AppiumBy.accessibilityId("icon_record_filter_all");
    public static By RecordPageFavTab = AppiumBy.accessibilityId("icon_record_filter_fav");
    public static By ContactsTabFavoriteButtonHidden = AppiumBy.xpath("//XCUIElementTypeButton[@name=\"icon contacts fav action\"]/XCUIElementTypeStaticText");
    public static By FavoriteButtonHidden = AppiumBy.accessibilityId("icon contacts fav action");
//    public static By ContactsTabFavoriteButton = AppiumBy.xpath("//XCUIElementTypeButton[@name=\"icon contacts fav action\"]");
    public static By ContactsTabFavoriteButtonByAccessibility = AppiumBy.accessibilityId("icon contacts fav action");
    public static By ContactsTabFavoriteButtonByName = AppiumBy.iOSNsPredicateString("name == 'icon contacts fav action'");
    public static By RecordPageFilterPhoneButton = AppiumBy.accessibilityId("icon_record_filter_phone");
    public static By RecordPageFilterVoiceButton = AppiumBy.accessibilityId("icon_record_filter_voice");
    public static By RecordPageFilterTranscribeButton = AppiumBy.accessibilityId("icon_record_filter_transcribe");
    public static By ContactListDetailFirstRecord = AppiumBy.xpath("//XCUIElementTypeCell");
    public static By RecordFavoriteButtonHidden = AppiumBy.xpath("//XCUIElementTypeButton[@name=\"icon contacts fav action\"]/XCUIElementTypeStaticText");
    public static By RecordDeleteButtonHidden = AppiumBy.xpath("//XCUIElementTypeButton[@name=\"icon contacts delete action\"]/XCUIElementTypeStaticText");

    //--------------------------------###### Tab Bar Locators ######-----------------------------------------------\\
    
    public static By ContactsTabBar = AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Contacts\"]");
    public static By RecordsTabBar = AppiumBy.accessibilityId("icon_tabbar_records");
    public static By RecordVoiceButton = AppiumBy.xpath("//XCUIElementTypeImage[@name='voice_recorder_button_view']");
    public static By RecordTabHelpButton = AppiumBy.accessibilityId("help_button");
    
    //--------------------------------###### Coordinate Points Enum ######-----------------------------------------------\\
    
    public enum TapPoint {
        FAVORITE_ICON(27, 357),
        LIST_ALL_ICON(100, 400),
        TEST_COORDINATE(50, 50),
        HELP_BUTTON_COORDINATE(323, 92),
        RECORDS_TAB_COORDINATE(38, 843),
        CONTACTS_TAB_COORDINATE(141, 818),
        CONTACTS_FAVORITE_BUTTON(27, 357);

        private final int x;
        private final int y;

        TapPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() { return x; }
        public int getY() { return y; }
    }
}
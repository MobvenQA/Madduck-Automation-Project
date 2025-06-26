package com.mobvenCallRecorder.pages;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ElementsPage extends BasePage {
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
    public static By hiddenFavoriteButton = AppiumBy.accessibilityId("icon contacts fav action");
    public static By contactPageCallButton = AppiumBy.accessibilityId("icon phone call");
    public static By contactPageRecordVoiceButton = AppiumBy.accessibilityId("icon voice recorder");
    public static By contactDetailPageCloseButton = AppiumBy.accessibilityId("icon record filter close");
    public static By contactPageBackButton = AppiumBy.accessibilityId("Contacts");
    public static By contactPageSaveNewContactButton = AppiumBy.xpath("//XCUIElementTypeNavigationBar[@name=\"New Contact\"]/XCUIElementTypeButton[1]");

//--------------------------------###### Record Tab Scenario Locators ######-----------------------------------------------\\

    public static By recordPageRecordPauseRedButton = AppiumBy.accessibilityId("icon voice record pause");
    public static By recordPageRecordStartRedButton = AppiumBy.accessibilityId("icon voice record start");
    public static By recordPageRecordDetailPlayWhiteButton = AppiumBy.accessibilityId("icon record detail play");
    public static By recordPageRecordDetailPauseWhiteButton = AppiumBy.accessibilityId("icon record detail pause");
    public static By recordPageRecordDetailForwardButton = AppiumBy.accessibilityId("icon player forward");
    public static By recordPageRecordDetailBackwardButton = AppiumBy.accessibilityId("icon player backward");
    public static By recordPageSaveRecordButton = AppiumBy.accessibilityId("icon voice record nav done");
    public static By recordPageCloseRecordButton = AppiumBy.accessibilityId("icon record filter close");
    public static By recordPageFavouriteButton = AppiumBy.xpath("//XCUIElementTypeButton[@name='icon player favourite']");
    public static By recordSpeed = AppiumBy.xpath("//XCUIElementTypeStaticText[@name='1x']");
    public static By recordDetailStartToTranscribeButton = AppiumBy.accessibilityId("recordDetailTranscribeButton"); // TabPoint kullanılabilir
    // public static By recordTranscribe = AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Tap to Transcribe']"); -> xpath for recordDetailStartToTranscribeButton
    public static By recordPageAssignToContactButton = AppiumBy.accessibilityId("Assign to a contact");
    public static By assignToContactSearchBar = AppiumBy.accessibilityId("Search contact");
    public static By recordShareButton = AppiumBy.accessibilityId("icon contact detail share");
    public static By recordDetailDeleteRecordButton = AppiumBy.accessibilityId("icon contacts delete action");
    public static By recordDetailPageAssignedPersonButton = AppiumBy.xpath("//XCUIElementTypeButton[@name='Okan']");
    public static By recordDetailTranscribeButton = AppiumBy.accessibilityId("Tap to Transcribe");
    public static By recordDetailClearButton = AppiumBy.xpath("//XCUIElementTypeButton[@name='Clear']");
    public static By transcribeBackButton = AppiumBy.xpath("//XCUIElementTypeButton[@name='Back']");
    public static By recordTabRecordVoiceButton = AppiumBy.accessibilityId("icon_voice_recorder");
    public static By recordTabRecordCallButton = AppiumBy.accessibilityId("icon_phone_call");

//--------------------------------###### Tab list & Filter Locators ######-----------------------------------------------\\

    public static By recordPageFilterAllButton = AppiumBy.accessibilityId("icon_record_filter_all");
    public static By recordPageFavTab = AppiumBy.accessibilityId("icon_record_filter_fav");
    public static By recordPagePhoneFilter = AppiumBy.accessibilityId("icon_record_filter_phone");
    public static By recordPageFilterVoiceButton = AppiumBy.accessibilityId("icon_record_filter_voice");
    public static By recordPageFilterTranscribeButton = AppiumBy.accessibilityId("icon_record_filter_transcribe");
    public static By contactListDetailFirstRecord = AppiumBy.xpath("//XCUIElementTypeCell");

//--------------------------------###### Tab Bar Locators ######-----------------------------------------------\\

    public static By contactsTabBar = AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Contacts\"]");
    public static By recordsTabBar = AppiumBy.accessibilityId("icon_tabbar_records");
    public static By recordTabHelpButton = AppiumBy.accessibilityId("help_button");
    

}
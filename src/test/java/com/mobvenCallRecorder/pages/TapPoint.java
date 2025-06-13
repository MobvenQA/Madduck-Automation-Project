package com.mobvenCallRecorder.pages;

public enum TapPoint {
    //-------- Contacts Locators-----------
    Contacts_First_User(0, 184),
    Contacts_Tab_Button(141, 818),
    Add_New_Button(359,44),
    Close_Contact_Detail_Page(355,60),
    List_All_Tab_Records_Page(27,357),
    ContactFavoriteButtonHidden(6,184),
    DeletePopUpDeleteButton(207,490),
    ContactWithFavorite(0,184),
    AfterSearchBarFirstContact(0,249);
    //-------- New Contact Bottom Sheet Locators-----------
 /*   New_Contact_Name(16,242),
    New_Contact_Phone(16,495),
    Contacts_Voice_Record_Button(213, 205),
    Voice_Record_Red_Button(167, 766),
    Voice_Record_Save_Button(12 , 60),
    Contact_Page_Back_Button(0,44),
    Record_Page_Favourite_Button(16,763),
    Record_Speed(372,763),
    Record_Transcribe(156,558),
    Record_Share_Button(16,829),
    Record_Delete_Button(370,829),
    Record_Detail_Page_Assigned_Person_Button(76,114),
    Record_Detail_Transcribe_Button(16,814),
    Record_Detail_Clear_Button(332,658),


    //-------- Onboarding Locators-----------
    Onboarding_Continue_Button(16,760), //
    Paywall_Purchase_Button(16,732),
    //-------- Login Locators-----------
    Otp_Continue_button(8,436);

*/
    private final int x;
    private final int y;

    TapPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
} 
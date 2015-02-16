# AndroidLocalization

Localization Example in three languages 

  + Hindi 
  + English 
  + Tamil

The Application when Loads is always English.

To use the localization Go to the menu in toolbar and select Settings.

This is a single Page Application.

The user is navigated to the Preference page (Settings) Page and there from the Preference XML page is being loaded with the list preference there user needs to select the language and the application refreshes itself to load in the user selected language.

The Structure of the Application is 

  - res
    - XML
      - Pref.Xml ( Find the Preference XML UI page)
    - res
      - Activity.xml ( The Onload Page )
      - Toolbar.xml ( The toolbar in the preference Page to Appear )
    - values
      - array.xml ( The values for the ListPreference )
      - String.xml ( The values in English )
      - Styles.xml ( The background, toolbar and few other Style things )
    - values-hi
      - array.xml ( The values for the ListPreference )
      - String.xml ( The values in Hindi )
      - Styles.xml ( The background, toolbar and few other Style things ) 
    - values-ta
      - array.xml ( The values for the ListPreference )
      - String.xml ( The values in Tamil )
      - Styles.xml ( The background, toolbar and few other Style things )

The Toolbar was not appearing in the Preference Xml Page so it has been also fixed by adding a toolbar.xml page.


The UI and Working is as Follows: 

The Welcome Screen when App is Loaded :

![alt tag](https://github.com/pramodmg/AndroidLocalization/blob/master/ScreenShots/Welcome.png)

The ToolBar Selection Screen:

![alt tag](https://github.com/pramodmg/AndroidLocalization/blob/master/ScreenShots/ToolbarMenu.png)

The Preference Page Selection:

![alt tag](https://github.com/pramodmg/AndroidLocalization/blob/master/ScreenShots/PreferencePage.png)

The Menu Preference In the preference Page:

![alt tag](https://github.com/pramodmg/AndroidLocalization/blob/master/ScreenShots/LanguageSelect.png)

The Output after Selecting the Hindi from the preference List:

![alt tag](https://github.com/pramodmg/AndroidLocalization/blob/master/ScreenShots/LanguageSelected.png)

Thank You For Following.

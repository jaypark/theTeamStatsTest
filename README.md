# theTeamStatsTest
Test navigating to the Team Stats page on an Android theScore app.

## Description
This is an initial stage of building out a test automation framework for theScore Android app. It has a basic test to 1) go through the onboarding flow and 2) to actually find a sports team’s stats page in a data-driven fashion.  It should have enough of the basic foundation to build upon to increase test coverage.

## Prerequisites
Ensure these are installed on your local environment.
* Appium 2.5 (can be other versions).
* Java 11 (can be other versions)
* Android emulator (e.g. via Android Studio)
* Mac OS (can be other OS’s, but the steps are Mac OS-specific).

## Setup
* Clone this project on your local.
   * `Git clone https://github.com/jaypark/theTeamStatsTest.git`
* Download the theScore APK (v.24.2.0) from the following location to your local folder (e.g. Downloads) and note its location:
   * https://www.apkmirror.com/apk/thescore-inc/thescore-live-sports-scores-news-stats-videos/thescore-live-sports-scores-news-stats-videos-24-2-0-release/thescore-sports-news-scores-24-2-0-android-apk-download/
* Start your Appium server.
   * `appium --base-path=/wd/hub`
* Start up your Android emulator.
* Update `…/theScoreTest/resources/config/config.properties` with your DesiredCapabilities info.
* Optionally, add additional Teams, if you wish, to the `.../theScoreTest/resources/testData/Userdata.xlsx` file for the data-driven tests.

## Running the tests
* In Terminal, navigate to the project directory.
   * E.g. `~/theScoreTest`
* From the project folder (i.e. theScoreTest), run
   * `mvn compile`
   * `mvn test`

## Results
* Maven log
   * http://tiny.cc/teamTestsRun_mvnLog
* Video of tests run on Android emulator
   * http://tiny.cc/teamStatsTestRun

## Coverage
### What’s covered
* It goes through the entire onboarding flow.
* At the main page, we search for various teams and navigate to their Team Stats page.
* The current test data file contains only 3 teams, but more can be added.

### What’s not covered
* It does not have the log in flow, so the entire tests are based on logged-out state.
* Anything other than the team search and navigating to the Team Stats page is not covered.
* Although one of the assessment requirements was to verify that the content inside the sub-menu tab (e.g. Team Stats) correctly corresponds to the team that was originally selected, there was no content in the Team Stats page (not the static header of the entire screen) that was corresponding to the team. Hence, this assertion was not covered.


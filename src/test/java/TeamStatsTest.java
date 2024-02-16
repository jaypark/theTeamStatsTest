import enums.LocationAllowOption;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utils.DataProviders;
import widgets.*;

/**
 * All Team Stats-related tests.
 */
@Log4j2
public class TeamStatsTest extends BaseTest {
    @BeforeClass
    public void testOnboarding() throws InterruptedException {

        final String teamName = "Los Angeles Lakers";
        // On the Welcome page
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.getGetStartedBtn().click();

        // On the legal page
        // TODO: Refactor if the legal page appears only for CA and/or if the page appears
        //  in different verbiage for other states.
        LegalPage legalPage = new LegalPage(driver);
        legalPage.getContinueBtn().click();

        // back to the Welcome page (not sure why it goes back to the Welcome page)
        welcomePage = new WelcomePage(driver);
        welcomePage.getGetStartedBtn().click();

        // Choose your favorite leagues (not mandatory, so just Continue)
        ChooseFavoriteLeaguesPage chooseFavoriteLeaguesPage = new ChooseFavoriteLeaguesPage(driver);
        chooseFavoriteLeaguesPage.getContinueBtn().click();

        LocationTailoredContent locationPage = new LocationTailoredContent(driver);
        locationPage.getAllowLocationBtn().click();

        LocationAccess locationAccessPage = new LocationAccess(driver);
        locationAccessPage.selectAllowOption(LocationAllowOption.WHILE_USING_APP);

        ChooseFavoriteTeamsPage chooseFavoriteTeamsPage = new ChooseFavoriteTeamsPage(driver);
        chooseFavoriteTeamsPage.search(teamName);
        chooseFavoriteTeamsPage.makeRowFavorite(teamName);
        // TODO: Check that making a row favorite would display the logo and team/league name at the top.
        //       This will require a separate mapping of the team/league name to the abbreviated name
        //       to check in the favorite section.
        chooseFavoriteTeamsPage.getContinueBtn().click();

        NeverMissAGamePage onboardingPage = new NeverMissAGamePage(driver);
        onboardingPage.getDoneBtn().click();

        AllowNotifications allowNotifications = new AllowNotifications(driver);
        allowNotifications.getNotAllowBtn().click();
    }

    @Test(dataProvider = "TeamNames", dataProviderClass = DataProviders.class,
            testName = "testTeamStat",
            description = "Verify that the searched team's stat page can be opened correctly.")
    public void testTeamStat(String teamName) throws InterruptedException {
        log.info("Team Name: " + teamName);

        TopSearchBar topSearchBar = new TopSearchBar(driver);
        topSearchBar.getSearchBar().click(); // just to move into the main search page.
        MainSearchPage mainSearchPage = new MainSearchPage(driver);
        mainSearchPage.searchForTeam(teamName);
        mainSearchPage.selectRowByNameOnFirstResultsPage(teamName);

        TeamPage teamPage = new TeamPage(driver);
        Assert.assertTrue(teamPage.getTeamName().getText().toLowerCase().contains(teamName.toLowerCase()),
                "(May not be the correct team page.)");

        teamPage.goToTeamStatsSubMenu();
        TeamStatsPage teamStatsPage = new TeamStatsPage(driver);
        Assert.assertTrue(teamStatsPage.getHeaderCol1().getText().contains("STATS"),
                "(The STATS header was not found.)");
        Assert.assertEquals(teamStatsPage.getHeaderCol2().getText(), "(RANK)",
                "(The (RANK) header was not found.)");

        // Verify that the Back navigation goes to the proper previous page.
        TopNavigation topNavigation = new TopNavigation(driver);
        topNavigation.goToPreviousPage();
        mainSearchPage = new MainSearchPage(driver);
        Assert.assertEquals(mainSearchPage.getTypableSearchBar().getText(), "Teams, Players, and News",
                "(Didn't return to the proper previous page.");

        // Go back once more, just to reset for the next test.
        topNavigation.goToPreviousPage();
    }
}

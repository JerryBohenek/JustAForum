package tests;

import config.TestConfig;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import util.Data;

public class MyPostsTest extends TestConfig {

    @Test
    public void testSubmitFormWithExistingUsername() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.goToLoginPage();

        loginPage.fillInUsernameAndPassword(Data.USERNAME, Data.PASSWORD);
        loginPage.submitForm();

        homePage.goMyPostsPage();
    }

}

package testhomepage;

import base.CommonAPI;
import homepage.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestHomePage extends CommonAPI {

    @Test
    public void testGoToUSPage (){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.goToUsPage();
    }


}

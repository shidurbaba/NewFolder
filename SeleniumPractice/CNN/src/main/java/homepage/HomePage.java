package homepage;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends CommonAPI {

    @FindBy (how = How.LINK_TEXT, using = "U.S.")
    public static WebElement usaPage;

    public void goToUsPage()
    {
        usaPage.click();
    }
}

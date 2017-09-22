package objectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GmailDemo {

    @FindBy (how = How.LINK_TEXT,  using = "Gmail")
    public static WebElement gmailLink;


    public void clickLink(){
        gmailLink.click();
    }


}

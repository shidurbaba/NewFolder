package testpackage;

import common.SimpleFrameWork;
import objectmodel.GmailDemo;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestGmail extends SimpleFrameWork {

    @Test
    public void testGmailLink(){
        GmailDemo obj = PageFactory.initElements(driver, GmailDemo.class);
        obj.clickLink();

    }
}

package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutPage {
    @FindBy(className = "h1-mktg")
    WebElement tittleAbout;

    public  AboutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void verifyClickingAboutButtonRedirectsToAboutPage(){
        Assert.assertEquals(tittleAbout.getText(), "Let's build from here");
    }
}

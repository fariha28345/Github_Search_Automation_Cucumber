package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    @FindBy(className = "octicon-search")
    List<WebElement> searchIcon;
    @FindBy(id = "query-builder-test")
    WebElement searchBar;
    @FindBy(partialLinkText = "About")
    WebElement btnAbout;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void search(String searchOption) {
        searchIcon.get(0).click();
        searchBar.sendKeys(searchOption);
    }

    public void clickEnterButton() throws InterruptedException {
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    public void clickAboutButton() {
        btnAbout.click();
    }

}

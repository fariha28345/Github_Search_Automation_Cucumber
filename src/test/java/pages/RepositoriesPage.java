package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RepositoriesPage {
    @FindBy(className = "search-match")
    List<WebElement> repoName;

    public RepositoriesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void verifyFirstResult(String searchResult){
        Assert.assertEquals(repoName.get(0).getText(), searchResult);
    }
}

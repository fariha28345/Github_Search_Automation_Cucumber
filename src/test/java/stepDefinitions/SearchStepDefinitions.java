package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import pages.AboutPage;
import pages.HomePage;
import pages.RepositoriesPage;
import setup.BrowserSetup;

public class SearchStepDefinitions extends BrowserSetup {
    HomePage homePage;
    RepositoriesPage repoPage;
    AboutPage aboutPage;
    @Given("user visits the github website")
    public void user_visits_the_github_website() {
        driver.get("https://github.com/");
    }
    @When("user search for the term by name {string}")
    public void user_search_for_the_term_by_name(String searchOption) {
        homePage = new HomePage(driver);
        homePage.search(searchOption);
    }
    @When("user clicks enter")
    public void user_clicks_enter() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.clickEnterButton();
    }
    @Then("user finds {string} as the first result")
    public void user_finds_as_the_first_result(String searchResult){
        repoPage = new RepositoriesPage(driver);
        repoPage.verifyFirstResult(searchResult);
    }

    @Given("user scroll down to the page footer")
    public void user_scroll_down_to_the_page_footer() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

    }

    @When("user clicks on about button")
    public void user_clicks_on_about_button() {
        homePage = new HomePage(driver);
        homePage.clickAboutButton();
    }
    @Then("user redirects to about page")
    public void user_redirects_to_about_page() {
        aboutPage = new AboutPage(driver);
        aboutPage.verifyClickingAboutButtonRedirectsToAboutPage();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

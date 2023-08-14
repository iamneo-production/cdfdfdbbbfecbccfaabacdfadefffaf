public class WikipediaSearchSteps {
    private WikipediaHomePage wikipediaHomePage;

    public WikipediaSearchSteps(WikipediaHomePage wikipediaHomePage) {
        this.wikipediaHomePage = wikipediaHomePage;
    }

    @Given("I am on the Wikipedia home page")
    public void openWikipediaHomePage() {
        wikipediaHomePage.openHomePage();
    }

    @When("I select the language {string}")
    public void selectLanguage(String language) {
        wikipediaHomePage.selectLanguage(language);
    }

    @And("I search for the term {string}")
    public void searchForTerm(String searchTerm) {
        wikipediaHomePage.searchForTerm(searchTerm);
    }

    @Then("I should see search results related to {string}")
    public void verifySearchResults(String expectedTerm) {
        // Implement verification of search results containing the expectedTerm
    }
}
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class WikipediaLinkSteps {
    private WebDriver driver;
    private WikipediaArticlePage wikipediaArticlePage;

    public WikipediaLinkSteps() {
        // Initialize your WebDriver instance here
        driver = new WebDriver(); // Example, you should use your actual WebDriver setup

        wikipediaArticlePage = new WikipediaArticlePage(driver);
    }

    @Given("I am on the Wikipedia article page for {string}")
    public void openArticlePage(String articleTitle) {
        // Navigate to the article page
        wikipediaArticlePage.openArticlePage(articleTitle);
    }

    @When("I click on the embedded link {string}")
    public void clickEmbeddedLink(String linkedText) {
        wikipediaArticlePage.clickEmbeddedLink(linkedText);
    }

    @Then("I should be redirected to the Wikipedia article page for {string}")
    public void verifyRedirectedArticle(String expectedArticleTitle) {
        // Implement verification of the current page's title containing the expectedArticleTitle
    }
}
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class WikipediaHistorySteps {
    private WebDriver driver;
    private WikipediaArticlePage wikipediaArticlePage;
    private WikipediaHistoryPage wikipediaHistoryPage;

    public WikipediaHistorySteps() {
        // Initialize your WebDriver instance here
        driver = new WebDriver(); // Example, you should use your actual WebDriver setup

        wikipediaArticlePage = new WikipediaArticlePage(driver);
        wikipediaHistoryPage = new WikipediaHistoryPage(driver);
    }

    @Given("I am on the Wikipedia article page for {string}")
    public void openArticlePage(String articleTitle) {
        // Navigate to the article page
        wikipediaArticlePage.openArticlePage(articleTitle);
    }

    @When("I click on the \"View history\" link")
    public void clickViewHistoryLink() {
        wikipediaArticlePage.clickViewHistoryLink();
    }

    @Then("I should be on the history page for the article {string}")
    public void verifyHistoryPage(String expectedArticleTitle) {
        // Implement verification logic to ensure the current page's title matches the expectedArticleTitle
    }
}

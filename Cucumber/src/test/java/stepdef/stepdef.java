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
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import static org.hamcrest.MatcherAssert.assertThat;

public class JsonPlaceholderSteps {
    private Response response;

    @When("I request the user with ID {int}")
    public void requestUserById(int userId) {
        response = RestAssured.get("https://jsonplaceholder.typicode.com/users/" + userId);
    }

    @When("I request the list of posts")
    public void requestListOfPosts() {
        response = RestAssured.get("https://jsonplaceholder.typicode.com/posts");
    }

    @When("I request the post with ID {int}")
    public void requestPostById(int postId) {
        response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/" + postId);
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    @Then("the response should contain the username {string}")
    public void verifyUsername(String expectedUsername) {
        response.then().body("username", Matchers.equalTo(expectedUsername));
    }

    @Then("the response should contain at least {int} posts")
    public void verifyPostCount(int expectedPostCount) {
        response.then().body("", Matchers.hasSize(Matchers.greaterThanOrEqualTo(expectedPostCount)));
    }

    @Then("the response should contain the title {string}")
    public void verifyTitle(String expectedTitle) {
        response.then().body("title", Matchers.equalTo(expectedTitle));
    }
}
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyStepDefinitions {
    private static final Logger logger = LoggerFactory.getLogger(MyStepDefinitions.class);

    // ... your step definitions and methods ...

    @Given("I perform an action")
    public void performAction() {
        logger.info("Performing an action...");
        // Your code here
    }
}
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;

public class ExtentReportListener implements ConcurrentEventListener {
    private ExtentReports extent;
    private ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public ExtentReportListener() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("target/extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepFinished.class, this::handleTestStepFinished);
    }

    private void handleTestStepFinished(TestStepFinished event) {
        if (event.getTestStep() instanceof PickleStepTestStep) {
            PickleStepTestStep testStep = (PickleStepTestStep) event.getTestStep();
            String stepName = testStep.getStep().getText();
            if (event.getResult().getStatus() == Result.Type.PASSED) {
                test.get().pass(stepName);
            } else if (event.getResult().getStatus() == Result.Type.FAILED) {
                test.get().fail(stepName);
            } else {
                test.get().skip(stepName);
            }
        }
    }
}

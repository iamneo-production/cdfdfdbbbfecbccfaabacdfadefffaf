import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class StepDefinitions {
    private WebDriver driver;
    private WikipediaHomePage wikipediaHomePage;
    private WikipediaSearchSteps wikipediaSearchSteps;

    public StepDefinitions() {
        // Initialize your WebDriver instance here
        driver = new WebDriver(); // Example, you should use your actual WebDriver setup

        wikipediaHomePage = new WikipediaHomePage(driver);
        wikipediaSearchSteps = new WikipediaSearchSteps(wikipediaHomePage);
    }

    // Cucumber step definitions will be called from the WikipediaSearchSteps class
}

public class WikipediaHomePage {
    private WebDriver driver;

    public WikipediaHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        // Navigate to the Wikipedia home page
    }

    public void selectLanguage(String language) {
        // Locate and select the language on the page
    }

    public void searchForTerm(String searchTerm) {
        // Enter the search term and submit the search
    }
}
public class WikipediaArticlePage {
    private WebDriver driver;

    public WikipediaArticlePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openArticlePage(String articleTitle) {
        // Navigate to the Wikipedia article page based on the articleTitle
    }

    public void clickEmbeddedLink(String linkedText) {
        // Click on the embedded link with the specified linkedText
    }
}
public class WikipediaArticlePage {
    private WebDriver driver;

    public WikipediaArticlePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openArticlePage(String articleTitle) {
        // Navigate to the Wikipedia article page based on the articleTitle
    }

    public void clickViewHistoryLink() {
        // Click on the "View history" link
    }
}
public class WikipediaHistoryPage {
    private WebDriver driver;

    public WikipediaHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Additional methods for interacting with the history page can be defined here
}

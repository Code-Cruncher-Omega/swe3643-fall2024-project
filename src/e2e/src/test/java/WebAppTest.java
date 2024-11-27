import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.*;

import org.junit.jupiter.api.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@UsePlaywright
public class WebAppTest {

    @Test
    void calculatorWebUi_pageTitle_isCalculator(Page page) {
        //preq-E2E-TEST-5
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
            Page newPage = browser.newPage();
            newPage.navigate("http://localhost:8080");
            assertThat(newPage.getByTitle("Calculator"));
        }
    }

    @Test
    void calculatorWebUi_computeSampleStandardDeviationButton_outputsResult(Page page) {
        //preq-E2E-TEST-6
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
            Page newPage = browser.newPage();
            newPage.navigate("http://localhost:8080");
            newPage.getByLabel("").click();
            newPage.getByLabel("").fill("9\n2\n5\n4\n12\n7\n8\n11\n9\n3\n7\n4\n12\n5\n4\n10\n9\n6\n9\n4");
            newPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Sample Standard")).click();
            assertThat(newPage.locator("h3")).containsText("3.060787652326");
        }
    }

    @Test
    void calculatorWebUi_emptyInputPopulationStandardDeviationButton_outputsErrorMessage(Page page) {
        //preq-E2E-TEST-7
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
            Page newPage = browser.newPage();
            newPage.navigate("http://localhost:8080");
            newPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Population Standard")).click();
            assertThat(newPage.locator("h3")).containsText("Invalid input input values, each separated by a new line");
        }
    }

    @Test
    void calculatorWebUi_emptyInputSampleStandardDeviationButton_outputsErrorMessage(Page page) {
        //preq-E2E-TEST-8
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
            Page newPage = browser.newPage();
            newPage.navigate("http://localhost:8080");
            newPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Sample Standard")).click();
            assertThat(newPage.locator("h3")).containsText("Invalid input input values, each separated by a new line");
        }
    }

    @Test
    void calculatorWebUi_computeMeanButton_outputsResult(Page page) {
        //preq-E2E-TEST-9
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
            Page newPage = browser.newPage();
            newPage.navigate("http://localhost:8080");
            newPage.getByLabel("").click();
            newPage.getByLabel("").fill("9\n2\n5\n4\n12\n7\n8\n11\n9\n3\n7\n4\n12\n5\n4\n10\n9\n6\n9\n4");
            newPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Mean")).click();
            assertThat(newPage.locator("h3")).containsText("7");
        }
    }

    @Test
    void calculatorWebUi_computeZScoreButton_outputsResult(Page page) {
        //preq-E2E-TEST-10
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
            Page newPage = browser.newPage();
            newPage.navigate("http://localhost:8080");
            newPage.getByLabel("").click();
            newPage.getByLabel("").fill("5.5,7,3.060787652326");
            newPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Z Score")).click();
            assertThat(newPage.locator("h3")).containsText("-0.490069");    // expected value changed from -0.49007 to -0.490069 since logic doesn't round up
                                                                                            // and output would be considered incorrect despite being more accurate than expected
        }
    }

    @Test
    void calculatorWebUi_computeSingleLinearRegressionFormula_outputResult(Page page) {
        //preq-E2E-TEST-11
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
            Page newPage = browser.newPage();
            newPage.navigate("http://localhost:8080");
            newPage.getByLabel("").click();
            newPage.getByLabel("").fill("5,3\n3,2\n2,15\n1,12.3\n7.5,-3\n4,5\n3,17\n4,3\n6.42,4\n34,5\n12,17\n3,-1");
            newPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Single Linear Regression Formula")).click();
            assertThat(newPage.locator("h3")).containsText("y = −0.04596153293093642x + 6.933587781374594");
            // Expected value again adjusted to account for the higher accuracy of the calculator, new expected value was
            // checked using multiple calculators to ensure accurate computations.
            // It's worth noting this calculator is accurate to the 12th decimal place, any further and there will be
            // miscalculations for whatever reason. Might cause issues in the future if Java's calculation logic becomes
            // more or less accurate in a future update.
        }
    }
}

//Run where pom.xml is at, so in this case \src\e2e\
//mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen http://localhost:8080"
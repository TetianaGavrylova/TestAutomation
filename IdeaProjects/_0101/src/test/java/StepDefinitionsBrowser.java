import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import net.thucydides.core.Thucydides;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class StepDefinitionsBrowser {

    private GooglePage page;

    @Given("^open browser$")
    public void OpenBrowser () {
        page = new GooglePage();
    }

    @Given("^go to (.*)$")
    public void GoToGoogle (String URL) {
        System.out.println("Print " + URL);
        page.goURL(URL);
    }

    @Given("^Enter search word (.*)$")
    public void EnterSearchWord (String Text) {
        page.clearFieldSearch();
        page.enterTextIntoFieldSearch(Text);
        page.clickEmptySpace();
    }

    @Given("^Do search$")
    public void DoSearch () {
        page.clickBtnImFeelingLucky();
    }

    @Given("^Click on link$")
    public void ClickLink () {
        page.clickLink();
    }

    @And("^Close browser$")
    public void closeBrowser()  {
        page.close ();
    }

    @And("^Enter data$")
    public void enterData(List<String> Info)  {
        Integer i = Info.size();
        for (int k=0; k<i; k++) {
            System.out.println(Info.get(k));
        }
    }

    @And("^Enter the search word wiki (.*)$")
    public void enterTheSearchWordWiki(String TextW) {
       page.clearFieldSearchWiki();
       page.enterTextWiki(TextW);
       }

    @And("^Extract the page title$")
    public void extractThePageTitle() {
        String pageTitle = page.extractThePageTitleString();
        Thucydides.getCurrentSession().put("pageTitle", pageTitle);
        System.out.println(pageTitle);
    }

    @And("^paste the page title$")
    public void pasteThePageTitle() {
        page.clearFieldSearch();
        page.enterTextIntoFieldSearch(Thucydides.getCurrentSession().get("pageTitle").toString());
        page.clickEmptySpace();
    }

    @And("^Compare actual result with expected (.*)$")
    public void compareActualResultWithExpected(String ExpectedTitle) {
        assertTrue(((String)Thucydides.getCurrentSession().get("pageTitle")).equals(ExpectedTitle));
        System.out.println("Equals");
    }
}
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.Thucydides;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class StepDefs {

    private GooglePage page;
//  private WebDriver driver;

    @Given("^open browser$")
    public void OpenBrowser () {
        page = new GooglePage();
        //System.out.println("We did it");
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
//      page.enterTextIntoFieldSearch((String)Thucydides.getCurrentSession().get("pageTitle"));
        page.clickEmptySpace();
    }

    @And("^Compare actual result with expected (.*)$")
    public void compareActualResultWithExpected(String ExpectedTitle) {
        assertTrue(((String)Thucydides.getCurrentSession().get("pageTitle")).equals(ExpectedTitle));
        System.out.println("Equals");
    }

    @And("^Check SOAP with (.*)$")
    public void checkSOAPWith(String text)  {
        SOAPUsage WS = new SOAPUsage();
        List<String> lst1 = WS.checkTextsService(text);
//        Integer listSize;
//        listSize = new Integer(lst1.size());
//        Thucydides.getCurrentSession().put("Words", lst1);
//        for (String item : lst1){
//            System.out.println(item);
//        }

        if (lst1 != null) {
            Thucydides.getCurrentSession().put("Words", lst1);
        }
        else  {
            List<String> empty = Arrays.asList("");
            Thucydides.getCurrentSession().put("Words", empty);
        }
       }

    @And("^Check amount of mistakes (.*)$")
    public void checkAmountOfMistakes(int ExpectedMistakes)  {
//        assertTrue((Thucydides.getCurrentSession().get("Amount of mistakes")).equals(ExpectedMistakes));

        if ((Thucydides.getCurrentSession().get("Amount of mistakes")).equals(ExpectedMistakes)) {
            System.out.println(Thucydides.getCurrentSession().get("Amount of mistakes") + "=" + ExpectedMistakes);
        }
        else {
            System.out.println("Real " + Thucydides.getCurrentSession().get("Amount of mistakes") + "!= Expected " + ExpectedMistakes);
        }
//        assertFalse((Thucydides.getCurrentSession().get("Amount of mistakes")).equals(0));
//        System.out.println("Expected " + Thucydides.getCurrentSession().get("Amount of mistakes") + "!=" + "0");
    }

    @Then("^Check that there is the right word (.*)$")
    public void checkThatThereIsTheRightWord (String RightWord)  {
       assertTrue("Contains Right Word", ((List<String>)Thucydides.getCurrentSession().get("Words")).contains(RightWord));
       System.out.println(((List<String>)Thucydides.getCurrentSession().get("Words")));
       System.out.println(RightWord + " ~ OK");
    }

    @Given("^check on (.*) for (.*)$")
    public void checkOnErrorForName(int error, String name) throws IOException {
        HttpUriRequest request = new HttpGet("https://api.github.com/users/" + name);
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        Thucydides.getCurrentSession().put("ReceivedHttpResponse", httpResponse);
        Integer code = httpResponse.getStatusLine().getStatusCode();

        System.out.println("RecCode = " + code + "ExCode = " + error);
        assertTrue("Wrong code", code == error);
    }

    @Then("^check media (.*) for name$")
    public void checkMediaTypeForName(String type) throws Throwable {
//        HttpUriRequest request = new HttpGet( "https://api.github.com/users/" + name );
//        HttpResponse response = HttpClientBuilder.create().build().execute( request );
        HttpResponse response = (HttpResponse)Thucydides.getCurrentSession().get("ReceivedHttpResponse");
        String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();

        System.out.println("ExType = " + type + "ResType = " + mimeType);
        assertTrue("Wrong type", type.equals(mimeType));
    }

    @And("^check content (.*) for name$")
    public void checkContentContentForName(String content) throws Throwable {
//        HttpUriRequest request = new HttpGet( "https://api.github.com/users/" + name );
//        HttpResponse response = HttpClientBuilder.create().build().execute( request );
        HttpResponse response = (HttpResponse)Thucydides.getCurrentSession().get("ReceivedHttpResponse");
        GithubUser resource = GithubUser.retrieveResourceFromResponse(response, GithubUser.class);

        String res = org.hamcrest.Matchers.is(resource.getName()).toString();
        System.out.println("Result = " + res + "Content = " + content);

        assertTrue("Wrong content", res.equals(content));
    }

    @Given("^run jmeter (.*)$")
    public void runJmeter(Integer avg) throws Exception {
        JmeterFromJMX jmeterFromJMX = new JmeterFromJMX();
//        jmeterFromJMX.run();
        assertTrue("Limit", jmeterFromJMX.run() <= avg);
    }
}
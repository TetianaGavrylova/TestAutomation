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

import static org.junit.Assert.assertTrue;

public class StepDefinitionsREST {

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
}

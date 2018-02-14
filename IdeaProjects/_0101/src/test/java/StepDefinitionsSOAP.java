import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.Thucydides;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class StepDefinitionsSOAP {

    @And("^Check SOAP with (.*)$")
    public void checkSOAPWith(String text)  {
        SOAPUsage WS = new SOAPUsage();
        List<String> lst1 = WS.checkTextsService(text);

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

        if ((Thucydides.getCurrentSession().get("Amount of mistakes")).equals(ExpectedMistakes)) {
            System.out.println(Thucydides.getCurrentSession().get("Amount of mistakes") + "=" + ExpectedMistakes);
        }
        else {
            System.out.println("Real " + Thucydides.getCurrentSession().get("Amount of mistakes") + "!= Expected " + ExpectedMistakes);
        }
    }

    @Then("^Check that there is the right word (.*)$")
    public void checkThatThereIsTheRightWord (String RightWord)  {
        assertTrue("Doesn't contain Right Word \"" +RightWord + "\"", ((List<String>)Thucydides.getCurrentSession().get("Words")).contains(RightWord));
        System.out.println(((List<String>)Thucydides.getCurrentSession().get("Words")));
    }
}

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class StepDefinitionsJmeter {

    @Given("^run jmeter for (.*) users and (.*) loops$")
    public void runJmeter(Integer users, Integer loops) throws Exception {
        JmeterFromJMX jmeterFromJMX = new JmeterFromJMX();
        jmeterFromJMX.createTesteFromTemplate(users, loops);
        jmeterFromJMX.run();
    }

    @Then("^check elapsed max (.*) and average (.*)$")
    public void checkElapsedMaxAndAverage(Integer max, Integer avg) throws Throwable {
        JmeterFromJMX jmeterFromJMX = new JmeterFromJMX();
        List elapsedResult = jmeterFromJMX.checkElapsed();
        Integer elapsedAvg = (Integer) elapsedResult.get(0);
        Integer elapsedMax = (Integer) elapsedResult.get(1);
        assertTrue("Average value of elapsed time " + elapsedAvg + " exceeded permitted value " + avg, elapsedAvg <= avg);
        assertTrue("Maximum value of elapsed time " + elapsedMax + " exceeded permitted value " + max, elapsedMax <= max);
    }
}

import cucumber.api.java.en.Given;

public class StepDefs {
    @Given("^open browser$")
           public void OpenBrowser () {
        System.out.println("We did it");
    }


    @Given("^go to (.*)$")
    public void GoToGoogle (String URL) {
        System.out.println("Print " + URL);
    }
}
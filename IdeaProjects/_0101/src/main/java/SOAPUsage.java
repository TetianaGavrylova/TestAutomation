import net.yandex.speller.services.spellservice.*;

import java.util.List;

public class SOAPUsage {

    public List<String> checkTextsService (String Text) {
        SpellService service = new SpellService();
        SpellServiceSoap port = service.getSpellServiceSoap();
        CheckTextRequest request = new CheckTextRequest();
        request.setLang("en");
        request.setText(Text);
        CheckTextResponse response = port.checkText(request);

        List<SpellError> errorList = response.getSpellResult().getError();
        System.out.println("Error count " + errorList.size());

        List<String> lst = null;
        for (SpellError error : errorList) {
            lst = error.getS();
            }
            return lst;
    }
}

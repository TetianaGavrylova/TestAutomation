import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

public class GithubUser {

    private String login;
    private String id;
    private String name;

    // standard getters and setters
    public GithubUser() {
        super();
    }

    // API
    public String getLogin() {
        return login;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setLogin(final String login) {
        this.login = login;
    }
    public void setId(final String id) {
        this.id = id;
    }
    public void setName(final String name) {
        this.name = name;
    }

    public static <T> T retrieveResourceFromResponse(HttpResponse response, Class<T> clazz)
            throws IOException {

        String jsonFromResponse = EntityUtils.toString(response.getEntity());
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(jsonFromResponse, clazz);
    }

}

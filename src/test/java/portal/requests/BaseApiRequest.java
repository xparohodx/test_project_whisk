package portal.requests;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import portal.utils.configReader.ConfigFileReader;

import java.util.HashMap;
import java.util.Map;

public class BaseApiRequest {

    protected String apiURL = new ConfigFileReader().getApiURL();
    protected String authToken = new ConfigFileReader().getAuthToken();

    Response response;

    public JSONObject setBody(String name, boolean isPrimary) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);
        requestBody.put("primary", isPrimary);
        return requestBody;
    }

    public Map<String, ?> setAuth() {
        Map<String, String> auth = new HashMap<>();
        auth.put("Authorization", "Bearer " + authToken);
        return auth;
    }

    @Step("Check that response status code is correct")
    public BaseApiRequest checkStatusCode(int code) {
        this.response.then().statusCode(code);
        return this;
    }

    @Step("Check that response content type is correct")
    public BaseApiRequest checkContentType(ContentType type) {
        this.response.then().contentType(type);
        return this;
    }

    @Step("Check that response body contains correct values")
    public BaseApiRequest checkValueInResponseBody(String path, String value) {
        this.response.then().body(path, Matchers.equalTo(value));
        return this;
    }

    @Step("Check that response body contains an empty object")
    public BaseApiRequest checkEmptyValueInResponseBody(String path) {
        this.response.then().body(path, Matchers.anEmptyMap());
        return this;
    }

    @Step("Get a string value from request body by a specified path")
    public String getParameterFromRequestBody(String path) {
        return this.response.then().extract().path(path);
    }
}

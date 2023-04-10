package portal.requests;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import portal.utils.configReader.ConfigFileReader;

public class ListApiRequests extends BaseApiRequest {

    @Step("Send POST request")
    public ListApiRequests post(String name, Boolean isPrimary) {
        this.response = RestAssured
                .given()
                .contentType("application/json")
                .headers(setAuth())
                .body(setBody(name, isPrimary))
                .when()
                .post(apiURL);
        return this;
    }

    @Step("Send GET request")
    public ListApiRequests get(String id) {
        this.response = RestAssured
                .given()
                .headers(setAuth())
                .param("id", id)
                .when()
                .get(apiURL + "/" + id);
        return this;
    }

    @Step("Send DELETE request")
    public ListApiRequests delete(String id) {
        this.response = RestAssured
                .given()
                .headers(setAuth())
                .param("id", id)
                .when()
                .delete(apiURL + "/" + id);
        return this;
    }
}
